package dev.legol4.moustacheshop.services;

import java.util.concurrent.CompletableFuture;

import dev.legol4.moustacheshop.clients.ApiClient;
import dev.legol4.moustacheshop.constants.ApiEndpoints;
import dev.legol4.moustacheshop.models.SummaryModel;
import dev.legol4.moustacheshop.utils.JsonParserUtils;

public class HomeService {

    private static final ApiClient apiClient = new ApiClient();

    public CompletableFuture<SummaryModel> fetchSummaries() {
        return apiClient.getAsync(ApiEndpoints.SUMMARIES)
            .thenApply(response -> JsonParserUtils.parseResponse(response.body(), SummaryModel.class));
    }

}
