package org.ldv.briaone.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "fichier")
class Fichier(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    var type: String,

    var chemin: String,

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    var message: Message
){
}