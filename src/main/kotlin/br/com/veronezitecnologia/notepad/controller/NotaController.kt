package br.com.veronezitecnologia.notepad.controller

import br.com.veronezitecnologia.notepad.model.Nota
import br.com.veronezitecnologia.notepad.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota")
class NotaController {

    @Autowired
    lateinit var notaService: NotaService

    @GetMapping("/check")
    fun checkHealth(): String {
        return "OK"
    }

    @GetMapping
    fun buscarTodos(): List<Nota> {
        return notaService.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody nota: Nota): Nota {
        return  notaService.salvar(nota)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id") id: String) {
        notaService.apagar(id)
    }

    @GetMapping("id/{id}")
    fun buscarPor(@PathVariable("id") id: String) : Nota {
        return notaService.buscarPor(id)
    }

    @GetMapping("titulo/{titulo}")
    fun buscaPorTitulo(@PathVariable("titulo") titulo: String) : List<Nota> {
        return notaService.buscaPorTitulo(titulo)
    }

}