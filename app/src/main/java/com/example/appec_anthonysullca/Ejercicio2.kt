package com.example.appec_anthonysullca

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.appec_anthonysullca.databinding.ActivityEjercicio2Binding


class Ejercicio2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcularPromedio.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val nota1 = binding.etNota1.text.toString().toDoubleOrNull()
        val nota2 = binding.etNota2.text.toString().toDoubleOrNull()
        val nota3 = binding.etNota3.text.toString().toDoubleOrNull()
        val nota4 = binding.etNota4.text.toString().toDoubleOrNull()

        if (nota1 == null || nota2 == null || nota3 == null || nota4 == null) {
            binding.tvResultadoPromedio.text = "Por favor, ingrese todas las notas válidas."
        } else {
            val resultado = calcularPromedio(listOf(nota1, nota2, nota3, nota4))
            binding.tvResultadoPromedio.text = "Nota eliminada: ${resultado.first}\nPromedio: ${resultado.second}"
        }
    }

    private fun calcularPromedio(notas: List<Double>): Pair<Double, Double> {
        val notasOrdenadas = notas.sorted()
        val notaEliminada = notasOrdenadas[0]
        val promedio = notasOrdenadas.drop(1).average()
        return Pair(notaEliminada, promedio)
    }
}