package dev.legol4.moustacheshop.services;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.legol4.moustacheshop.clients.ApiClient;
import dev.legol4.moustacheshop.constants.ApiEndpoints;
import dev.legol4.moustacheshop.dto.LoginRequest;
import dev.legol4.moustacheshop.models.UserModel;
import dev.legol4.moustacheshop.utils.JwtPreferencesManager;
import dev.legol4.moustacheshop.utils.UserSession;

public class AuthService {

    private final ApiClient apiClient = new ApiClient();

    public CompletableFuture<UserModel> loginAsync(String email, String password) {
        return apiClient.postAsync(ApiEndpoints.AUTH_LOGIN, new LoginRequest(email, password))
            .thenApply(response -> {
                try {
                    return handleResponse(response);
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            });
    }

    public void fetchUserInfo() throws Exception {
        HttpResponse<String> response = apiClient.get(ApiEndpoints.CHECK_AUTH_STATUS);
        UserModel user = handleResponse(response);
        JwtPreferencesManager.setJwt(user.getToken());
    }

    private UserModel handleResponse(HttpResponse<String> response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserModel user = objectMapper.readValue(response.body(), UserModel.class);
        UserSession.getInstance().setUserModel(user);
        return user;
    }

}