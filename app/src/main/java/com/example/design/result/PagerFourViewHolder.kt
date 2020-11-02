package com.example.design.result

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import kotlinx.android.synthetic.main.item_questions.view.tvCount
import kotlinx.android.synthetic.main.item_qustions2.view.*

class PagerFourViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {

        itemView.tvQuestion.text = s
        itemView.tvCount.text = itemView.context.resources.getString(
            R.string.question_number,
            position + 1, size
        )

        itemView.btnZero.setOnClickListener {
            listener.selectAnswerFourQuestions(position, 0)
        }

        itemView.btnOne.setOnClickListener {
            listener.selectAnswerFourQuestions(position, 10)
        }

        itemView.btnFive.setOnClickListener {
            listener.selectAnswerFourQuestions(position, 15)
        }

        itemView.btnTen.setOnClickListener {
            listener.selectAnswerFourQuestions(position, 20)
        }
    }
}




