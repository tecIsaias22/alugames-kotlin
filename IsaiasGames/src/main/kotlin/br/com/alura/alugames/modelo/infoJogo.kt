package br.com.alura.alugames.modelo

import com.google.gson.annotations.SerializedName

data class meuInfoJogo(
    @SerializedName("info")
    val Info: InfoApiShark
)