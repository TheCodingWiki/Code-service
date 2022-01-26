package com.example.codeserivce.service

import com.example.codeserivce.model.Code
import com.example.codeserivce.repository.CodeRepo
import org.springframework.stereotype.Service


@Service
class CodeService(private val codeRepo: CodeRepo) {

    //post code information
    fun saveCode(code: Code): Code {
        return codeRepo.save(code)
    }

    //get code information
    val codes: List<Code>
        get() = codeRepo.findAll()

    //get code information by id
    fun getCodeById(id: Int): Code {
        return codeRepo.findById(id).orElse(null)
    }

    //find code information by language id
    fun findByLanguageId(id: Int): List<Code> {
        return codeRepo.findByLanguageId(id)
    }

    //delete code information
    fun deleteCode(id: Int): String {
        codeRepo.deleteById(id)
        return "Code deleted$id"
    }

    //update code information
    fun updateCode(code: Code): Code {
        val existingCode = codeRepo.findById(code.id!!).orElse(null)
        existingCode.variable = code.variable
        existingCode.string = code.string
        return codeRepo.save(existingCode)
    }
}