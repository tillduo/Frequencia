package cadastro.model

class Professor {
    val id: Int
    var nome: String
    var email: String
    var senha: String

    constructor(nome: String, email: String, senha: String){
        this.id = ManagerUsuario.new()
        this.nome = nome
        this.email = email
        this.senha = senha
    }
}