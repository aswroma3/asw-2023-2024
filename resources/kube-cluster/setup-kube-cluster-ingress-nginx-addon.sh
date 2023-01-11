#!/bin/bash

# nota: ci sono ingress controller basati su nginx: 1) uno mantenuto da nginx e 2) uno da kubernetes
# 1) https://www.nginx.com/products/nginx-ingress-controller 
#    https://github.com/nginxinc/kubernetes-ingress  
# 2) https://github.com/kubernetes/ingress-nginx/blob/main/README.md 
#    https://kubernetes.github.io/ingress-nginx/deploy/ 

# usiamo il secondo (malgrado non sia possibile accedervi sulla porta 80) 
# anche perché con il secondo non sono comunque riuscito a usare la porta 80 

echo "======================================================="
echo "installing kubernetes nginx ingress controller (master)"
echo "======================================================="


# kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/cloud/deploy.yaml

# modifica il file di configurazione in modo che la porta per http/https dell'ingress siano fissate su 31080/31443 

mkdir -p /etc/kube-cluster

curl -s -L https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.5.1/deploy/static/provider/baremetal/deploy.yaml \
        | sed 's/targetPort: http$/&\n    nodePort: 31080/' \
        | sed 's/targetPort: https$/&\n    nodePort: 31443/' \
		> /etc/kube-cluster/ingress-nginx-nodeport-deploy.yaml

kubectl apply -f /etc/kube-cluster/ingress-nginx-nodeport-deploy.yaml

# test: 
# kubectl get pods --namespace=ingress-nginx (il controller deve essere Running)
# kubectl get service ingress-nginx-controller --namespace=ingress-nginx (la porta 80 deve essere mappata su 31080)

# uninstall: 
# kubectl delete namespace ingress-nginx

