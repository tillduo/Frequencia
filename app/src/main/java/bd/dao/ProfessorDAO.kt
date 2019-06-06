package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import bd.tabelas.Professor

@Dao
interface ProfessorDAO{
    @Query("SELECT * FROM professor")
    fun buscarTodos(): List<Professor>

    @Query("SELECT * FROM professor WHERE id_professor IN (:idProfessor)")
    fun buscarPorId(idProfessor: IntArray): List<Professor>

    @Query("SELECT * FROM professor WHERE nome_professor LIKE :nomeProfessor")
    fun buscarPorNome(nomeProfessor: String): Professor

    @Insert
    fun inserir(vararg professor: Professor)

    @Delete
    fun deletar(professor: Professor)
}