package org.ldv.briaone.model.entity

import jakarta.persistence.*
import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
@Table(name = "message")
class Message(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(columnDefinition = "TEXT", nullable = false)
    var contenu: String,

    var dateCreation: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    var typeMessage: TypeMessage,

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    var conversation: Conversation,

    @OneToMany(
        mappedBy = "message",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var fichiers: MutableList<Fichier> = mutableListOf()
){
}