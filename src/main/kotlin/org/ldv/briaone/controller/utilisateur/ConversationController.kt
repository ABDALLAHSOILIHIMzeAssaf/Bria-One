package org.ldv.briaone.controller.utilisateur

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/utilisateur")
class ConversationController {

    // Historique des conversations
    @GetMapping("/historique")
    fun historique(): String {
        return "redirect:/accueil"
    }

    // Conversations archivées
    @GetMapping("/archives")
    fun archives(): String {
        return "redirect:/accueil"
    }
}