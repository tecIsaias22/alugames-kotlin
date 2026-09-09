package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.modelo.meuInfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import kotlin.jvm.java

class consumoApi {
    fun buscaJogo(id: String):meuInfoJogo{
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .header("User-Agent", "IsaiasGames/1.0")
            .GET()
            .build()

        val response = client.send(
            request,
            BodyHandlers.ofString()
        )

        val json = response.body()

        println(json)

        val gson = Gson()

        val meuInfoJogo = gson.fromJson(json, meuInfoJogo::class.java
        )
        return meuInfoJogo

    }
}
