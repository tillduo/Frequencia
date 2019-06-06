package bd.tabelas

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity
data class Professor (
    @PrimaryKey (autoGenerate = true) var id_professor: Int,
    @ColumnInfo(name = "nome_professor") var nome_professor: String?
)

