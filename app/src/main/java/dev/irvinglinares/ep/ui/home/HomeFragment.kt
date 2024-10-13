package dev.irvinglinares.ep.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.irvinglinares.ep.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listView: ListView = binding.lvServicios

        val servicios = resources.getStringArray(R.array.services_array_2)

        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, servicios)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val servicioSeleccionado = parent.getItemAtPosition(position).toString()
            Toast.makeText(requireContext(), "Seleccionaste: $servicioSeleccionado", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}