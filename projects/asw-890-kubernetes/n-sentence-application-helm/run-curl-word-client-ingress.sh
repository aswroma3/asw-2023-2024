#!/bin/bash

# accede al servizio per una parola tramite ingress  

WORD=${1:-subject}

N=${2:-1}

# nell'ambiente kube-cluster, questo è l'indirizzo di uno dei nodi del cluster  
KUBE_CLUSTER_IP=10.11.1.71
# oppure 
# KUBE_CLUSTER_IP=$(ping kube-cluster -c1 | head -1 | awk -F'(' '{print $2}' | awk -F')' '{print $1}')

# nell'ambiente kube-cluster, la porta per l'ingress e' 31080 (31443 per https) 
INGRESS_PORT=31080
# oppure 
# INGRESS_PORT=$(kubectl get services/ingress-nginx-controller -n ingress-nginx -o go-template='{{(index .spec.ports 0).nodePort}}')

SERVICE=sentence
SERVICE_HOST=sentence.aswroma3.it

echo Accessing ${SERVICE}/${WORD} on ${SERVICE_HOST}:${INGRESS_PORT}/${WORD}

for ((i=0; i<$N; i++)); do 
#	curl ${SERVICE_HOST}:${INGRESS_PORT}/${WORD} --resolve ${SERVICE_HOST}:${INGRESS_PORT}:${KUBE_CLUSTER_IP} 
#	echo "" ; 
	curl ${SERVICE_HOST}/${WORD} --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} 
	echo "" ; 
done 

