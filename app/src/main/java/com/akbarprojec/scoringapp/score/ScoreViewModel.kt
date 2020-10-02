package com.akbarprojec.scoringapp.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    // var untuk data score di (scoringFragment.kt)
//  ENCAPSULATION memproteksi data, data dapat di ambil tapi tidak bisa di ubah
    private var _team1Score = MutableLiveData<Int>()
    val team1Score: LiveData<Int>
        get() = _team1Score

    private var _team2Score = MutableLiveData<Int>()
    val team2Score: LiveData<Int>
        get() = _team2Score

    private var _eventFinished = MutableLiveData<Boolean>()
    val eventFinished: LiveData<Boolean>
        get() = _eventFinished

    private var _winner = MutableLiveData<String>()
    val winner: LiveData<String>
        get() = _winner

    private var _teams = MutableLiveData<ArrayList<String>>()
    val teams: LiveData<ArrayList<String>>
        get() = _teams

    val score1String = Transformations.map(team1Score, {score ->
        score.toString()
        //    metode kalkulasi apapun
    })

    val score2String = Transformations.map(team2Score, {score ->
        score.toString()
        //    metode kalkulasi apapun
    })

    init {
        _eventFinished.value = false
        _team1Score.value = 0
        _team2Score.value = 0
        _teams.value = ArrayList<String>()
    }


//    fun untuk mengoper nama2 teams ke init(32.ScoreViewMode)
    fun initTeam(team1: String, team2: String){
        (_teams.value)?.add(team1)
        (_teams.value)?.add(team2)
}

    init {
        Log.i("game_scoring", "GameViewModel init..")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("game_scoring", "GameViewModel is cleared..")
    }

    fun updateScore(team: Int) {
//      upscore +1
        if (team == 1) {
            _team1Score.value = (_team1Score.value)?.plus(1)
            _winner.value = (_teams.value)?.get(0)
        }
        else {
            _team2Score.value = (_team2Score.value)?.plus(1)
            _winner.value = (_teams.value)?.get(1)
        }

        if (((_team1Score.value)!! >= 3) ||
            ((_team2Score.value)!! >= 3)
        ) {

            _eventFinished.value = true
        }
    }

    fun reset() {
        _eventFinished.value = false
    }
}