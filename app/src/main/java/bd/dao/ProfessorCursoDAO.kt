package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import bd.tabelas.ProfessorCurso

@Dao
interface ProfessorCursoDAO{
    @Query("SELECT * FROM professor_curso")
    fun buscarTodos(): List<ProfessorCurso>

    @Query("SELECT * FROM professor_curso WHERE professor IN (:professor)")
    fun buscarPorProfessor(professor: IntArray): List<ProfessorCurso>

    @Query("SELECT * FROM professor_curso WHERE curso IN (:curso)")
    fun buscarPorCurso(curso: IntArray): List<ProfessorCurso>
}