package com.akbarprojec.scoringapp.score


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.akbarprojec.scoringapp.R
import com.akbarprojec.scoringapp.databinding.FragmentScoringBinding


class ScoringFragment : Fragment() {

    //  inisialisasi var viewModel dari class ScoreViewModel dari (6.ScoreViewModel.kt)
    private lateinit var viewModel: ScoreViewModel
    private lateinit var binding: FragmentScoringBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_scoring, container, false
        )

//      viewModel
        Log.i("game_scoring", "viewmodel terpanggil dari scoring fragment..")

        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
//      scoreViewModel  dari (8. fragmen_scoring.xml)
        binding.scoreViewModel = viewModel
        binding.setLifecycleOwner(this)

        var args = ScoringFragmentArgs.fromBundle(requireArguments())

//      GET args teamName1 dan teamName2 ke Edittext teamName1 dan teamName2 (31. introFragment.kt)
        binding.teamName1.text = args.teamName1
        binding.teamName2.text = args.teamName2

        viewModel.initTeam(args.teamName1, args.teamName2)

//      data binding, dari scoring_fragment.xml event onclick
        viewModel.eventFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                viewModel.reset()
                requireView().findNavController().navigate(
                    ScoringFragmentDirections.actionScoringFragmentToFinishFragment(viewModel.winner.value.toString())
                )
            }
        })

        return binding.root
    }

}
