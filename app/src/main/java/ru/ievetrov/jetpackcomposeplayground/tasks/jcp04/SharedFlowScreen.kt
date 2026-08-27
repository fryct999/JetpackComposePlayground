package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import java.io.IOException

/**
 * JCP-04: События с SharedFlow
 *
 * Задание:
 * 1. Создать MutableSharedFlow для событий приложения
 * 2. Реализовать разные типы событий (сообщение, ошибка, навигация)
 * 3. Добавить кнопки для эмиссии различных событий
 * 4. Использовать LaunchedEffect для сбора событий
 * 5. Показывать Snackbar или диалог в зависимости от типа события
 * 6. Реализовать возможность отмены действия
 */

@Composable
fun SharedFlowScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            val hostState = remember { SnackbarHostState() }

            Scaffold(
                snackbarHost = { SnackbarHost(hostState) },

                ) { contentPadding ->
                Column(
                    modifier = Modifier.padding(contentPadding)
                ) {
                    Text(
                        text = "JCP-04: События с SharedFlow",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    // TODO: Реализуйте задание здесь
                    // Подсказка: используйте MutableSharedFlow для событий
                    // и LaunchedEffect для сбора в Compose
                    val eventStep = remember { EventStep() }
                    val scope = rememberCoroutineScope()

                    LaunchedEffect(eventStep) {
                        eventStep.events.collectLatest { event ->
                            hostState.currentSnackbarData?.dismiss()
                            val result = when (event) {
                                is UiEvent.Message -> hostState.showSnackbar(
                                    message = "Сообщение - ${event.text}",
                                    actionLabel = "Отменить",
                                    duration = SnackbarDuration.Long,
                                )

                                is UiEvent.Error -> hostState.showSnackbar(
                                    message = "Ошибка - ${event.message}",
                                    actionLabel = "Отменить",
                                    duration = SnackbarDuration.Long,
                                )

                                is UiEvent.Navigate -> {
                                    Log.d(
                                        "Navigation",
                                        "Пришла навигация: ${event.destination}",
                                    )
                                    null
                                }
                            }

                            if (result == SnackbarResult.ActionPerformed) {
                                Log.d("SnackbarResult", "Отмена действия")
                            }
                        }
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                eventStep.addMessage("Message")
                            }
                        }
                    ) { Text("Добавить сообщение") }

                    Button(
                        onClick = {
                            scope.launch {
                                val exception = IOException("Тестовые проблемы")
                                eventStep.addError(exception, exception.message.toString())
                            }
                        }
                    ) { Text("Добавить ошибку") }

                    Button(
                        onClick = {
                            scope.launch {
                                eventStep.addNavigate("Destination", mapOf("userId" to "123"))
                            }
                        }
                    ) { Text("Добавить навигацию") }
                }
            }

        }
    }
}

sealed interface UiEvent {
    data class Message(val text: String) : UiEvent
    data class Error(val exception: Throwable, val message: String) : UiEvent
    data class Navigate(val destination: String, val arguments: Map<String, String>) : UiEvent
}

class EventStep {
    private val _events = MutableSharedFlow<UiEvent>()
    val events = _events.asSharedFlow()

    suspend fun addMessage(message: String) {
        _events.emit(UiEvent.Message(message))
    }

    suspend fun addError(error: Throwable, message: String) {
        _events.emit(UiEvent.Error(error, message))
    }

    suspend fun addNavigate(destination: String, arguments: Map<String, String>) {
        _events.emit(UiEvent.Navigate(destination, arguments))
    }
}

@Preview(showBackground = true)
@Composable
fun SharedFlowScreenPreview() {
    SharedFlowScreen()
}