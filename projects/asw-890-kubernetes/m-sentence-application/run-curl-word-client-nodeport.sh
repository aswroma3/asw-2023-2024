#!/bin/bash

# accede al servizio per una parola tramite ingress  

WORD=${1:-subject}

N=${2:-1}

#SERVICE=sentence
SERVICE=apigateway
SERVICE_NAMESPACE=sentence

SERVICE_HOST=kube-cluster
SERVICE_PORT=$(kubectl get services/${SERVICE} -n ${SERVICE_NAMESPACE} -o go-template='{{(index .spec.ports 0).nodePort}}')

echo Accessing ${SERVICE}/${WORD} on ${SERVICE_HOST}:${SERVICE_PORT}/${WORD}

for ((i=0; i<$N; i++)); do 
	curl ${SERVICE_HOST}:${SERVICE_PORT}/${WORD}
	echo "" ; 
done 

