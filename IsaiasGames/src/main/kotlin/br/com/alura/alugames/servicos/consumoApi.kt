
package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.modelo.infoGamerJson
import br.com.alura.alugames.modelo.meuInfoJogo
import br.com.alura.alugames.utilitario.criarGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration

class ConsumoApi {

    private val cliente = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(30))
        .build()

    private fun consumoDados(endereco: String): String {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .timeout(Duration.ofSeconds(30))
            .header("User-Agent", "IsaiasGames/1.0")
            .GET()
            .build()

        val response = cliente.send(
            request,
            BodyHandlers.ofString()
        )

        if (response.statusCode() !in 200..299) {
            throw RuntimeException(
                "Erro na requisição: HTTP ${response.statusCode()}"
            )
        }

        return response.body()
    }

    fun buscarGamers(): List<Gamer> {
        val endereco =
            "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consumoDados(endereco)

        val gson = Gson()

        val meuGamerTipo =
            object : TypeToken<List<infoGamerJson>>() {}.type

        val listaGamer: List<infoGamerJson> =
            gson.fromJson(json, meuGamerTipo)

        return listaGamer.map { it.criarGamer() }
    }

    fun buscarJogoJson(): List<Jogo> {
        val endereco =
            "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = consumoDados(endereco)

        val gson = Gson()

        val meuJogoTipo =
            object : TypeToken<List<Jogo>>() {}.type

        return gson.fromJson(json, meuJogoTipo)
    }

    fun buscaJogo(id: String): meuInfoJogo {
        val endereco =
            "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consumoDados(endereco)

        val gson = Gson()

        return gson.fromJson(
            json,
            meuInfoJogo::class.java
        )
    }
}
