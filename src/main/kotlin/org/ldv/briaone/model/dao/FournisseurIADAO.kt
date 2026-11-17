package org.ldv.briaone.model.dao

import org.ldv.briaone.model.entity.FournisseurIA
import org.springframework.data.jpa.repository.JpaRepository

interface FournisseurIADAO : JpaRepository<FournisseurIA, Long> {
}