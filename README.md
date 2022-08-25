# graphql-client

This repository consist the GraphQL Client code for performing Operations on GraphQL Server

# Instructions to Build The Code

* Execute mvn compile in the root of the repository to generate the Models from the Corresponding Schema.
* The corresponding Models will be generated in ${basedir}/target/generated-sources/apollo/service/coldfusion/graphql folder.
* Schema can be downloaded in a local file by filling the entries in the following target in pom.xml
  `
  <introspection>
  <enabled>true</enabled>
  <endpointUrl>${HASURA-ENDPOINT}</endpointUrl>
  <headers/>
  <schemaFile>${basedir}/src/main/graphql/service/schema.json</schemaFile>
  <connectTimeoutSeconds>10</connectTimeoutSeconds>
  <readTimeoutSeconds>10</readTimeoutSeconds>
  <writeTimeoutSeconds>10</writeTimeoutSeconds>
  <useSelfSignedCertificat>false</useSelfSignedCertificat>
  <useGzip>false</useGzip>
  <prettyPrint>false</prettyPrint>
  </introspection>
* In case the GraphQL Server needs authentication, the same can be done by specifying key-value in the headers section. Value can be read from Environment Variables.
  ` <headers>
  <x-hasura-admin-secret>${HASURA-SECRET}</x-hasura-admin-secret>
  </headers>`
* Make sure to initialize the value of HASURA-SECRET in the Environment variables before running maven command.
  `
* Run mvn compile to compile the sources and generate models.
* Run mvn clean install:
    * Build the project
    * Download the schema to the local file specfied in the schemaFile attribute of introspection root attribute
    * Run the Unit tests etc