#!/bin/bash

echo 'Updating hello (version v3)' 

kubectl apply -f hello-update-v3.yaml -n hello-update

kubectl rollout status deployment hello-update -n hello-update


