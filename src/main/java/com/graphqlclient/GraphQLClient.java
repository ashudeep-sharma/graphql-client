package com.graphqlclient;

import com.apollographql.apollo.ApolloClient;

import java.util.ArrayList;

public class GraphQLClient {
    public static final String graphQLServerURL = "https://apollo-fullstack-tutorial.herokuapp.com/graphql";

    public static final String webSocketURL = "wss://apollo-fullstack-tutorial.herokuapp.com/graphql";

    public void connect() {
        ApolloClient.builder();
        //Building Apollo Client Instance
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl(graphQLServerURL)
                .build();

        //Query Functionality Simulation
        System.out.println("Query Operation Initiated");
        QueryOperation queryOperation = new QueryOperation(apolloClient, "89");
        queryOperation.execute();
        System.out.println("Query Operation Completed");

        //Mutation Functionality Simulation
        /*System.out.println("Mutation Operation Initiated");
        ArrayList<String> bookingIdList = new ArrayList<>();
        bookingIdList.add("89");
        bookingIdList.add("109");
        MutationOperation mutationOperation = new MutationOperation(bookingIdList);
        mutationOperation.execute();
        System.out.println("Mutation Operation Completed");

        //Fragment Functionality Simulation
        System.out.println("Fragment Operation Initiated");
        FragmentOperation fragmentOperation = new FragmentOperation(apolloClient, "89");
        fragmentOperation.execute();
        System.out.println("Fragment Operation Completed");

        //Pagination and Cursor Functionality Simulation
        System.out.println("Pagination Operation Initiated");
        PaginationOperation paginationOperation = new PaginationOperation(apolloClient);
        paginationOperation.execute();
        System.out.println("Pagination Operation Completed");

        //Subscription Functionality Simulation
        try {
            System.out.println("Subscription Operation Initiated");
            SubscriptionOperation subscriptionOperation = new SubscriptionOperation();
            subscriptionOperation.execute();
            Thread.sleep(5000);
            ArrayList<String> bookIdList = new ArrayList<>();
            bookIdList.add("89");
            bookIdList.add("109");
            MutationOperation mutationOpForSubscription = new MutationOperation(bookIdList);
            mutationOpForSubscription.execute();
            mutationOpForSubscription.execute();
            mutationOpForSubscription.execute();
            System.out.println("Subscription Operation Completed");
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }*/
    }

}
