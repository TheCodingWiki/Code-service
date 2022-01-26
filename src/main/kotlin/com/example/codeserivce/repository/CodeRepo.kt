package com.example.codeserivce.repository

import com.example.codeserivce.model.Code
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CodeRepo : JpaRepository<Code, Int> {

    @Query("from Code p inner join fetch p.language where p.language.id = :id")
    fun findByLanguageId(@Param("id") id: Int): List<Code>
}