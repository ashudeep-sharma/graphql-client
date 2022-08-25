package com.graphqlclient;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import com.example.LaunchDetailsFragmentQuery;
import org.jetbrains.annotations.NotNull;

public class FragmentOperation {

    /*private final ApolloClient apolloClient;
    private String bookingId;

    public FragmentOperation(ApolloClient apolloClient,String id) {
        this.apolloClient = apolloClient;
        this.bookingId = id;
    }

    public void execute() {

        apolloClient.query(new LaunchDetailsFragmentQuery(bookingId)).enqueue(new ApolloCall.Callback<LaunchDetailsFragmentQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<LaunchDetailsFragmentQuery.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Fragment Operation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Fragment Operation Response: " + response.getData().launch().toString());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });
    }*/
}
