#!/bin/bash

echo "========================================="
echo "installing calico network add-on (master)"
echo "========================================="

# usa questa pod network al posto di quella di default (192.168.0.0)
# POD_NETWORK_CIDR=10.12.0.0
POD_NETWORK_CIDR=$1

# avvio il controller di rete Calico che si occupa della sicurezza del cluster
# https://projectcalico.docs.tigera.io/about/about-calico

#kubectl apply -f https://docs.projectcalico.org/v3.1/getting-started/kubernetes/installation/hosted/rbac-kdd.yaml
#kubectl apply -f https://docs.projectcalico.org/v3.1/getting-started/kubernetes/installation/hosted/kubernetes-datastore/calico-networking/1.7/calico.yaml
# https://docs.projectcalico.org/v3.8/getting-started/kubernetes/
#kubectl apply -f https://docs.projectcalico.org/v3.8/manifests/calico.yaml

# see https://projectcalico.docs.tigera.io/about/about-calico
# see https://projectcalico.docs.tigera.io/getting-started/kubernetes/ 

# kubectl create -f https://projectcalico.docs.tigera.io/manifests/tigera-operator.yaml
# curl https://projectcalico.docs.tigera.io/manifests/custom-resources.yaml -O
# kubectl create -f custom-resources.yaml

mkdir -p /etc/kube-cluster
#curl -L https://docs.projectcalico.org/v3.14/manifests/calico.yaml | sed s/192.168.0.0/${POD_NETWORK_CIDR}/ > /etc/kube-cluster/calico-kube-cluster.yaml

#curl -L https://docs.projectcalico.org/v3.14/manifests/calico.yaml \
#        | sed s/'# - name: CALICO_IPV4POOL_CIDR'/'- name: CALICO_IPV4POOL_CIDR'/ \
#        | sed s/'#   value: "192.168.0.0\/16"'/'  value: "192.168.0.0\/16"'/ \
#        | sed s/192.168.0.0/${POD_NETWORK_CIDR}/ \
#		> /etc/kube-cluster/calico-kube-cluster.yaml

#curl -s -L https://docs.projectcalico.org/v3.19/manifests/calico.yaml \
#        | sed s/'# - name: CALICO_IPV4POOL_CIDR'/'- name: CALICO_IPV4POOL_CIDR'/ \
#        | sed s/'#   value: "192.168.0.0\/16"'/'  value: "192.168.0.0\/16"'/ \
#        | sed s/192.168.0.0/${POD_NETWORK_CIDR}/ \
#		> /etc/kube-cluster/calico-kube-cluster.yaml

curl -s -L https://projectcalico.docs.tigera.io/manifests/custom-resources.yaml \
        | sed s/192.168.0.0/${POD_NETWORK_CIDR}/ \
		> /etc/kube-cluster/calico-custom-resources.yaml

kubectl create -f https://projectcalico.docs.tigera.io/manifests/tigera-operator.yaml 
kubectl create -f /etc/kube-cluster/calico-custom-resources.yaml


