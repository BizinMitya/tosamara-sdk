package com.github.useful_solutions.tosamara_sdk.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HttpConnectionManager {

    private static final Duration TIMEOUT = Duration.of(20, ChronoUnit.SECONDS);
    private static final OkHttpClient OK_HTTP_CLIENT = buildOkHttpClient();

    private HttpConnectionManager() {
    }

    public static Call buildPostCall(String url, RequestBody requestBody) {
        return OK_HTTP_CLIENT.newCall(
                new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build()
        );
    }

    public static Call buildGetCall(String url) {
        return OK_HTTP_CLIENT.newCall(
                new Request.Builder()
                        .url(url)
                        .get()
                        .build()
        );
    }

    private static OkHttpClient buildOkHttpClient() {
        return new OkHttpClient.Builder()
                .callTimeout(TIMEOUT)
                .connectTimeout(TIMEOUT)
                .readTimeout(TIMEOUT)
                .writeTimeout(TIMEOUT)
                .build();
    }

}
