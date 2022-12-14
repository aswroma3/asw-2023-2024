#!/bin/bash

# inizializza il db delle recensioni 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Woody\", \"titoloLibro\": \"Guerra e Pace\", \"autoreLibro\": \"Tolstoj\", \"testoRecensione\": \"Parla della Russia\" }"
echo 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Woody\", \"titoloLibro\": \"Anna Karenina\", \"autoreLibro\": \"Tolstoj\", \"testoRecensione\": \"Non finisce bene\" }"
echo 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Woody\", \"titoloLibro\": \"I promessi sposi\", \"autoreLibro\": \"Manzoni\", \"testoRecensione\": \"Alla fine si sposano\" }"
echo 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Roberto\", \"titoloLibro\": \"Guerra e Pace\", \"autoreLibro\": \"Tolstoj\", \"testoRecensione\": \"Un capolavoro\" }"
echo 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Roberto\", \"titoloLibro\": \"I promessi sposi\", \"autoreLibro\": \"Manzoni\", \"testoRecensione\": \"Un capolavoro\" }"
echo 

curl -X POST "http://localhost:8080/recensioni/recensioni" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"recensore\": \"Roberto\", \"titoloLibro\": \"Il Signore degli Anelli\", \"autoreLibro\": \"Tolkien\", \"testoRecensione\": \"Un capolavoro\" }"
echo 