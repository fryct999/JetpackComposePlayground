package ru.ievetrov.jetpackcomposeplayground.tasks.jcp03

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-03: Анимации переходов
 *
 * Задание:
 * 1. Создать экран с набором подэкранов
 * 2. Реализовать различные типы анимаций для переходов:
 *   - Fade (появление/исчезновение)
 *   - Slide (скольжение)
 *   - Scale (масштабирование)
 *   - Комбинированные анимации
 * 3. Настроить разные анимации для прямого перехода и для возврата
 * 4. Добавить возможность выбора типа анимации пользователем
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavigationAnimationsScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-03: Анимации переходов",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
/**
                 * ПРИМЕР анимаций из урока:
                 * 
                 * composable(
                 *     route = "details",
                 *     enterTransition = { fadeIn() + slideInHorizontally() },
                 *     exitTransition = { fadeOut() + slideOutHorizontally() },
                 *     popEnterTransition = { fadeIn() + slideInHorizontally(initialOffsetX = { it }) },
                 *     popExitTransition = { fadeOut() + slideOutHorizontally(targetOffsetX = { -it }) }
                 * ) { DetailsScreen() }
                 */
                
                // TODO 1: Создать экран с набором подэкранов
                // val navController = rememberNavController()
                // var selectedAnimationType by remember { mutableStateOf(AnimationType.FADE) }
                
                // TODO 2: Реализовать различные типы анимаций для переходов
                // enum class AnimationType { FADE, SLIDE, SCALE, COMBINED }
                
                // TODO 3: Настроить разные анимации для прямого перехода и для возврата
                // NavHost(
                //     navController = navController,
                //     startDestination = "home"
                // ) {
                //     composable(
                //         route = "details",
                //         enterTransition = {
                //             when (selectedAnimationType) {
                //                 AnimationType.FADE -> fadeIn()
                //                 AnimationType.SLIDE -> slideInHorizontally { it }
                //                 AnimationType.SCALE -> scaleIn()
                //                 AnimationType.COMBINED -> fadeIn() + slideInHorizontally { it }
                //             }
                //         },
                //         exitTransition = {
                //             when (selectedAnimationType) {
                //                 AnimationType.FADE -> fadeOut()
                //                 AnimationType.SLIDE -> slideOutHorizontally { -it }
                //                 AnimationType.SCALE -> scaleOut()
                //                 AnimationType.COMBINED -> fadeOut() + slideOutHorizontally { -it }
                //             }
                //         },
                //         popEnterTransition = {
                //             when (selectedAnimationType) {
                //                 AnimationType.FADE -> fadeIn()
                //                 AnimationType.SLIDE -> slideInHorizontally { -it }
                //                 AnimationType.SCALE -> scaleIn()
                //                 AnimationType.COMBINED -> fadeIn() + slideInHorizontally { -it }
                //             }
                //         },
                //         popExitTransition = {
                //             when (selectedAnimationType) {
                //                 AnimationType.FADE -> fadeOut()
                //                 AnimationType.SLIDE -> slideOutHorizontally { it }
                //                 AnimationType.SCALE -> scaleOut()
                //                 AnimationType.COMBINED -> fadeOut() + slideOutHorizontally { it }
                //             }
                //         }
                //     ) { AnimatedDetailsScreen() }
                // }
                
                // TODO 4: Добавить возможность выбора типа анимации пользователем
                // Text("Выберите тип анимации:", style = MaterialTheme.typography.titleMedium)
                // 
                // FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                //     AnimationType.values().forEach { type ->
                //         FilterChip(
                //             selected = selectedAnimationType == type,
                //             onClick = { selectedAnimationType = type },
                //             label = { Text(type.name) }
                //         )
                //     }
                // }
                
                Text(
                    "Здесь будет демонстрация анимаций с возможностью выбора типа пользователем",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationAnimationsScreenPreview() {
    NavigationAnimationsScreen()
} 