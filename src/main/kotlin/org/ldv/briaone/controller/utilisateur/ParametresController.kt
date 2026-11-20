package org.ldv.briaone.controller.utilisateur

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ParametresController {

    @GetMapping("/parametres")
    fun parametres(): String {
        return "redirect:/accueil"
    }
}