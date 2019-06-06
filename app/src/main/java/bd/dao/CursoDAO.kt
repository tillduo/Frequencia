package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import bd.tabelas.Curso

@Dao
interface CursoDAO{
    @Query("SELECT * FROM curso")
    fun buscarTodos(): List<Curso>

    @Query("SELECT * FROM curso WHERE id_curso IN (:idCurso)")
    fun buscarPorId(idCurso: IntArray): List<Curso>

    @Query("SELECT * FROM curso WHERE des_curso LIKE :desCurso")
    fun buscarPorNome(desCurso: String): Curso

    @Insert
    fun inserir(vararg curso: Curso)

    @Delete
    fun deletar(curso: Curso)
}