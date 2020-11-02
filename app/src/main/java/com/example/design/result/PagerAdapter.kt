package com.example.design.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerAdapter(private val listener: PagerListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TWO_QUESTIONS) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_questions, parent, false)
            PagerViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_qustions2, parent, false)
            PagerFourViewHolder(view)
        }
    }

    fun update(list: ArrayList<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 2) return FOUR_QUESTIONS
        else TWO_QUESTIONS
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TWO_QUESTIONS) {
            (holder as PagerViewHolder).bind(
                list[position],
                position,
                list.size,
                listener
            )
        } else {
            (holder as PagerFourViewHolder).bind(list[position], position, list.size, listener)
        }
    }

    companion object {
        const val TWO_QUESTIONS = 12  //1)
        const val FOUR_QUESTIONS = 13
    }

    override fun getItemCount() = list.size
}

