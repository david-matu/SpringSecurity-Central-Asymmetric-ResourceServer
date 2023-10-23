# SpringSecurity-Central-Asymmetric-ResourceServer
Spring RESTful resource server that demonstrates OAuth2 with signed JWT. Fetches public key from the Auth server for verifying tokens

##### Completed on 23-10-2023

##### Build on Spring 2.7.16-SNAPSHOT

Features a Blog API demonstrating persistence to a MySQL database through REST and entity relationships.

References an Auth Server that exposes a public key via /oauth/token_key endpoint - see application.yml file. Access to the token key endpoint is accessible with client credentials already registered on the Auth server
See the Auth server project [here](https://github.com/david-matu/SpringSecurity-Central-Asymmetric-AuthServer)



