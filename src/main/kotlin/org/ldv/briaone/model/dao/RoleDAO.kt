package org.ldv.briaone.model.dao

import org.ldv.briaone.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {
}