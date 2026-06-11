package dev.legol4.moustacheshop.interfaces;

import dev.legol4.moustacheshop.models.ProductModel;

@FunctionalInterface
public interface ProductSelectionHandler {
    void onProductSelected(ProductModel product);
}
