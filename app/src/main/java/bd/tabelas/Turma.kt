package bd.tabelas

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity (foreignKeys = [
ForeignKey(
    entity = Professor::class,
    parentColumns = ["id_professor", "curso_turma"],
    childColumns = ["professor_turma", "id_curso"]
)
])

data class Turma (
    @PrimaryKey (autoGenerate = true) var id_turma: Int,
    @ColumnInfo(name = "des_turma") var des_turma: String?,
    @ColumnInfo(name = "professor_turma") var professor_turma: Int,
    @ColumnInfo(name = "curso_turma") var curso_turma: Int
)
