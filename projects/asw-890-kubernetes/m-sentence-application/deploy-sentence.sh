#!/bin/bash

echo 'Starting sentence' 

kubectl create namespace sentence
kubectl create -f sentence-application.yaml -n sentence

# kubectl rollout status deployment/sentence -n sentence

