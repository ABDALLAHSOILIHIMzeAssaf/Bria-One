package org.ldv.briaone.controller.admin

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/utilisateurs")
class GestionUtilisateurController {

    // Afficher la liste des utilisateurs
    @GetMapping
    fun afficherUtilisateurs(model: Model): String {

        model.addAttribute("utilisateurs", emptyList<Any>())
        model.addAttribute("isAdmin", true)
        model.addAttribute("activePage", "users")

        return "admin/utilisateurs"
    }
}