#!/bin/bash

# accede al servizio sull'ip di un pod associato al replica set, sulla porta 8080 
# FUNZIONA SOLO DAI NODI DEL CLUSTER ma non da DEV 

APP=hello

echo Accessing ${APP}

PODS=$(kubectl get pods -l app=${APP} | grep ${APP} | awk '{print $1}')

while true; do 
    # POD=$(kubectl get pods -l app=${APP} | grep ${APP} | awk '{print $1}' | shuf -n 1)
    POD=$(shuf -e -n 1 ${PODS})
	POD_HOST=$(kubectl describe pod ${POD} | grep ^IP: | awk '{print $2}')
	POD_PORT=8080
	curl ${POD_HOST}:${POD_PORT}
	echo "" ; 
done 
