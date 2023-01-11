#!/bin/bash

echo 'Starting hello (version v1)' 

kubectl create namespace hello-update  
kubectl apply -f hello-update-v1.yaml -n hello-update --record 
# l'opzione --record è utile per effettuare un rollback 

kubectl rollout status deployment hello-update -n hello-update

