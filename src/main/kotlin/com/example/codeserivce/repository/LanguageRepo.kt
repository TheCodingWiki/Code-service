package com.example.codeserivce.repository

import com.example.codeserivce.model.Language
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepo : JpaRepository<Language, Int> {

}