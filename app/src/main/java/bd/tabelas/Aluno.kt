package bd.tabelas

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Aluno (
    @PrimaryKey (autoGenerate = true) var id_aluno: Int,
    @ColumnInfo(name = "nome_aluno") var nome_aluno: String?
)