package org.ldv.briaone.controller.admin

import org.ldv.briaone.model.dao.ModeleIADAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController(
    private val modeleIADAO: ModeleIADAO
) {

    @GetMapping("/admin")
    fun accueilAdmin(model: Model): String {

        model.addAttribute("modeles", modeleIADAO.findAll())
        model.addAttribute("isAdmin", true)
        model.addAttribute("activePage", "chat")

        return "accueil"
    }
}