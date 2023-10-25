# Kubernetes (kube-cluster)

Questo ambiente di esecuzione è composto da un cluster di tre nodi [Kubernetes](https://kubernetes.io/), 
realizzato con [Kubeadm](https://kubernetes.io/docs/reference/setup-tools/kubeadm/), 
più un nodo per la compilazione dei progetti e per la costruzione delle immagini dei container *Docker*. 

E' composto da quattro macchine virtuali

* le macchine virtuali **kube-1**, **kube-2** e **kube-3** per il cluster *Kubernetes* realizzato con Kubeadm

* la macchina virtuale **kube-dev** per lo sviluppatore 


## Descrizione delle macchine virtuali 

### kube-1, kube-2, kube-3

Le macchine virtuali **kube-1**, **kube-2** e **kube-3** per il cluster *Kubernetes* hanno il seguente software 

* Ubuntu 22.04 LTS a 64 bit (by Bento) 

* Containerd come container engine  

* Kubernetes (Kubeadm) 

Il nodo **kube-1** è configurato come *master*, mentre i nodi **kube-2** e **kube-3** sono configurati come *worker*. 

Configurazione di rete 

* Indirizzi IP: 10.11.1.71, 10.11.1.72 e 10.11.1.73 (rispettivamente) dei tre nodi 

* Porte pubblicate sull'host: la porta 8080 (http) è pobblicata sulle porte 8081, 8082, 8083 (rispettivamente) dei tre nodi 

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB)  

* Virtual CPU: 2 

* CPU execution cap: 100% (kube-1), 100% (kube-2 e kube-3) 

### kube-dev

La macchina virtuale **kube-dev** ha il seguente software 

* Ubuntu 22.04 LTS a 64 bit (by Bento) 

* Java SDK (Open JDK), Gradle e Maven 

* Docker e Docker Compose 

* Client Kubernetes (kubectl) 

* Helm 

Configurazione di rete 

* Indirizzo IP: 10.11.1.131 

* Porte pubblicate sull'host: 8080 (http) -> 8089   

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB)  

* Virtual CPU: 2 

* CPU execution cap: 100% 


## Tempo di preparazione dell'ambiente 

Tempo di primo provisioning dell'ambiente: circa 20-40 minuti 

