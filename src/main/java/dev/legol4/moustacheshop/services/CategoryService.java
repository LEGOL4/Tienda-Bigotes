package dev.legol4.moustacheshop.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import dev.legol4.moustacheshop.clients.ApiClient;
import dev.legol4.moustacheshop.constants.ApiEndpoints;
import dev.legol4.moustacheshop.models.CategoryModel;
import dev.legol4.moustacheshop.utils.JsonParserUtils;

public class CategoryService {

    private static final ApiClient apiClient = new ApiClient();

    public CompletableFuture<List<CategoryModel>> getAll() {
        return apiClient.getAsync(ApiEndpoints.CATEGORIES)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), new TypeReference<>() {}));
    }

}
