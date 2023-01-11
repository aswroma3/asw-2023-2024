#!/bin/bash

echo 'Updating hello (version v2)' 

kubectl apply -f hello-update-v2.yaml -n hello-update

kubectl rollout status deployment hello-update -n hello-update


