package com.example.codeserivce.model

import javax.persistence.*

@Entity
class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var variable: String? = null
    var string: String? = null


    @ManyToOne
    @JoinColumn(name = "language_id", insertable = true, updatable = true)
    var language: Language? = null
}