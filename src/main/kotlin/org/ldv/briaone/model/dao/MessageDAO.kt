package org.ldv.briaone.model.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.ldv.briaone.model.entity.Message

interface MessageDAO : JpaRepository<Message, Long> {
}