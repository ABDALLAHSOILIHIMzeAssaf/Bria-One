package org.ldv.briaone.model.dao

import org.ldv.briaone.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {
}
