package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import bd.tabelas.Turma

@Dao
interface TurmaDAO{
    @Query("SELECT * FROM turma")
    fun buscarTodos(): List<Turma>

    @Query("SELECT * FROM turma WHERE id_turma IN (:idTurma)")
    fun buscarPorId(idTurma: IntArray): List<Turma>

    @Query("SELECT * FROM turma WHERE des_turma LIKE :desTurma")
    fun buscarPorNome(desTurma: String): Turma

    @Insert
    fun inserir(vararg turma: Turma)

    @Delete
    fun deletar(turma: Turma)
}