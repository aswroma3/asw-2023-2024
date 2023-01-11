#!/bin/bash

# utilizzato per impostare le variabili d'ambiente utili
# durante il provisioning delle macchine
# prende in ingresso i parametri di configurazione forniti
# al suo lancio da Vagrantfile

STARTING_IP=$1
CLUSTER_DOMAIN=$2
CLUSTER_NODE_PREFIX=$3
# forza la conversione a integer 
CLUSTER_NUM_NODES=$(($4 + 0))

read IP_A IP_B IP_C IP_D <<<"${STARTING_IP//./ }"
IP_PREFIX=${IP_A}.${IP_B}.${IP_C}.
IP_STARTING_NUM=${IP_D}

SSL_DNS="${CLUSTER_DOMAIN}"

for ((i = 1; i <= ${CLUSTER_NUM_NODES}; i++))
do 
    CURRENT_NUM=$(($IP_STARTING_NUM+$i))
    CURRENT_IP=${IP_PREFIX}${CURRENT_NUM}
    if [[ $i == 1 ]];
    then
        SSL_IP+="${CURRENT_IP}"
    else
        SSL_IP+=",${CURRENT_IP}"
    fi
    SSL_DNS="${SSL_DNS},${CLUSTER_NODE_PREFIX}$i"
done

echo "export STARTING_IP=$STARTING_IP" >> ~/.profile
echo "export CLUSTER_DOMAIN=$CLUSTER_DOMAIN" >> ~/.profile
echo "export CLUSTER_NODE_PREFIX=$CLUSTER_NODE_PREFIX" >> ~/.profile
echo "export CLUSTER_NUM_NODES=$CLUSTER_NUM_NODES" >> ~/.profile
echo "export SSL_DNS=${SSL_DNS}" >> ~/.profile
echo "export SSL_IP=${SSL_IP}" >> ~/.profile
echo "export IP_PREFIX=${IP_PREFIX}" >> ~/.profile
echo "export IP_STARTING_NUM=${IP_STARTING_NUM}" >> ~/.profile