package org.ldv.briaone.controller.auth

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/auth")
class AuthController {

    // Page de connexion
    @GetMapping("/connexion")
    fun connexion(): String {
        return "auth/connexion"
    }

    // Page d'inscription
    @GetMapping("/inscription")
    fun inscription(): String {
        return "auth/inscription"
    }
}