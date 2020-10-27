package com.example.design

import android.graphics.Color.green
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.design.QuestionsActivity.Companion.POINTS
import kotlinx.android.synthetic.main.activity_answers.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answers)

        val points = intent.getIntExtra(POINTS, -1)

        when {
            points <= 20 -> {
                parentLayout.setBackgroundResource(R.drawable.green_bcg)
                divider.setBackgroundResource(R.drawable.bg_green_button)
                tvTitle.text = getString(R.string.title_green)
                tvSmallDesc.text = getString(R.string.small_desc_green)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.green_btn))
                tvSmallDesc.setTextColor(resources.getColor(R.color.green_btn))
            }
            points in 21..39 -> {
                parentLayout.setBackgroundResource(R.drawable.yellow_bcg)
                divider.setBackgroundResource(R.drawable.bg_yellow_button)
                tvTitle.text = getString(R.string.title_yellow)
                tvSmallDesc.text = getString(R.string.small_desc_yellow)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.yellow))
                tvSmallDesc.setTextColor(resources.getColor(R.color.yellow))
            }
            points in 40..59 -> {
                parentLayout.setBackgroundResource(R.drawable.orange_bcg)
                divider.setBackgroundResource(R.drawable.bg_orange_button)
                tvTitle.text = getString(R.string.title_orange)
                tvSmallDesc.text = getString(R.string.small_desc_orange)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.orange_btn))
                tvSmallDesc.setTextColor(resources.getColor(R.color.orange_btn))
            }
            else -> {
                parentLayout.setBackgroundResource(R.drawable.red_bcg)
                divider.setBackgroundResource(R.drawable.bg_red_button)
                tvTitle.text = getString(R.string.title_red)
                tvSmallDesc.text = getString(R.string.small_desc_red)
                tvBigDesc.text = getGreedSpan()
                tvTitle.setTextColor(resources.getColor(R.color.red_btn))
                tvSmallDesc.setTextColor(resources.getColor(R.color.red_btn))
            }
        }
    }

    private fun getGreedSpan(): SpannableString {
        val span = SpannableString(getString(R.string.big_desc_green))
        span.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.green_btn)),
            180,
            200,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return span
    }
}