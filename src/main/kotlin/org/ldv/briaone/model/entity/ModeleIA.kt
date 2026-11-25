package org.ldv.briaone.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "modeleia")
class ModeleIA(

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String,

    @Column(unique = true)
    var identifiantTechnique: String,

    var urlAPI: String? = null,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    var cheminLogo: String? = null,

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    var fournisseur: FournisseurIA? = null,

    @OneToMany(mappedBy = "modeleIA")
    var conversations: MutableList<Conversation> = mutableListOf()
){

}