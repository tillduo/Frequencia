package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import bd.tabelas.AlunoCurso
import bd.tabelas.Curso

@Dao
interface AlunoCursoDAO{
    @Query("SELECT * FROM aluno_curso")
    fun buscarTodos(): List<AlunoCurso>

    @Query("SELECT * FROM aluno_curso WHERE aluno IN (:aluno)")
    fun buscarPorAluno(aluno: IntArray): List<AlunoCurso>

    @Query("SELECT * FROM aluno_curso WHERE curso IN (:curso)")
    fun buscarPorCurso(curso: IntArray): List<AlunoCurso>
}