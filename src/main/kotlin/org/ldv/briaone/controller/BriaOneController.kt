package org.ldv.briaone.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BriaOneController {
    @GetMapping("/")
    fun exemple(): String {
        return "accueil"
    }
}