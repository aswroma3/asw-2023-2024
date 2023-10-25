#!/bin/bash

N=${1:-10}

# itera la richiesta N volte (default: 10) 

for ((i=0; i<$N; i++)); do 
	echo $i $(curl -s localhost:8080)
done 
