package br.com.veronezitecnologia.notepad.service

import br.com.veronezitecnologia.notepad.model.Nota
import br.com.veronezitecnologia.notepad.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotaService {

    @Autowired
    lateinit var notaRepository: NotaRepository

    fun salvar(nota : Nota) : Nota {
        return   notaRepository.save(nota)
    }

    fun buscarTodos() : List<Nota> {
        return notaRepository.findAll()
    }

    fun apagar(id: String) {
        notaRepository.deleteById(id)
    }

    fun buscarPor(id: String) : Nota {
        return notaRepository.findById(id).get()
    }

    fun buscaPorTitulo(titulo: String) : List<Nota> {
        return notaRepository.findByTituloContainingIgnoreCase(titulo)
    }
}