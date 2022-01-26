package com.example.codeserivce.service

import com.example.codeserivce.model.Language
import com.example.codeserivce.repository.LanguageRepo
import org.springframework.stereotype.Service

@Service
class LanguageService(private val languageRepo: LanguageRepo) {

    //post language
    fun saveLanguage(language: Language): Language? {
        return languageRepo.save(language)
    }

    //get language
    val languages: List<Language>
        get() = languageRepo.findAll()

    //get language by id
    fun getLanguageById(id: Int): Language? {
        return languageRepo.findById(id).orElse(null)
    }

    //delete language
    fun deleteLanguage(id: Int): String {
        languageRepo.deleteById(id)
        return "Language deleted$id"
    }

    //update language
    fun updateLanguage(language: Language): Language {
        val existingLanguage = languageRepo.findById(language.id!!).orElse(null)
        existingLanguage.name = language.name
        return languageRepo.save(existingLanguage)
    }
}