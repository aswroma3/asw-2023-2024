#!/bin/bash

# esegue un insieme di interrogazioni di esempio 

echo "# tutte le recensioni"  
echo $(curl -s localhost:8080/recensioni/recensioni)
echo 

echo "# la recensione 1" 
echo $(curl -s localhost:8080/recensioni/recensioni/1)
echo 

echo "# tutte le recensioni del recensore Woody" 
echo $(curl -s localhost:8080/recensioni/cercarecensioni/recensore/Woody)
echo 

echo "# tutte le recensioni de I promessi sposi" 
echo $(curl -s localhost:8080/recensioni/cercarecensioni/titolo/I%20promessi%20sposi)
echo 

echo "# tutte le recensioni dei libri di Tolstoj" 
echo $(curl -s localhost:8080/recensioni/cercarecensioni/autore/Tolstoj)
echo 

echo "# tutte le connessioni" 
echo $(curl -s localhost:8080/connessioni/connessioniautore)
echo 
echo $(curl -s localhost:8080/connessioni/connessionirecensore)
echo 

echo "# tutte le connessioni di Alice" 
echo $(curl -s localhost:8080/connessioni/connessioniautore/Alice)
echo 
echo $(curl -s localhost:8080/connessioni/connessionirecensore/Alice)
echo 

echo "# le recensioni seguite da Alice" 
echo $(curl -s localhost:8080/recensioni-seguite/recensioniseguite/Alice)
echo 

echo "# le recensioni seguite da Bob" 
echo $(curl -s localhost:8080/recensioni-seguite/recensioniseguite/Bob)
echo 

echo "# le recensioni seguite da Carlo" 
echo $(curl -s localhost:8080/recensioni-seguite/recensioniseguite/Carlo)
echo 

