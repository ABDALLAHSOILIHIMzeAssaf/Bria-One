package org.ldv.briaone.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "role")
class Role(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    var description: String? = null,

    @OneToMany(mappedBy = "role")
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
){
}