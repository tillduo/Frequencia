package bd.tabelas

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import bd.tabelas.Aluno
import bd.tabelas.Curso


@Entity(
    tableName = "aluno_curso",
    primaryKeys = ["aluno", "curso"],
    foreignKeys = [
        ForeignKey(
            entity = Aluno::class,
            parentColumns = ["id_aluno"],
            childColumns = ["aluno"]
        ),

        ForeignKey(
            entity = Curso::class,
            parentColumns = ["id_curso"],
            childColumns = ["curso"]
        )
    ]
)
data class AlunoCurso(
    @PrimaryKey var aluno: Int,
    @PrimaryKey var curso: Int
)