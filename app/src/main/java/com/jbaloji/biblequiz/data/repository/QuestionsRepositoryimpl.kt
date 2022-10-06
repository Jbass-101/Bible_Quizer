package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.CollectionReference
import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.BooksRespose
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class QuestionsRepositoryimpl @Inject constructor(
    private val questionRef: CollectionReference
) : QuestionsRepository {

    override fun getQuestions() = callbackFlow {
        val snapshotListener = questionRef.addSnapshotListener { snapshot, error ->
            val questionsResponse = if (snapshot != null){
                val questions = snapshot.toObjects(Question::class.java)
                Response.Success(questions)
            } else {
                Response.Failure(error)
            }
            trySend(questionsResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

}