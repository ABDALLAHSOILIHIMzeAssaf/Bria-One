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

    @Column(nullable = false, unique = true)
    var email: String = "",

    var prenom: String,
    var nom: String,

    @Column(nullable = false, length = 510)
    var motDePasse: String = "",

    @Column(nullable = false)
    var actif: Boolean = true,

    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role,

    @OneToMany(mappedBy = "utilisateur")
    var conversations: MutableList<Conversation> = mutableListOf()
){
    
}