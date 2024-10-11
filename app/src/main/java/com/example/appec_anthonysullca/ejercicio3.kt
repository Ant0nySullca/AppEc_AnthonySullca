package com.example.appec_anthonysullca

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.appec_anthonysullca.databinding.ActivityEjercicio3Binding


class ejercicio3 : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityEjercicio3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcularMinutos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val segundos = binding.etSegundos.text.toString().toIntOrNull()

        if (segundos == null || segundos < 0) {
            binding.tvResultadoMinutos.text = "ingrese un número válido de segundos"
        } else {
            val (minutos, segundosRestantes) = calcularMinutosYSegundos(segundos)
            binding.tvResultadoMinutos.text = "Minutos: $minutos, Segundos restantes: $segundosRestantes"
        }
    }

    private fun calcularMinutosYSegundos(segundos: Int): Pair<Int, Int> {
        val minutos = segundos / 60
        val segundosRestantes = segundos % 60
        return Pair(minutos, segundosRestantes)
    }
}