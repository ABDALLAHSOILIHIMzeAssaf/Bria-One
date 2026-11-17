package org.ldv.briaone.model.dao


import org.ldv.briaone.model.entity.Conversation
import org.springframework.data.jpa.repository.JpaRepository

interface ConversationDAO : JpaRepository<Conversation, Long> {
}