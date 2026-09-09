package br.com.alura.alugames.principal
import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer(
        "          ",
        "isaiascaetano@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "rute",
        "rutelane@gmail.com",
        "30/11/1998",
        "lane rute"
        )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "12/12/2002"
        it.usuario = "isaias caetano"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "isaias caetano"
}