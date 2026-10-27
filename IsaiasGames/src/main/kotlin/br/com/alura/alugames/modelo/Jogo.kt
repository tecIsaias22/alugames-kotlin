
package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose

data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String,
    val preco: Double
) : Recomendavel {

    var descricao: String? = null

    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = if (listaNotas.isEmpty()) 0.0 else listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Preço: $preco\n" +
                "Descrição: $descricao"
    }
}
