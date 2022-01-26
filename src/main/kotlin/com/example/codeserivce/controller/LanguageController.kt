package com.example.codeserivce.controller

import com.example.codeserivce.model.Language
import com.example.codeserivce.service.LanguageService
import org.springframework.web.bind.annotation.*

@RequestMapping(path = ["api/"])
@CrossOrigin(origins = ["*"])
@RestController
internal class LanguageController(service: LanguageService) {
    private val service: LanguageService

    @GetMapping("languages")
    fun all(): List<Language> {
        return service.languages
    }

    @GetMapping("language/{id}")
    fun one(@PathVariable id: Int): Language? {
        return service.getLanguageById(id)
    }

    @PostMapping("addLanguage")
    fun newLanguage(@RequestBody newLanguage: Language): Language {
        return service.saveLanguage(newLanguage)!!
    }

    @PutMapping("changeLanguage/{id}")
    fun replaceLanguage(@RequestBody newLanguage: Language, @PathVariable id: Int): Language {
        return service.updateLanguage(newLanguage)
    }

    @DeleteMapping("language/{id}")
    fun deleteLanguage(@PathVariable id: Int) {
        service.deleteLanguage(id)
    }

    init {
        this.service = service
    }
}