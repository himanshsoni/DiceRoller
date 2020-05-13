package com.example.diceroller

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                hideDice()
                val random = (1..6).random()
                textView.text = random.toString()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }
        })
    }

    private fun showDice() {
        dice.visibility = View.VISIBLE
        textView.visibility = View.GONE
        button.isEnabled = false

    }

    private fun hideDice() {
        dice.visibility = View.GONE
        textView.visibility = View.VISIBLE
        button.isEnabled =true

    }

    fun rollDiceClicked(view: View) {
        showDice()
        dice.playAnimation()
    }
}