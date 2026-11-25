package org.ldv.briaone.service

import org.ldv.briaone.model.entity.*
import org.springframework.stereotype.Component


@Component
class IAServiceFactory(
    private val services: List<IAService>
) {

    fun getService(modele: ModeleIA): IAService {

        val fournisseur = modele.fournisseur?.nom
            ?: throw IllegalArgumentException(
                "Aucun fournisseur associé au modèle"
            )
// Sélection du service correspondant au fournisseur
        return services.firstOrNull {
            it.getFournisseur().equals(
                fournisseur,
                ignoreCase = true
            )
        } ?: throw IllegalArgumentException(
            "Aucun service disponible pour $fournisseur"
        )
    }
}
