package bd.tabelas

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Curso (
    @PrimaryKey (autoGenerate = true) var id_curso: Int,
    @ColumnInfo(name = "des_curso") var des_curso: String?
)

//https://developer.android.com/training/data-storage/room#kotlin
// https://medium.com/@jeffersontpadua/persist%C3%AAncia-de-dados-no-android-com-room-2-mapeando-relacionamentos-22f7fafd7d30