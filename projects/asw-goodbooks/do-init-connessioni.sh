#!/bin/bash

# inizializza il db delle connessioni 

# connessioni con autore 

curl -X POST "http://localhost:8080/connessioni/connessioniautore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"autore\": \"Tolstoj\"}"
echo 

curl -X POST "http://localhost:8080/connessioni/connessioniautore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"autore\": \"Manzoni\"}"
echo 

curl -X POST "http://localhost:8080/connessioni/connessioniautore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"autore\": \"Manzoni\"}"
echo 

curl -X POST "http://localhost:8080/connessioni/connessioniautore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"autore\": \"Tolkien\"}"
echo 

# connessioni con recensore 

curl -X POST "http://localhost:8080/connessioni/connessionirecensore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"recensore\": \"Woody\"}"
echo 

curl -X POST "http://localhost:8080/connessioni/connessionirecensore" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Carlo\", \"recensore\": \"Roberto\"}"
echo 