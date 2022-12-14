#!/bin/bash

# trova tutte le connessioni 

echo "# tutte le connessioni con autore" 
echo $(curl -s localhost:8080/connessioni/connessioniautore)
echo 

echo "# tutte le connessioni con recensore" 
echo $(curl -s localhost:8080/connessioni/connessionirecensore)
echo 