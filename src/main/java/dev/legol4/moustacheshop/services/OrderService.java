package dev.legol4.moustacheshop.services;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;

import dev.legol4.moustacheshop.clients.ApiClient;
import dev.legol4.moustacheshop.constants.ApiEndpoints;
import dev.legol4.moustacheshop.dto.OrderRequest;
import dev.legol4.moustacheshop.models.OrderModel;
import dev.legol4.moustacheshop.utils.JsonParserUtils;

public class OrderService {

    private static final ApiClient apiClient = new ApiClient();

    public CompletableFuture<List<OrderModel>> getAll() {
        return apiClient.getAsync(ApiEndpoints.ORDER)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), new TypeReference<>() {}));
    }

    public CompletableFuture<OrderModel> create(OrderRequest orderRequest) {
        return apiClient.postAsync(ApiEndpoints.ORDER, orderRequest)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), OrderModel.class));
    }

    public CompletableFuture<byte[]> fetchReport(String orderId) {
        return apiClient.getAsyncBytes(ApiEndpoints.REPORTS + "/" + orderId)
            .thenApply(HttpResponse::body);
    }

    public String generateReportLink(String orderId) {
        return ApiEndpoints.REPORTS + "/" + orderId;
    }

}
