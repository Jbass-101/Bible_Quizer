package com.jbaloji.biblequiz.domain.use_case.questions

import com.jbaloji.biblequiz.domain.repository.QuestionsRepository

class GetQuestions(private val repo : QuestionsRepository) {

    operator fun invoke() = repo.getQuestions()

}