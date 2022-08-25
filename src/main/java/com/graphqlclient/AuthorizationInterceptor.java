package com.graphqlclient;

import okhttp3.Interceptor;
import okhttp3.Request;

import java.io.IOException;

public class AuthorizationInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                //.addHeader("Authorization", "a2FsbHVAZ21haWwuY29t")
                .addHeader("x-hasura-admin-secret", "8Mv55NoCAJGZAgavG8u3iNsBgVsvxLj82tS8PG3Gxse7fbhSUROBF0e4Jqu5NQ2y")
                .build();

        return chain.proceed(request);
    }
}
