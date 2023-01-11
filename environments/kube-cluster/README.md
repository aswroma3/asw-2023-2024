# Kubernetes (kube-cluster)

Questo ambiente di esecuzione è composto da un cluster di nodi *Kubernetes*, realizzato con *kube-adm*, 
più un nodo per la compilazione dei progetti e per la costruzione delle immagini dei contenitori *Docker*. 

E' composto da quattro macchine virtuali

* le macchine virtuali **kube-1**, **kube-2** e **kube-3** per il cluster *Kubernetes* realizzato con *kube-adm* 

* la macchina virtuale **kube-dev** per lo sviluppatore 


## Descrizione delle macchine virtuali 

### kube-1, kube-2, kube-3

Le macchine virtuali **kube-1**, **kube-2** e **kube-3** per il cluster *Kubernetes* hanno il seguente software 

* Ubuntu 20.04 LTS a 64 bit (by Bento) 

* Containerd come container engine  

* Kubernetes (kube-adm) 

Il nodo **kube-1** è configurato come *master*, mentre i nodi **kube-2** e **kube-3** sono configurati come *worker*. 

Configurazione di rete 

* Indirizzi IP: 10.11.1.71, 10.11.1.72 e 10.11.1.73 (rispettivamente) 

* Porte pubblicate sull'host: la porta 8080 (http) è pobblicata sulle porte 8081, 8082, 8083 (rispettivamente)

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB)  

* Virtual CPU: 2 

* CPU execution cap: 100% (kube-1), 50% (kube-2 e kube-3) 

### kube-dev

La macchina virtuale **kube-dev** ha il seguente software 

* Ubuntu 20.04 LTS a 64 bit (by Bento) 

* Java SDK (Open JDK), Gradle e Maven 

* Docker e Docker Compose 

* Kubernetes (kube-adm) client 

* Helm 

Configurazione di rete 

* Indirizzo IP: 10.11.1.131 

* Porte pubblicate sull'host: 8080 (http) -> 8089   

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB)  

* Virtual CPU: 2 

* CPU execution cap: 50% 
