package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.consumoApi
import br.com.alura.alugames.utilitario.tranformarEmIdade
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso. Dados do gamer")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.tranformarEmIdade())
    do {
        println("Digite o codigo do jogo para buscar?")

        val buscar = leitura.nextLine()
        val buscaApi = consumoApi()
        val informacaoJogo = buscaApi.buscaJogo(buscar)
        var meuJogo: Jogo? = null
        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.Info.title,
                informacaoJogo.Info.thumb
            )
        }

        resultado.onFailure {
            println("O jogo ainda não existe. Tente outro ID, por favor.")
            it.printStackTrace()
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada do jogo? S/N")

            val opcao = leitura.nextLine()
            if (opcao.equals("S", true)) {
                println("Insira uma descrição personalizada do jogo")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }
        println("Digite o codigo do jogo para buscar? S/N")
        val resposta = leitura.nextLine()

    }while (resposta.equals("S", true))

    println("Jogos buscados com sucesso.")
    println(gamer.jogosBuscados)
    println("Jogos ordenados por titulo:")
    gamer.jogosBuscados.sortBy { it?.titulo }
    gamer.jogosBuscados.forEach{
        println("Titulo: " + it?.titulo )
    }
    val jogosFiltrados = gamer.jogosBuscados.filter {it?.titulo?.contains("batman",true) ?:false
    }

    println("\n Jogos filtrados por titulo:")
    println(jogosFiltrados)

    println("Deseja excluir jogo?: S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("S", true)) {
        println(gamer.jogosBuscados)
        println("Informe a posiçao, queira excluir jogo")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }
    println("Busca finalizada com sucesso")
}