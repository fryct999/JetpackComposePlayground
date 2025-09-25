package ru.ievetrov.jetpackcomposeplayground.tasks.jcp03

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-03: Передача объектов между экранами
 *
 * Задание:
 * 1. Создать модель данных Product с аннотацией @Parcelize
 * 2. Реализовать передачу объекта между экранами двумя способами:
 *   - Через savedStateHandle (рекомендуемый метод)
 *   - Через сериализацию в Bundle (классический подход)
 * 3. Отображать полную информацию о переданном объекте на целевом экране
 * 4. Добавить возможность редактирования объекта и возврата изменений обратно
 */

@Composable
fun NavigationWithObjectsScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-03: Передача объектов",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // TODO: Реализуйте передачу Parcelable объектов между экранами
                // Пример необходимых компонентов:
                
                // 1. NavController
                // val navController = rememberNavController()
                
                // 2. NavHost с двумя подходами передачи объектов
                // NavHost(
                //     navController = navController,
                //     startDestination = "products"
                // ) {
                //     // Список товаров
                //     composable("products") {
                //         ParcelableProductsList(
                //             products = sampleParcelableProducts,
                //             onSavedStateHandleClick = { product ->
                //                 // Сохранение через savedStateHandle
                //                 navController.currentBackStackEntry?.savedStateHandle?.set(
                //                     "product_key", product
                //                 )
                //                 navController.navigate("product_details_state_handle")
                //             },
                //             onBundleClick = { product ->
                //                 // Сохранение через Bundle
                //                 val bundle = Bundle().apply {
                //                     putParcelable("product_key", product)
                //                 }
                //                 navController.navigate(
                //                     "product_details_bundle",
                //                     bundle
                //                 )
                //             }
                //         )
                //     }
                
                //     // Первый подход: через savedStateHandle
                //     composable("product_details_state_handle") {
                //         // Получение через previousBackStackEntry
                //         val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
                //         val product = savedStateHandle?.get<ParcelableProduct>("product_key")
                //
                //         if (product != null) {
                //             ParcelableProductDetails(
                //                 product = product,
                //                 onBackClick = { navController.popBackStack() }
                //             )
                //         } else {
                //             Text("Товар не найден")
                //         }
                //     }
                
                //     // Второй подход: через Bundle
                //     composable("product_details_bundle") { backStackEntry ->
                //         // Получение через arguments
                //         val product = backStackEntry.arguments?.getParcelable<ParcelableProduct>("product_key")
                //
                //         if (product != null) {
                //             ParcelableProductDetails(
                //                 product = product,
                //                 onBackClick = { navController.popBackStack() }
                //             )
                //         } else {
                //             Text("Товар не найден")
                //         }
                //     }
                // }
            }
        }
    }
}

/**
 * Parcelable модель товара
 * Примечание: для использования @Parcelize потребуется добавить плагин kotlin-parcelize
 * в build.gradle модуля app:
 *
 * plugins {
 *     id 'kotlin-parcelize'
 * }
 */
@Parcelize
data class ParcelableProduct(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val availability: Boolean = true,
    val rating: Float = 4.5f
) : Parcelable

// Примеры товаров
val sampleParcelableProducts = listOf(
    ParcelableProduct(1, "Смартфон", "Современный смартфон с большим экраном", 29999.0),
    ParcelableProduct(2, "Ноутбук", "Мощный ноутбук для работы и игр", 59999.0),
    ParcelableProduct(3, "Наушники", "Беспроводные наушники с шумоподавлением", 12999.0),
    ParcelableProduct(4, "Умные часы", "Фитнес-трекер с множеством функций", 15999.0),
    ParcelableProduct(5, "Планшет", "Компактный планшет для развлечений", 24999.0)
)

/**
 * Список товаров с кнопками для демонстрации разных подходов
 */
@Composable
fun ParcelableProductsList(
    products: List<ParcelableProduct>,
    onSavedStateHandleClick: (ParcelableProduct) -> Unit,
    onBundleClick: (ParcelableProduct) -> Unit
) {
    LazyColumn {
        items(products) { product ->
            ParcelableProductItem(
                product = product,
                onSavedStateHandleClick = { onSavedStateHandleClick(product) },
                onBundleClick = { onBundleClick(product) }
            )
        }
    }
}

/**
 * Элемент списка с кнопками для разных способов передачи
 */
@Composable
fun ParcelableProductItem(
    product: ParcelableProduct,
    onSavedStateHandleClick: () -> Unit,
    onBundleClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Цена: ${product.price} ₽",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Row {
                Button(
                    onClick = onSavedStateHandleClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Через savedStateHandle")
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Button(
                    onClick = onBundleClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Через Bundle")
                }
            }
        }
    }
}

/**
 * Экран деталей товара
 */
@Composable
fun ParcelableProductDetails(
    product: ParcelableProduct,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Цена: ${product.price} ₽",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Доступность: ${if (product.availability) "В наличии" else "Нет в наличии"}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Рейтинг: ${product.rating}/5.0",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(onClick = onBackClick) {
            Text("Вернуться к списку")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationWithObjectsScreenPreview() {
    NavigationWithObjectsScreen()
} 