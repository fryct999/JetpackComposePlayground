package ru.ievetrov.jetpackcomposeplayground.tasks.jcp03

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-03: Передача параметров в URL
 *
 * Задание:
 * 1. Реализовать экран со списком элементов (товаров, статей, пользователей)
 * 2. Настроить переход на экран деталей с передачей идентификатора через URL
 * 3. Использовать маршрут вида `product/{productId}`
 * 4. Извлекать параметр на экране деталей через navBackStackEntry.arguments
 * 5. Отображать данные элемента на основе полученного ID
 */

@Composable
fun NavigationWithParamsScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-03: Навигация с параметрами",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // TODO: Реализуйте навигацию с параметрами
                // Пример реализации:
                
                // val navController = rememberNavController()
                // 
                // NavHost(
                //     navController = navController,
                //     startDestination = "products_list"
                // ) {
                //     composable("products_list") {
                //         ProductsList(
                //             products = sampleProducts,
                //             onProductClick = { productId ->
                //                 navController.navigate("product_details/$productId")
                //             }
                //         )
                //     }
                //     
                //     composable(
                //         route = "product_details/{productId}",
                //         arguments = listOf(navArgument("productId") { type = NavType.IntType })
                //     ) { backStackEntry ->
                //         val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                //         val product = sampleProducts.find { it.id == productId }
                //         
                //         if (product != null) {
                //             ProductDetails(product = product)
                //         } else {
                //             Text("Продукт не найден")
                //         }
                //     }
                // }
            }
        }
    }
}

// Модель данных для примера
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String = "" // Можно добавить реальные изображения
)

// Пример списка товаров
val sampleProducts = listOf(
    Product(1, "Смартфон", "Современный смартфон с большим экраном", 29999.0),
    Product(2, "Ноутбук", "Мощный ноутбук для работы и игр", 59999.0),
    Product(3, "Наушники", "Беспроводные наушники с шумоподавлением", 12999.0),
    Product(4, "Умные часы", "Фитнес-трекер с множеством функций", 15999.0),
    Product(5, "Планшет", "Компактный планшет для развлечений", 24999.0)
)

/**
 * Компонент для отображения списка товаров
 */
@Composable
fun ProductsList(
    products: List<Product>,
    onProductClick: (Int) -> Unit
) {
    LazyColumn {
        items(products) { product ->
            ProductItem(
                product = product,
                onClick = { onProductClick(product.id) }
            )
        }
    }
}

/**
 * Компонент для отображения элемента списка товаров
 */
@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
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
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${product.price} ₽",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Экран деталей товара
 */
@Composable
fun ProductDetails(product: Product) {
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
        
        // Здесь можно добавить изображение товара
        
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Цена: ${product.price} ₽",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationWithParamsScreenPreview() {
    NavigationWithParamsScreen()
} 