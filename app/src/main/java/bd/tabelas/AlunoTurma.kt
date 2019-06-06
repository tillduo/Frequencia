package bd.tabelas

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import bd.tabelas.Aluno
import bd.tabelas.Turma

@Entity(
    tableName = "aluno_turma",
    primaryKeys = ["aluno", "turma"],
    foreignKeys = [
        ForeignKey(
            entity = Aluno::class,
            parentColumns = ["id_aluno"],
            childColumns = ["aluno"]
        ),

        ForeignKey(
            entity = Turma::class,
            parentColumns = ["id_turma"],
            childColumns = ["turma"]
        )
    ]
)
data class AlunoTurma(
    @PrimaryKey var aluno: Int,
    @PrimaryKey var turma: Int
)