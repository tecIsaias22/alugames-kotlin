
package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.time.Period

data class Periodo(
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    val emDias: Long
        get() = Period.between(dataInicial, dataFinal).days.toLong()
}
