package org.ldv.briaone.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "conversation")
class Conversation(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var titre: String,

    var dateCreation: LocalDateTime = LocalDateTime.now(),

    var dateModification: LocalDateTime = LocalDateTime.now(),

    var estArchivee: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    var utilisateur: Utilisateur,

    @ManyToOne
    @JoinColumn(name = "modele_id")
    var modeleIA: ModeleIA? = null,

    @OneToMany(
        mappedBy = "conversation",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var messages: MutableList<Message> = mutableListOf()
){
}