package org.ldv.briaone.model.dao


import org.ldv.briaone.model.entity.Conversation
import org.ldv.briaone.model.entity.Message
import org.ldv.briaone.model.entity.TypeMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

interface ConversationDAO : JpaRepository<Conversation, Long> {

    fun findAllByOrderByDateModificationDesc(): List<Conversation>



}
