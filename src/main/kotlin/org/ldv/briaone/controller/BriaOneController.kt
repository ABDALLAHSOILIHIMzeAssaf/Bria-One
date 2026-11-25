package org.ldv.briaone.controller

import org.ldv.briaone.model.dao.ConversationDAO
import org.ldv.briaone.model.dao.MessageDAO
import org.ldv.briaone.model.dao.ModeleIADAO
import org.ldv.briaone.model.dao.UtilisateurDAO
import org.ldv.briaone.model.entity.Conversation
import org.ldv.briaone.model.entity.Message
import org.ldv.briaone.model.entity.TypeMessage
import org.ldv.briaone.service.IAServiceFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Controller
class BriaOneController(
    private val iaServiceFactory: IAServiceFactory,
    private val conversationDAO: ConversationDAO,
    private val messageDAO: MessageDAO,
    private val modeleIADAO: ModeleIADAO,
    private val utilisateurDAO: UtilisateurDAO
) {
    // Page d'accueil : liste des conversations
    @GetMapping("/")
    fun accueil(model: Model): String {

        // Retire la conversation courante
        model.addAttribute("conversation", null)

        model.addAttribute("modeles", modeleIADAO.findAll())
        model.addAttribute("messages", emptyList<Message>())
        model.addAttribute("conversations", conversationDAO.findAllByOrderByDateModificationDesc())

        return "accueil"
    }

    // Création d'une nouvelle conversation
    @PostMapping("/conversations")
    fun creerConversation(
        @RequestParam prompt: String,
        @RequestParam idModele: Long
    ): String {

        // Récupération du premier utilisateur en base (pour tester sans erreur de connexion)
        val utilisateur = utilisateurDAO.findAll().firstOrNull()
            ?: throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Aucun utilisateur trouvé en base de données"
            )

        // Récupération du modèle sélectionné
        val modele = modeleIADAO.findById(idModele)
            .orElseThrow {
                ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Modèle IA introuvable"
                )
            }

        // Création de la conversation
        val conversation = Conversation(
            titre = prompt.take(50),
            utilisateur = utilisateur,
            modeleIA = modele
        )

        val conversationEnregistree = conversationDAO.save(conversation)

        // Enregistrement du premier message
        val messageUtilisateur = Message(
            contenu = prompt,
            dateCreation = LocalDateTime.now(),
            typeMessage = TypeMessage.UTILISATEUR,
            conversation = conversationEnregistree
        )

        messageDAO.save(messageUtilisateur)

        try {
            // Sélection automatique du service
            val iaService = iaServiceFactory.getService(modele)

            // Appel du fournisseur correspondant
            val reponse = iaService.envoyerPrompt(prompt, modele)

            // Enregistrement de la réponse de l'assistant
            val messageAssistant = Message(
                contenu = reponse,
                dateCreation = LocalDateTime.now(),
                typeMessage = TypeMessage.ASSISTANT,
                conversation = conversationEnregistree
            )

            messageDAO.save(messageAssistant)

        } catch (e: Exception) {
            println("Erreur lors de l’appel au modèle ${modele.nom} : ${e.message}")
        }

        // Mise à jour de la date de modification
        conversationEnregistree.dateModification = LocalDateTime.now()
        conversationDAO.save(conversationEnregistree)

        return "redirect:/conversations/${conversationEnregistree.id}"
    }
}
