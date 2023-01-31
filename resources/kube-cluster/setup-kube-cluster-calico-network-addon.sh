#!/bin/bash

echo "========================================="
echo "installing calico network add-on (master)"
echo "========================================="

# usa questa pod network al posto di quella di default (192.168.0.0)
# POD_NETWORK_CIDR=10.12.0.0
POD_NETWORK_CIDR=$1

CALICO_FOLDER=/home/vagrant/kube-cluster/calico

mkdir -p ${CALICO_FOLDER}

curl -s -L https://projectcalico.docs.tigera.io/manifests/tigera-operator.yaml \
		> ${CALICO_FOLDER}/tigera-operator.yaml
curl -s -L https://projectcalico.docs.tigera.io/manifests/custom-resources.yaml \
        | sed s/192.168.0.0/${POD_NETWORK_CIDR}/ \
		> ${CALICO_FOLDER}/calico-custom-resources.yaml

kubectl create -f ${CALICO_FOLDER}/tigera-operator.yaml
kubectl create -f ${CALICO_FOLDER}/calico-custom-resources.yaml
