#!/bin/bash

source "/home/asw/resources/common.sh"

# versione per kube-cluster

#
# copia i file HOSTS.CONF e DAEMON.JSON per sovrascrivere la configurazione di docker 
# - il primo, per abilitare la comunicazione remota del nodo 
# - il secondo, per ulteriori configurazioni  
# 

# copia /etc/systemd/system/docker.service.d/hosts.conf
mkdir -p /etc/systemd/system/docker.service.d
cp ${ASW_RESOURCES}/kube-cluster/docker.service.d-kube-cluster/hosts.conf /etc/systemd/system/docker.service.d/hosts.conf
chmod a-x /etc/systemd/system/docker.service.d/hosts.conf

# kube-cluster: /etc/docker/daemon.json deve configurare systemd come Docker cgroup driver (anziché cgroupfs) 
# https://kubernetes.io/docs/setup/production-environment/container-runtimes/

# copia /etc/docker/daemon.json 
mkdir -p /etc/docker
cp ${ASW_RESOURCES}/kube-cluster/etc.docker-kube-cluster/daemon.json /etc/docker/daemon.json
chmod a-x /etc/docker/daemon.json