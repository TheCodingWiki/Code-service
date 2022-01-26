package com.example.codeserivce.controller

import com.example.codeserivce.model.Code
import com.example.codeserivce.service.CodeService
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["api/"])
@CrossOrigin(origins = ["*"])
@RestController
internal class CodeController(service: CodeService) {

    private val service: CodeService


    @GetMapping("/code")
    fun all(): List<Code> {
        return service.codes
    }

    @GetMapping("/code/language/{id}")
    fun getByCodeId(@PathVariable id: Int): Code {
        return service.getCodeById(id)
    }

    @PostMapping("/addCode")
    fun newCode(@RequestBody newCode: Code): Code {
        return service.saveCode(newCode)
    }

    @GetMapping("/code/{id}")
    fun one(@PathVariable id: Int): Code {
        return service.getCodeById(id)
    }

    @PutMapping("/changeCode/{id}")
    fun replaceCode(@RequestBody newCode: Code, @PathVariable id: Int): Code {
        return service.updateCode(newCode)
    }

    @DeleteMapping("/deleteCode/{id}")
    fun deleteProduct(@PathVariable id: Int) {
        service.deleteCode(id)
    }

    init {
        this.service = service
    }
}