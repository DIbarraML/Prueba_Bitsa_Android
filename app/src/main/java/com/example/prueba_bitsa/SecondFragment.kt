package com.example.prueba_bitsa

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.prueba_bitsa.databinding.FragmentSecondBinding
import com.example.prueba_bitsa.domain.Window
import com.example.prueba_bitsa.domain.getState
import com.example.prueba_bitsa.ui.StateWindowAdapter


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as MainActivity).viewModel
        binding.windowsClosed.text = viewModel.countWindowsClosed().toString()
        binding.windowsOpen.text = viewModel.countWindowsOpen().toString()
        binding.windowsLeft.text = viewModel.countWindowsLeft().toString()
        binding.windowsRight.text = viewModel.countWindowsRight().toString()

        binding.recyclerStateWindow.adapter = StateWindowAdapter(viewModel.printStringState())

        binding.recyclerWins.adapter = StateWindowAdapter(viewModel.printWins())

        binding.recyclerMoreWins.adapter = StateWindowAdapter(viewModel.printMoreWins())

        /*val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, R.layout.simple_list_item_1, viewModel.getStateWindows())*/

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}