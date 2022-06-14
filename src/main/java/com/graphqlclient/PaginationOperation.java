package com.graphqlclient;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.LaunchListQuery;
import org.jetbrains.annotations.NotNull;

public class PaginationOperation {

    private final ApolloClient apolloClient;

    public PaginationOperation(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    public void execute() {

        //For fetching the list from start
        Input<String> inputList = Input.absent();
        apolloClient.query(new LaunchListQuery(inputList)).enqueue(new ApolloCall.Callback<LaunchListQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<LaunchListQuery.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Pagination Operation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Pagination Operation Response: " + response.getData().launches());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });

        //For fetching the list at a particular Cursor
        //Input<String> inputList = Input.optional("1581951955");
    }
}
