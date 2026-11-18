package org.ldv.briaone.model.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.ldv.briaone.model.entity.ModeleIA

interface ModeleIADAO : JpaRepository<ModeleIA, Long> {
}