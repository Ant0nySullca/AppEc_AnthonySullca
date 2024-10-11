package com.example.appec_anthonysullca

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appec_anthonysullca.databinding.ActivityEjercicio4Binding


class ejercicio4 : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEjercicio4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalcularSuma.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val numeroLimite = binding.etNumeroLimite.text.toString().toIntOrNull()

        if (numeroLimite == null || numeroLimite < 1) {
            binding.tvResultadoSuma.text = "Por favor, ingrese un número válido mayor o igual a 1"
        } else {
            val suma = calcularSumaSerie(numeroLimite)
            binding.tvResultadoSuma.text = "La suma de los números hasta $numeroLimite es $suma"
        }
    }

    private fun calcularSumaSerie(limite: Int): Int {
        return (1..limite).sum()
    }
}