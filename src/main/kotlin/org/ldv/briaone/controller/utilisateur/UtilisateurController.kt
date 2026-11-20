package org.ldv.briaone.controller.utilisateur

import org.ldv.briaone.model.dao.ModeleIADAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UtilisateurController(
    private val modeleIADAO: ModeleIADAO
) {

    // Interface principale
    @GetMapping("/accueil", "/utilisateur/accueil")
    fun accueil(model: Model): String {

        model.addAttribute("modeles", modeleIADAO.findAll())
        model.addAttribute("isAdmin", false)
        model.addAttribute("activePage", "chat")

        return "accueil"
    }
}