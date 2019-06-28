package cadastro.model

import kotlin.collections.ArrayList

class ManagerUsuario {
    companion object{
        var id: Int = 0
        var usuarioLogado: Aluno? = null
        var listaUsuarios: MutableList<Aluno> = ArrayList<Aluno>()

        init {
            this.popularLista()
        }

        fun new(): Int{
            id += 1
            return id
        }

        fun cadastrar(nome: String, email: String, senha: String){
            listaUsuarios?.add(Aluno(nome, email, senha))
        }

        fun acessar(email: String, senha: String): Boolean{
            for (i in 0 until listaUsuarios.size){
                if (email?.equals(listaUsuarios?.get(i).email)) {
                    if(senha?.equals(listaUsuarios?.get(i).senha)){
                        usuarioLogado = listaUsuarios?.get(i)
                        return true
                    }
                }
            }
            return false
        }

        fun verificarDuplicacao(email: String): Boolean {
            for (i in 0 until listaUsuarios.size){
                if (email?.equals(listaUsuarios?.get(0).email))
                    return true
            }

            return false
        }

        fun findById(usuario: Int) : Aluno {
            var aluno: Aluno? = null

            for (i in 0 until listaUsuarios.size){
                if (listaUsuarios?.get(i).id == usuario) {
                    aluno = listaUsuarios?.get(i)
                    break
                }
            }

            return aluno!!
        }

        fun popularLista() {
            listaUsuarios = ArrayList<Aluno>()
            listaUsuarios.add(Aluno("Thalyson", "thalyson@gmail.com", "anti"))
            listaUsuarios.add(Aluno("Igor", "a", "a"))
            listaUsuarios.add(Aluno("Matheus", "matheusj@hotmail.com", "negaum"))
            listaUsuarios.add(Aluno("Rafael", "flamolino@gmail.com", "mangu"))
        }
    }
}