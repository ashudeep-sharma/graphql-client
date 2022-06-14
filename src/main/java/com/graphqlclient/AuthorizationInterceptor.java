package com.graphqlclient;

import okhttp3.Interceptor;
import okhttp3.Request;

import java.io.IOException;

public class AuthorizationInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "a2FsbHVAZ21haWwuY29t")
                .build();

        return chain.proceed(request);
    }
}
