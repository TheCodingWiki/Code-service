package com.example.codeserivce.model

import javax.persistence.*

@Entity
class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null

    @OneToMany
    @JoinColumn(name = "language_id")
    private val products: List<Code>? = null
}