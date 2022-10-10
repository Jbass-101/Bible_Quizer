package com.jbaloji.biblequiz.presentation.questions

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.questions.components.*
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    BibleQuizTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->

                Box(modifier = Modifier.padding(paddingValues))
                Column(
                    modifier = Modifier.padding(20.dp,30.dp)

                ) {
                    
                    Questions { currentIndex, maxQuestions, currentQuestion, hint,
                                explanation,answer,options ->

                        viewModel.totalQuestions = maxQuestions


                        QuestionNumberText(
                            currentQuestion = currentIndex + 1,
                            totalQuestions = maxQuestions,
                            maxHints = viewModel.maxHints,
                            totalScore = viewModel.totalScore
                        )
                        CountDown()
                        QuestionText(currentQuestion)
                        HintAndExplanationText(
                            isHint = viewModel.isHint,
                            hintText = hint,
                            explanation = explanation,
                            showHint = {
                                viewModel.showHint()
                            })
                        AnswerButtonContainer(
                            options = options,
                            answer = answer,
                            hasAnswered = viewModel.hasAnswered,
                            answerQuestion = { option: String, answer: String ->
                                viewModel.answerQuestion(option, answer)
                            }
                        )
                        MiscButtonContainer(
                            hasAnswered = viewModel.hasAnswered,
                            nextQuestion = { viewModel.nextQuestion()
                            }, quitGame = {
                                viewModel.quitGame()
                            })


                    }

                    /**
                    QuestionNumberText()
                    CountDown()
                    QuestionText()
                    HintAndExplanationText()
                    AnswerButtonContainer()
                    MiscButtonContainer()
                     */

                }


            }

        )
    }

}


@Preview(
    name = "light mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)


@Composable
fun DefaultPreview() {
    BibleQuizTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->

                Column(
                    modifier = Modifier.padding(paddingValues)

                ) {
                   // QuestionNumberText()
                  //  CountDown()
                  //  QuestionText()
                  //  HintAndExplanationText()
                  //  AnswerButtonContainer()
                  //  MiscButtonContainer()

                }


            }

        )
    }
}

//
//@Composable
//fun DefaultPreview() {
//    BibleQuizTheme {
//        Scaffold(
//            backgroundColor = MaterialTheme.colors.background,
//            content = {paddingValues ->
//                Column(
//                    Modifier
//                        .fillMaxSize(1f)
//                        .padding(10.dp,25.dp),
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Box
//
//
//
//
//                    /*
//                    QuestionNumberText()
//                   // MySpacer()
//                    QuestionText()
//                    //MySpacer()
//                    HintAndExplanationText()
//                    //MySpacer()
//                    AnswerButtonContainer()
//                   // MySpacer()
//                    MiscButtonContainer()
//*/
//                }
//
//            }
//
//        )
//    }
//}
