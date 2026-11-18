package org.ldv.briaone.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "utilisateur")
class Utilisateur(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(nullable = false)
    var motDePasse: String,

    @ManyToOne
    @JoinColumn(name = "id")
    var role: Role? = null,

    @OneToMany(mappedBy = "utilisateur")
    var conversations: MutableList<Conversation> = mutableListOf()
){
}