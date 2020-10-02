package com.akbarprojec.scoringapp.intro


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.akbarprojec.scoringapp.databinding.FragmentIntroBinding
import com.akbarprojec.scoringapp.R

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //set intro fragment
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false
        )

//      klik button untuk pindah activity
        binding.startBtn.setOnClickListener {

//          MEMPASS args teamName1 dan teamName2 ke Edittext teamName1 dan teamName2 (33. ScroingFragment.kt)
            requireView().findNavController().navigate(
                IntroFragmentDirections.actionIntroFragmentToScoringFragment(
                    binding.teamName1.text.toString(), binding.teamName2.text.toString()
                )
            )

        }
        return binding.root
    }


}
