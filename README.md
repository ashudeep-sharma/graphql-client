# graphql-client

This repository consist the GraphQL Client code for performing Operations on GraphQL Server

# Instructions to Build The Code

* Execute mvn clean install in the root of the repository
* Run the Main Class file to simulate operations like Query/Mutation/Pagination/Fragments and Subscription
* Download Schema from the GraphQL Server by using the following command on the terminal: .\gradlew downloadApolloSchema --endpoint="https://apollo-fullstack-tutorial.herokuapp.com/graphql" --schema="src/main/graphql/com/example/schema.json"
