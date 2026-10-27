
package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {

    val consumo = ConsumoApi()

    println("Buscando gamers...")
    val listaGamers = consumo.buscarGamers()

    println("Buscando jogos...")
    val listaJogoJson = consumo.buscarJogoJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)

    println(gamerCaroline)
    println(jogoResidentVillage)

    val periodo = Periodo(
        LocalDate.now(),
        LocalDate.now().plusDays(7)
    )

    val aluguel = gamerCaroline.alugaJogo(
        jogoResidentVillage,
        periodo
    )

    // println(aluguel)

    val gamerCamila = listaGamers.get(5)

    gamerCamila.plano = PlanoAssinatura(
        "PRATA",
        9.90,
        0,
        0.15
    )

    val aluguelCamila = gamerCamila.alugaJogo(
        jogoResidentVillage,
        periodo
    )

    println("Plano: ${gamerCamila.plano.tipo}")
    println("Jogos incluídos: ${(gamerCamila.plano as PlanoAssinatura).jogosIncluidos}")
    println("Preço por dia: ${jogoResidentVillage.preco}")
    println("Dias alugados: ${periodo.emDias}")
    println("Valor calculado: R$ ${aluguelCamila.valorDoAluguel}")
    println(gamerCamila.jogosALugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(8)
    gamerCamila.recomendar(9)

    println(gamerCamila)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("JogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)

    println(arquivo.absolutePath)
}
