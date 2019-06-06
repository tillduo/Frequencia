package bd.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import bd.tabelas.Aula

@Dao
interface AulaDAO{
    @Query("SELECT * FROM aula")
    fun buscarTodos(): List<Aula>

    @Query("SELECT * FROM aula WHERE aluno IN (:aluno)")
    fun buscarPorAluno(aluno: IntArray): List<Aula>

    @Query("SELECT * FROM aula WHERE turma IN (:turma)")
    fun buscarPorTurma(turma: IntArray): List<Aula>

    @Query("SELECT * FROM aula WHERE hora_entrada IN (:horaEntrada)")
    fun buscarPorDataEntrada(horaEntrada: String): List<Aula>

    @Query("SELECT * FROM aula WHERE hora_saida IN (:horaSaida)")
    fun buscarPorDataSaida(horaSaida: String): List<Aula>

}