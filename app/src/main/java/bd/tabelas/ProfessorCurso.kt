package bd.tabelas

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import bd.tabelas.Professor
import bd.tabelas.Curso


@Entity(
    tableName = "professor_curso",
    primaryKeys = ["professor", "curso"],
    foreignKeys = [
        ForeignKey(
            entity = Professor::class,
            parentColumns = ["id_professor"],
            childColumns = ["professor"]
        ),

        ForeignKey(
            entity = Curso::class,
            parentColumns = ["id_curso"],
            childColumns = ["curso"]
        )
    ]
)
data class ProfessorCurso(
    @PrimaryKey var professor: Int,
    @PrimaryKey var curso: Int
)