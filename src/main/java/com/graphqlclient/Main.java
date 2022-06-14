package com.graphqlclient;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing GraphQL Client");
        GraphQLClient graphQLClient = new GraphQLClient();
        graphQLClient.connect();
    }
}