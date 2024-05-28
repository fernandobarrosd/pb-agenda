package com.paula_barros.agenda.ui.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.paula_barros.agenda.databinding.FragmentPixInfoBinding

class PixInfoFragment : Fragment() {
    private lateinit var binding: FragmentPixInfoBinding
    private val args : PixInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentPixInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCopyPixCode.setOnClickListener {
            val pixCodeText = binding.pixCodeTextView.text.toString()
            val pixCode = pixCodeText
                .substring(pixCodeText.indexOf(": "))
            copyPixCode(pixCode)
        }
    }

    private fun copyPixCode(pixCode: String) {
        val clipboardManager = requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("PIX_CODE", pixCode)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(requireContext(), "Chave pix copiada", Toast.LENGTH_LONG).show()
    }
}