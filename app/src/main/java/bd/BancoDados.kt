package bd

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import bd.dao.*
import bd.tabelas.Aluno

@Database (entities = arrayOf(Aluno::class), version = 1)
abstract class BancoDados: RoomDatabase(){

    companion object {
        fun getInstance(context: Context): Builder<BancoDados> {
            return Room.databaseBuilder(context.applicationContext, BancoDados::class.java, "bancodados_frequencia.db")
        }
    }

    abstract fun alunoDAO(): AlunoDAO
    abstract fun alunoCursoDAO(): AlunoCursoDAO
    abstract fun alunoTurmaDAO(): AlunoTurmaDAO
    abstract fun aulaDAO(): AulaDAO
    abstract fun cursoDAO(): CursoDAO
    abstract fun professorDAO(): ProfessorDAO
    abstract fun professorCursoDAO(): ProfessorCursoDAO
    abstract fun turmaDAO(): TurmaDAO
}


/*



* */