import org.ldv.briaone.dto.gemini.GeminiChatRequest
import org.ldv.briaone.dto.gemini.GeminiChatResponse
import org.ldv.briaone.dto.gemini.GeminiMessage
import org.ldv.briaone.model.entity.ModeleIA
import org.ldv.briaone.service.IAService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class GeminiService(
    private val restClientBuilder: RestClient.Builder,

    @Value("\${gemini.api.key}")
    private val apiKey: String

) : IAService {
    override fun getFournisseur(): String = "Gemini"

    override fun envoyerPrompt(prompt: String, modele: ModeleIA): String {

        // Étape 1 : Création du message de l'utilisateur
        val message = GeminiMessage(
            role = "user",
            content = prompt
        )

        // Étape 2 : Préparation de la requête pour Gemini
        val request = GeminiChatRequest(
            model = modele.nom,
            messages = listOf(message)
        )

        // Étape 3 : Envoi de la requête HTTP POST à l'API
        val client = restClientBuilder.build()

        val response = client.post()
            .uri(modele.urlAPI ?: "https://googleapis.com")
            .header("Authorization", "Bearer $apiKey")
            .contentType(MediaType.APPLICATION_JSON)
            .body(request)
            .retrieve()
            .body(GeminiChatResponse::class.java)

        // Étape 4 : Récupération du texte de la réponse
        val choix = response?.choices?.firstOrNull()
        val reponse = choix?.message?.content

        if (reponse != null) {
            return reponse
        } else {
            return "Aucune réponse reçue de Gemini."
        }
    }

}

