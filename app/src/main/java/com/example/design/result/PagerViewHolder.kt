package com.example.design.result

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
        itemView.tvCount.text = itemView.context.resources.getString(
            R.string.question_number,
            position + 1, size
        )
        itemView.tvQuestion.text = s
        itemView.btnYes.setOnClickListener {
            listener.selectAnswer(true, position)
        }
        itemView.btnNo.setOnClickListener {
            listener.selectAnswer(false, position)
        }
    }
}
