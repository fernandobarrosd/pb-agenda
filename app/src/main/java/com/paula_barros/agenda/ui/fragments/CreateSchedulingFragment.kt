package com.paula_barros.agenda.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.paula_barros.agenda.R
import com.paula_barros.agenda.databinding.FragmentCreateSchedulingBinding

class CreateSchedulingFragment : Fragment() {
    private lateinit var binding: FragmentCreateSchedulingBinding
    private val allowedHours by lazy {
        resources.getStringArray(R.array.allowed_hours_string_array)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentCreateSchedulingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinner()
        setupListeners()
    }


    private fun setupSpinner() {
        val adapter = ArrayAdapter(requireContext(), R.layout.layout_allowed_hour_spinner_item, allowedHours)
        binding.allowedHoursSpinner.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnCreateScheduling.setOnClickListener {
            val selectedItemPosition = binding.allowedHoursSpinner.selectedItemPosition
            val allowedHourSelected = allowedHours[selectedItemPosition]
        }
    }

    private fun navigateToPixInfoScreen(allowedHour: String) {
        findNavController().navigate(
            CreateSchedulingFragmentDirections
                .actionCreateSchedulingFragmentToPixInfoFragment(allowedHour)
        )
    }
}