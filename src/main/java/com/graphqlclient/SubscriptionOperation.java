package com.graphqlclient;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.ApolloSubscriptionCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport;
//import com.example.TripsBookedSubscription;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

public class SubscriptionOperation {
    /*private final ApolloClient apolloClient;
    private final OkHttpClient okHttpClient;

    public SubscriptionOperation() {
        this.okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthorizationInterceptor())
                //.authenticator()
                .build();

        this.apolloClient = ApolloClient.builder()
                .serverUrl(GraphQLClient.graphQLServerURL)
                .subscriptionTransportFactory(new WebSocketSubscriptionTransport.Factory(GraphQLClient.webSocketURL, okHttpClient))
                .okHttpClient(okHttpClient)
                .build();
    }

    public void execute() {

        apolloClient.subscribe(new TripsBookedSubscription()).execute(new ApolloSubscriptionCall.Callback<TripsBookedSubscription.Data>() {

            @Override
            public void onCompleted() {
                System.out.println("Subscription Operation Completed");
            }

            @Override
            public void onTerminated() {
                System.out.println("Subscription Operation Terminated");
            }

            @Override
            public void onConnected() {
                System.out.println("Subscription Connected");
            }

            @Override
            public void onResponse(@NotNull Response<TripsBookedSubscription.Data> response) {
                if (response.getErrors() != null && response.getErrors().size() > 0) {
                    System.out.println("GraphQL Client Subscription Errors: " + response.getErrors());
                } else {
                    System.out.println("GraphQL Client Subscription Operation Response: " + response.getData());
                }
            }

            @Override
            public void onFailure(@NotNull ApolloException exception) {
                System.out.println("Apollo Client Error:" + exception);
            }
        });
    }*/
}
