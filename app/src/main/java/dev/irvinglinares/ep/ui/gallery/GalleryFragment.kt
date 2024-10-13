package dev.irvinglinares.ep.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.irvinglinares.ep.R
import dev.irvinglinares.ep.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner: Spinner = binding.spServicio
        val etCosto: EditText = binding.etCosto
        val etCantidad: EditText = binding.etCantidad
        val btCalcular: Button = binding.btCalcular
        val tvResultado: TextView = binding.tvResultado

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.services_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btCalcular.setOnClickListener {
            val costoStr = etCosto.text.toString()
            val cantidadStr = etCantidad.text.toString()

            if (costoStr.isNotEmpty() && cantidadStr.isNotEmpty()) {
                val costo = costoStr.toDouble()
                val cantidad = cantidadStr.toDouble()

                val total = costo * cantidad

                tvResultado.text = "El costo es de: $total USD"
            } else {
                Toast.makeText(requireContext(), "Por favor, ingresa el costo y la cantidad", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
