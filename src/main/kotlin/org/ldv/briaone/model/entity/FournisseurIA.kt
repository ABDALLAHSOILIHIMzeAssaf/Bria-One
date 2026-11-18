package org.ldv.briaone.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "fournisseuria")
class FournisseurIA(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    var description: String? = null,

    var cheminLogo: String? = null,

    @OneToMany(mappedBy = "fournisseur")
    var modeles: MutableList<ModeleIA> = mutableListOf()
){
}