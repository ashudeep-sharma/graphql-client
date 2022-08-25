package com.graphqlclient;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
//import com.example.BookTripMutation;
import com.example.DeleteProductsByIDMutation;
import com.example.ProductInsertMutation;
import com.example.ProductPriceUpdateMutation;
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

        //Insert Mutation
        Mutation mutation = new ProductInsertMutation(new Input<>(1234,true),new Input<>("TestBrand",true), new Input<>("Test Product Name",true), new Input<>(5000,true));
        apolloClient.mutate(mutation).enqueue(new ApolloCall.Callback<ProductInsertMutation.Data>() {
            @Override
            public void onResponse(@NotNull Response<ProductInsertMutation.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Mutation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Mutation Operation Response: " + response.getData().toString());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });

        //Update Mutation
        mutation = new ProductPriceUpdateMutation(new Input<>(1234,true), new Input<>(123,true));
        apolloClient.mutate(mutation).enqueue(new ApolloCall.Callback<ProductPriceUpdateMutation.Data>() {
            @Override
            public void onResponse(@NotNull Response<ProductPriceUpdateMutation.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Mutation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Mutation Operation Response: " + response.getData().toString());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });

        mutation = new DeleteProductsByIDMutation(1234);
        apolloClient.mutate(mutation).enqueue(new ApolloCall.Callback<DeleteProductsByIDMutation.Data>() {
            @Override
            public void onResponse(@NotNull Response<DeleteProductsByIDMutation.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Mutation Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Mutation Operation Response: " + response.getData().toString());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                System.out.println("Apollo Client Error:" + e);
            }
        });

    }

    /*public void execute() {
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
    }*/
}
