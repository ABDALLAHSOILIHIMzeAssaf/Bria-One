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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    var type: String,

    var chemin: String,

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    var message: Message
){
}