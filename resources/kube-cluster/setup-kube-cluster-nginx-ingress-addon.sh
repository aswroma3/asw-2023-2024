#!/bin/bash

# nota: ci sono ingress controller basati su nginx: 1) uno mantenuto da nginx e 2) uno da kubernetes
# 1) https://www.nginx.com/products/nginx-ingress-controller 
#    https://github.com/nginxinc/kubernetes-ingress  
# 2) https://github.com/kubernetes/ingress-nginx/blob/main/README.md 
#    https://kubernetes.github.io/ingress-nginx/deploy/ 

# qui proviamo a usare il primo 
# anche in questo caso non riesco a usare la porta 80 

echo "======================================================="
echo "installing kubernetes nginx ingress controller (master)"
echo "======================================================="

# https://docs.nginx.com/nginx-ingress-controller/installation/installation-with-manifests/ 

# attenzione: usare una versione specifica e non usare il branch "main"
GITHUB_URL=https://raw.githubusercontent.com/nginxinc/kubernetes-ingress/v2.4.2/deployments/

kubectl apply -f ${GITHUB_URL}common/ns-and-sa.yaml
kubectl apply -f ${GITHUB_URL}rbac/rbac.yaml

kubectl apply -f ${GITHUB_URL}common/default-server-secret.yaml
kubectl apply -f ${GITHUB_URL}common/nginx-config.yaml

kubectl apply -f ${GITHUB_URL}common/ingress-class.yaml

#curl -s -L ${GITHUB_URL}common/ingress-class.yaml \
#        | sed 's/name: nginx/name: nginx2/g' \
#		> /etc/kube-cluster/ingress-class.yaml
#kubectl apply -f /etc/kube-cluster/ingress-class.yaml


kubectl apply -f ${GITHUB_URL}common/crds/k8s.nginx.org_virtualservers.yaml
kubectl apply -f ${GITHUB_URL}common/crds/k8s.nginx.org_virtualserverroutes.yaml
kubectl apply -f ${GITHUB_URL}common/crds/k8s.nginx.org_transportservers.yaml
kubectl apply -f ${GITHUB_URL}common/crds/k8s.nginx.org_policies.yaml

kubectl apply -f ${GITHUB_URL}common/crds/k8s.nginx.org_globalconfigurations.yaml

kubectl apply -f ${GITHUB_URL}deployment/nginx-ingress.yaml
# kubectl apply -f ${GITHUB_URL}daemon-set/nginx-ingress.yaml

#curl -s -L ${GITHUB_URL}deployment/nginx-ingress.yaml \
#        | sed 's/containerPort: 80$/containerPort: 31080/g' \
#        | sed 's/containerPort: 443$/containerPort: 31443/g' \
#		> /etc/kube-cluster/nginx-ingress.yaml
#kubectl apply -f /etc/kube-cluster/nginx-ingress.yaml

kubectl create -f ${GITHUB_URL}service/nodeport.yaml

curl -s -L ${GITHUB_URL}service/nodeport.yaml \
        | sed 's/targetPort: 80$/&\n    nodePort: 80/' \
        | sed 's/targetPort: 443$/&\n    nodePort: 443/' \
		> /etc/kube-cluster/nodeport.yaml

curl -s -L https://raw.githubusercontent.com/nginxinc/kubernetes-ingress/v2.4.2/deployments/service/nodeport.yaml \
        | sed 's/targetPort: 80$/&\n    nodePort: 31080/' \
        | sed 's/targetPort: 443$/&\n    nodePort: 31443/' \
		> /etc/kube-cluster/nodeport.yaml

kubectl apply -f /etc/kube-cluster/nodeport.yaml

# test: 
# kubectl get pods --namespace=nginx-ingress (il controller deve essere Running)
# kubectl get service nginx-ingress --namespace=nginx-ingress (la porta 80 deve essere mappata su 31080)

# uninstall: 
# kubectl delete namespace nginx-ingress

