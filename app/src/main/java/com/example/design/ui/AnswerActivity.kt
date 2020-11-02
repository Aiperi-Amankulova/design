package com.example.design.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.design.R
import com.example.design.enum_utils.EnumResult
import com.example.design.result.QuestionActivity.Companion.POINTS
import com.example.design.utils.ClickSpan
import kotlinx.android.synthetic.main.activity_answers.*

@Suppress("DEPRECATION")
class AnswerActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answers)

        val points = intent.getIntExtra(POINTS, -1)
        val result = EnumResult.selectTypeOfEnum(points)

        parentLayout.setBackgroundResource(result.parentDrawble)
        divider.setBackgroundResource(result.drawbleDivider)
        tvTitle.text = getString(result.textTitle)
        tvSmallDesc.text = getString(result.smallTitle)
        tvTitle.setTextColor(resources.getColor(result.color))
        tvSmallDesc.setTextColor(resources.getColor(result.color))
        getSpan(result)

        btn_back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getSpan(result: EnumResult) {
        tvBigDesc.text = getString(result.fullText)
        ClickSpan.clickify(
            tvBigDesc,
            getString(result.fullTextColor),
            getColor(result.color)
        ) {}
    }
}