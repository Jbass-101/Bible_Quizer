package com.jbaloji.biblequiz.presentation.questions

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.QuitMenu
import com.jbaloji.biblequiz.presentation.questions.components.*
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun QuestionsScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToScore: () -> Unit,
    onNavigateToDialog: () -> Unit,
    navController: NavController,
    viewModel: QuestionsViewModel = hiltViewModel()
) {

    Box(){

    if (viewModel.showQuitMenu){

        QuitMenu(
            toggleQuitMenu = { viewModel.toggleQuitMenu() },
            onNavigateToHome = onNavigateToHome
        )
    }

    Box() {
        Column(
            modifier = Modifier
                .padding(20.dp,30.dp)

        ) {

            Questions { currentIndex, maxQuestions, currentQuestion, hint,
                        answer,options ->

                viewModel.totalQuestions = maxQuestions


                QuestionNumberText(
                    currentQuestion = currentIndex + 1,
                    totalQuestions = maxQuestions,
                    maxHints = viewModel.maxHints,
                    totalScore = viewModel.currentScore
                )
                CountDown(
                    time = viewModel.currentTime,
                    progress = viewModel.currentProgress
                )
                QuestionText(currentQuestion)
                HintText(
                    hintText = hint,
                )
                AnswerButtonContainer(
                    options = options,
                    answer = answer,
                )
                MiscButtonContainer(
                    hasAnswered = viewModel.hasAnswered,
                    isLastQuestion = viewModel.isLastQuestion,
                    nextOrFinish = { viewModel.nextOrFinish()
                    },
                    toggleQuitMenu =
//                    {viewModel.toggleQuitMenu()}
                                        onNavigateToDialog
                    ,
                    onNavigateToScore = {
                        navController.navigate(
                            "score/${viewModel.levelId}/${viewModel.savedScore}/${viewModel.currentScore}"
                        )
                    }
                )
            }

        }


    }
}







}



