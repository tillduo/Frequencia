package bd

import android.provider.BaseColumns

object PostContract {
    class PostEntry : BaseColumns {
        companion object {
            val TABELA_ALUNO = "aluno"
            val ID_ALUNO = "id_aluno"
            val NOME_ALUNO = "nome_aluno"
            val CURSO_ALUNO = "curso_aluno"

            val TABELA_PROFESSOR = "professor"
            val ID_PROFESSOR = "id_professor"
            val NOME_PROFESSOR = "nome_professor"

            val TABELA_CURSO = "curso"
            val ID_CURSO = "id_curso"
            val DES_CURSO = "des_curso"

            val TABELA_TURMA = "turma"
            val ID_TURMA = "id_turma"
            val PROFESSOR_TURMA = "professor_turma"
            val CURSO_TURMA = "curso_turma"

            //adicionar tabelas de relação aqui
        }
    }
}