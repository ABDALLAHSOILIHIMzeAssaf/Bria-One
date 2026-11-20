package org.ldv.briaone.controller.admin

import org.ldv.briaone.model.dao.ModeleIADAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/modeles")
class ModeleIAController(
    private val modeleIADAO: ModeleIADAO
) {

    // Afficher les modèles IA
    @GetMapping
    fun afficherModeles(model: Model): String {

        model.addAttribute("modeles", modeleIADAO.findAll())
        model.addAttribute("isAdmin", true)
        model.addAttribute("activePage", "models")

        return "admin/modeles"
    }
}