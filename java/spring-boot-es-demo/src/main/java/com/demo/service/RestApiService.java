package com.demo.service;

import okhttp3.*;

import java.io.IOException;

/**
 * @author: gan
 * @date: 2020/10/14
 */
public class RestApiService {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON,"{\n" +
                "  \"query\": {\n" +
                "    \"wildcard\": {\n" +
                "      \"title.keyword\": \"小米手*\"\n" +
                "    }\n" +
                "  }\n" +
                "}");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:9200/item/_search")
                .post(body)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OkHttpClient buildBasicAuthClient(final String name, final String password) {
        return new OkHttpClient.Builder().authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic(name, password);
                return response.request().newBuilder().header("Authorization", credential).build();
            }
        }).build();
    }
}
