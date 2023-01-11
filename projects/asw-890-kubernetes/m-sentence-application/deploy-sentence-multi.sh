#!/bin/bash

echo 'Starting sentence' 

kubectl create namespace sentence
kubectl create -f sentence-application-multi.yaml -n sentence

# kubectl rollout status deployment/sentence -n sentence

