#!/bin/bash

# accede al servizio tramite ingress - ovvero, tramite il nome del servizio (sulla porta 80 o, nel caso di kube-cluster, 31080)
# funziona anche dall'esterno del cluster (dal nodo dev)  

# NEL CLUSTER DEVE ESSERE INSTALLATO UN INGRESS CONTROLLER COME ADD-ON  
# non richiede che il nome del servizio sia registrato come alias in un DNS o in /etc/hosts 

# nell'ambiente kube-cluster, questo è l'indirizzo di uno dei nodi del cluster  
KUBE_CLUSTER_IP=10.11.1.71
# oppure 
# KUBE_CLUSTER_IP=$(ping kube-cluster -c1 | head -1 | awk -F'(' '{print $2}' | awk -F')' '{print $1}')

# nell'ambiente kube-cluster, la porta per l'ingress e' 31080 (31443 per https) 
INGRESS_PORT=31080
# oppure 
# INGRESS_PORT=$(kubectl get services/ingress-nginx-controller -n ingress-nginx -o go-template='{{(index .spec.ports 0).nodePort}}')

SERVICE=hello
SERVICE_HOST=hello.aswroma3.it

echo Accessing ${SERVICE} on ${SERVICE_HOST}:${INGRESS_PORT}

N=${1:-10}
for ((i=0; i<$N; i++)); do 
#	curl ${SERVICE_HOST}:${INGRESS_PORT} --resolve ${SERVICE_HOST}:${INGRESS_PORT}:${KUBE_CLUSTER_IP} 
#	echo "" ; 
#	curl ${SERVICE_HOST}:80 --connect-to ${SERVICE_HOST}:80:${KUBE_CLUSTER_IP}:${INGRESS_PORT} 
#	echo "" ; 
#	curl ${SERVICE_HOST}:80 --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} 
#	echo "" ; 
	curl ${SERVICE_HOST} --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} 
	echo "" ; 
done 

