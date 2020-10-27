package com.example.design.result

interface PagerListener {
    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerFourQuestions(points: Int, position: Int)
}