package org.ldv.briaone.model.dao

import org.ldv.briaone.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {


   @Query("select u from Utilisateur u where upper(u.email) = upper(?1)")
   fun findByEmailIgnoreCase(email: String): Utilisateur?


   @Query("select (count(u) > 0) from Utilisateur u where upper(u.email) = upper(?1)")
   fun existsByEmailIgnoreCase(email: String): Boolean
   fun findUtilisateurByEmail(name: String)


}
