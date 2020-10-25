package com.example.design

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(s: String, position: Int, size: Int, listener: PagerListener) {
    itemView.tvCount.text = itemView.context.resources.getString(
        R.string.question_number,
        position + 1,
        size
    )
    val span = SpannableString("У вас есть ем")

    span.setSpan(
        ForegroundColorSpan(itemView.resources.getColor(R.color.yellow)),
        5,
        11,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    itemView.tvQuestion.text = span



    itemView.btnNo.setOnClickListener {
        listener.selectAnswer(false, position)
    }
    itemView.btnYes.setOnClickListener {
        listener.selectAnswer(true, position)
    }
}
}