package com.akbarprojec.scoringapp.finish


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.akbarprojec.scoringapp.R
import com.akbarprojec.scoringapp.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFinishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish, container, false
        )

//      GUNAKAAN DEPPEDENSI LINK
//      https://developer.android.com/jetpack/androidx/releases/navigation#safe_args
//      TUTORIAL VID https://sekolahkoding.com/kelas/navigasi-di-android/video/finish-fragment-dan-install-safe-args

//      MASUKAN DEPPEDENCI DI build.gradle(project)
//      def nav_version = "2.3.0"
//      classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

//      MASUKAN APPLY PLUGIN
//      apply plugin: "androidx.navigation.safeargs.kotlin"

        var args =
            FinishFragmentArgs.fromBundle(requireArguments())

//      GET Args name dari (57.ScoringFragment.kt)
        binding.resultText.text = args.name + " menang!! "

        return binding.root
    }

}
