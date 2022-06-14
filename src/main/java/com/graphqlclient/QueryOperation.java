package com.graphqlclient;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.LaunchDetailsQuery;
import org.jetbrains.annotations.NotNull;

public class QueryOperation {
    private final ApolloClient apolloClient;

    String bookingId;

    public QueryOperation(ApolloClient apolloClient,String bookingId) {
        this.apolloClient = apolloClient;
        this.bookingId = bookingId;
    }

    public void execute() {
        apolloClient.query(new LaunchDetailsQuery(bookingId)).enqueue(new ApolloCall.Callback<LaunchDetailsQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<LaunchDetailsQuery.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Query Operation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Query Operation Response: " + response.getData().launch().toString());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });
    }
}
