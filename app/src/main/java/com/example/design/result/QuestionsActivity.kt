package com.example.design.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design.R
import com.example.design.utils.PagerDecorator
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), PagerListener {

    private val adapter by lazy {
        PagerAdapter(this)
    }

    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupViewPager()
    }

    override fun onBackPressed() {
        if (pager.currentItem > 0) {
            pager.currentItem -= 1
        } else {
            super.onBackPressed()
        }
    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.offscreenPageLimit = 6
        pager.addItemDecoration(PagerDecorator())

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add(getString(R.string.first_cart))
        list.add(getString(R.string.second_cart))
        list.add(getString(R.string.third_cart))
        list.add(getString(R.string.fourth_cart))
        list.add(getString(R.string.fifth_cart))

        return list
    }


    override fun selectAnswer(answer: Boolean, position: Int) {
        if (answer) questionResult += 20
        nextPage(position)
    }

    override fun selectAnswerFourQuestions(points: Int, position: Int) {
        questionResult += points
        nextPage(position)
    }

    private fun nextPage(position: Int) {
        pager.currentItem += 1

        if (position + 1 == adapter.itemCount) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(POINTS, questionResult)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val POINTS = "POINTS"
    }
}