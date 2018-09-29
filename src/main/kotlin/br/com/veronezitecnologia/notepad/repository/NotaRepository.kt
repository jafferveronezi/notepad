package br.com.veronezitecnologia.notepad.repository

import br.com.veronezitecnologia.notepad.model.Nota
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotaRepository : MongoRepository<Nota, String> {

    fun findByTituloContainingIgnoreCase(titulo: String): List<Nota>

}