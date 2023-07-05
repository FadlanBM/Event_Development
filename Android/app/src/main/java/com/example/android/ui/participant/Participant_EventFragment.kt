package com.example.android.ui.participant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.databinding.FragmentManagementeventBinding
import com.example.android.databinding.FragmentParticipantEventBinding

class Participant_EventFragment : Fragment() {

    private var _binding: FragmentParticipantEventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(Participant_EventViewModel::class.java)

        _binding = FragmentParticipantEventBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textParticipantEvent
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}