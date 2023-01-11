#!/bin/bash

STARTING_IP=$1
CLUSTER_DOMAIN=$2
CLUSTER_NODE_PREFIX=$3
# forza la conversione a integer 
CLUSTER_NUM_NODES=$(($4 + 0))

HOSTS_FILE=/etc/hosts 

# aggiunge un # all'inizio delle linee che iniziano con 127.0.0.1 e 127.0.1.1 
function createModifiedEtcHosts
{
	echo "modifying 127.0.x.x entries in /etc/hosts"
	# Legge il file $INFILE e lo copia in $OUTFILE, ma: 
	# - aggiunge un # all'inizio delle linee che iniziano con 127.0. 
	sed s/^'127.0.'/'# 127.0.'/ ${HOSTS_FILE} > ${HOSTS_FILE}.new
	# aggiunge di nuovo 127.0.0.1 localhost
    echo "127.0.0.1 localhost" >> ${HOSTS_FILE}.new 
	mv ${HOSTS_FILE} ${HOSTS_FILE}.bak
	mv ${HOSTS_FILE}.new ${HOSTS_FILE}
}

# aggiunge a /etc/hosts le seguenti entry 
# - "10.11.1.71 kube-1 kube-cluster"
# - "10.11.1.72 kube-2 kube-cluster"
# - "10.11.1.73 kube-3 kube-cluster"
#
# in teoria, kube-cluster dovrebbe essere servito da un DNS, 
# a rotazione su uno qualunque di questi nodi. 
# in pratica, facendo così, kube-cluster coincide con kube-1
#
function configureKubeClusterEtcHosts {
	echo "adding entries for kube-cluster nodes to /etc/hosts"
	read IP_A IP_B IP_C IP_D <<<"${STARTING_IP//./ }"
	IP_PREFIX=${IP_A}.${IP_B}.${IP_C}.
	IP_STARTING_NUM=${IP_D}

	for ((i = 1; i <= ${CLUSTER_NUM_NODES}; i++))
	do 
		CURRENT_NUM=$(($IP_STARTING_NUM+$i))
		CURRENT_IP=${IP_PREFIX}${CURRENT_NUM}
		CURRENT_NODE=${CLUSTER_NODE_PREFIX}$i
		echo "${CURRENT_IP} ${CURRENT_NODE} ${CLUSTER_DOMAIN}" >> ${HOSTS_FILE}
	done
}

#function configureKubeClusterEtcHosts {
#	echo "adding entries for kube-cluster nodes to /etc/hosts"
#	echo "10.11.1.71 kube-1 kube-cluster" >> ${HOSTS_FILE}
#	echo "10.11.1.72 kube-2 kube-cluster" >> ${HOSTS_FILE}
#	echo "10.11.1.73 kube-3 kube-cluster" >> ${HOSTS_FILE}
#}

echo "setup /etc/hosts on a kube-cluster node"
createModifiedEtcHosts
configureKubeClusterEtcHosts