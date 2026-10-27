package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import br.com.alura.alugames.utilitario.tranformarEmIdade
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)

    println("Cadastro concluído com sucesso. Dados do gamer")
    println(gamer)

    println(
        "Idade do gamer: " +
                gamer.dataNascimento?.tranformarEmIdade()
    )

    do {

        println("Digite o código do jogo para buscar?")

        val buscar = leitura.nextLine()

        val buscaApi = ConsumoApi()

        val resultado = runCatching {
            val informacaoJogo = buscaApi.buscaJogo(buscar)

            Jogo(
                informacaoJogo.Info.title,
                informacaoJogo.Info.thumb,
                0.0
            )
        }

        resultado.onFailure {
            println("O jogo ainda não existe. Tente outro ID, por favor.")
        }

        resultado.onSuccess { meuJogo ->

            println("Deseja inserir uma descrição personalizada do jogo? S/N")

            val opcao = leitura.nextLine()

            if (opcao.equals("S", true)) {

                println("Insira uma descrição personalizada do jogo")

                val descricaoPersonalizada = leitura.nextLine()

                meuJogo.descricao = descricaoPersonalizada

            } else {

                meuJogo.descricao = meuJogo.titulo
            }

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Digite o código do jogo para buscar? S/N")

        val resposta = leitura.nextLine()

        if (!resposta.equals("S", true)) {
            break
        }

    } while (true)

    println("Jogos buscados com sucesso.")

    println(gamer.jogosBuscados)

    println("Jogos ordenados por título:")

    gamer.jogosBuscados.sortBy {
        it.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it.titulo.contains("batman", true)
    }

    println("\nJogos filtrados por título:")

    println(jogosFiltrados)

    println("Deseja excluir jogo?: S/N")

    val opcao = leitura.nextLine()

    if (opcao.equals("S", true)) {

        println(gamer.jogosBuscados)

        println("Informe a posição que deseja excluir:")

        val posicao = leitura.nextInt()
        leitura.nextLine()

        if (posicao in gamer.jogosBuscados.indices) {
            gamer.jogosBuscados.removeAt(posicao)
            println("Jogo removido com sucesso.")
        } else {
            println("Posição inválida.")
        }
    }

    println("Busca finalizada com sucesso.")
}