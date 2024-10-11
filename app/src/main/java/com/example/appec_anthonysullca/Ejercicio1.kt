package com.example.appec_anthonysullca

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appec_anthonysullca.databinding.ActivityEjercicio1Binding



class Ejercicio1 : AppCompatActivity(), View.OnClickListener {


        private lateinit var binding: ActivityEjercicio1Binding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityEjercicio1Binding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.btnCalcular.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val horasTrabajadas = binding.etHoras.text.toString().toIntOrNull()

            if (horasTrabajadas == null) {
                binding.textViewResult.text = "Por favor, ingrese un número válido"
            } else {
                val salario = calcularSalario(horasTrabajadas)
                binding.textViewResult.text = "Su salario es $${salario}"
            }
        }

        private fun calcularSalario(horasTrabajadas: Int): Double {
            val salarioPorHora = 16.0
            val horasMaxRegulares = 40
            val salarioExtraPorHora = 20.0

            return if (horasTrabajadas <= horasMaxRegulares) {
                horasTrabajadas * salarioPorHora
            } else {
                val horasExtras = horasTrabajadas - horasMaxRegulares
                (horasMaxRegulares * salarioPorHora) + (horasExtras * salarioExtraPorHora)
            }
        }
    }