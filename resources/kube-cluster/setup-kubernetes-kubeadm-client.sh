#!/bin/bash

echo "==============================================="
echo "installing kubernetes (with kubeadm) for client"
echo "==============================================="

# https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/

# let iptables see bridged traffic
cat <<EOF | tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
sysctl --system

# installing kubectl

apt-get update && sudo apt-get install -y apt-transport-https curl
curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
cat <<EOF | sudo tee /etc/apt/sources.list.d/kubernetes.list
deb https://apt.kubernetes.io/ kubernetes-xenial main
EOF
apt-get update
#apt-get install -y kubelet kubeadm kubectl
apt-get install -y kubectl
#apt-mark hold kubelet kubeadm kubectl
apt-mark hold kubectl

# oppure, semplicemente 
#snap install kubectl --classic