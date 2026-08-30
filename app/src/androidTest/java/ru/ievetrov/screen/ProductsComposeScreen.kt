package ru.ievetrov.screen


import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import androidx.compose.ui.test.*

class ProductsComposeScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<ProductsComposeScreen>(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag("products_screen") }
    ) {
    val searchField: KNode = child { hasTestTag("search_field") }
    val loadingIndicator: KNode = child { hasTestTag("loading_indicator") }
    val productList: KNode = child { hasTestTag("product_list") }

    val milk: KNode = child { hasText("Молоко") }
    val bread: KNode = child { hasText("Хлеб") }
}