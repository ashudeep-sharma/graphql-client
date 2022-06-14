package com.graphqlclient;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.BookTripMutation;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MutationOperation {
    private final ApolloClient apolloClient;
    private ArrayList<String> bookingIdList;

    public MutationOperation(ArrayList<String> bookingIdList) {
        this.bookingIdList = bookingIdList;
        this.apolloClient = ApolloClient.builder()
                .serverUrl(GraphQLClient.graphQLServerURL)
                .okHttpClient(new OkHttpClient.Builder().addInterceptor(new AuthorizationInterceptor()).build())
                .build();
    }

    public void execute() {
        apolloClient.mutate(new BookTripMutation(bookingIdList)).enqueue(new ApolloCall.Callback<BookTripMutation.Data>() {
            @Override
            public void onResponse(@NotNull Response<BookTripMutation.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Mutation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Mutation Operation Response: " + response.getData().bookTrips());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });
    }
}
