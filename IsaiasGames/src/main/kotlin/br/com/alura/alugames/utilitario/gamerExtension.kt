package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.infoGamerJson

fun infoGamerJson.criarGamer(): Gamer {
   return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}