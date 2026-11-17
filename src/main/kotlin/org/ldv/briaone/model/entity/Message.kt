package org.ldv.briaone.model.entity

import jakarta.persistence.*
import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
class Message (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    @Column(columnDefinition = "TEXT", nullable = false)
    var contenu: String,
    var dateCreation: LocalDateTime,
    var typeMessage: TypeMessage,
){
}