package dev.legol4.moustacheshop.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import dev.legol4.moustacheshop.clients.ApiClient;
import dev.legol4.moustacheshop.constants.ApiEndpoints;
import dev.legol4.moustacheshop.dto.ProductRequest;
import dev.legol4.moustacheshop.models.ProductModel;
import dev.legol4.moustacheshop.utils.JsonParserUtils;

public class ProductService {

    private final ApiClient apiClient = new ApiClient();

    public CompletableFuture<List<ProductModel>> allProducts() {
        return apiClient.getAsync(ApiEndpoints.PRODUCT)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), new TypeReference<List<ProductModel>>() {}));
    }

    public CompletableFuture<ProductModel> register(ProductRequest productRequest) {
        return apiClient.postAsync(ApiEndpoints.PRODUCT, productRequest)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), ProductModel.class));
    }

    public CompletableFuture<ProductModel> update(ProductRequest productRequest, String id) {
        return apiClient.patchAsync(ApiEndpoints.PRODUCT + "/" + id, productRequest)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), ProductModel.class));
    }

    public CompletableFuture<Void> delete(String id) {
        return apiClient.deleteAsync(ApiEndpoints.PRODUCT + "/" + id)
            .thenAccept(response -> {});
    }

}
