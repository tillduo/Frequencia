package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import bd.tabelas.Aluno

@Dao
interface AlunoDAO {
    @Query("SELECT * FROM aluno")
    fun buscarTodos(): List<Aluno>

    @Query("SELECT * FROM aluno WHERE id_aluno IN (:idAluno)")
    fun buscarPorId(idAluno: IntArray): List<Aluno>

    @Query("SELECT * FROM aluno WHERE nome_aluno LIKE :nomeAluno")
    fun buscarPorNome(nomeAluno: String): Aluno

    @Insert
    fun inserir(vararg aluno: Aluno)

    @Delete
    fun deletar(aluno: Aluno)
}