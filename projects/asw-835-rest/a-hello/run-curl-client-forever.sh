#!/bin/bash

# accede al servizio Hello, iterando la richiesta all'infinito 

while true; do 
	curl -s --get "http://localhost:8080/hello/World"
	echo "" ; 
done 
