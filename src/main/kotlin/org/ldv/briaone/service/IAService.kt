package org.ldv.briaone.service
import org.ldv.briaone.model.entity.ModeleIA

interface IAService {

    // Identifie le fournisseur pris en charge
    fun getFournisseur(): String

    // Envoie un prompt au modèle choisi
    fun envoyerPrompt(prompt: String, modele: ModeleIA): String
}
