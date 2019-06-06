package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import bd.tabelas.AlunoTurma

@Dao
interface AlunoTurmaDAO{
    @Query("SELECT * FROM aluno_turma")
    fun buscarTodos(): List<AlunoTurma>

    @Query("SELECT * FROM aluno_turma WHERE aluno IN (:aluno)")
    fun buscarPorAluno(aluno: IntArray): List<AlunoTurma>

    @Query("SELECT * FROM aluno_turma WHERE turma IN (:turma)")
    fun buscarPorTurma(turma: IntArray): List<AlunoTurma>
}