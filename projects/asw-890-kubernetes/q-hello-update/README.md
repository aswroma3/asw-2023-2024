# Rolling update con Kubernetes

Questo sottoprogetto esemplifica l'esecuzione di rolling update con **Kubernetes**. 


## Ambiente di esecuzione 

Questa applicazione va eseguita nell'ambiente [kube-cluster](../../environments/kube-cluster/), sul nodo **kube-dev**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client.  


## Esecuzione 

Sul nodo **kube-dev**, si proceda come segue: 

* per avviare l'applicazione **hello**, nella versione **1.0**, eseguire lo script `a-deploy-hello-v1.sh` 

* in un'altra finestra, eseguire lo script `run-curl-client-ingress` (oppure `run-curl-client-nodeport.sh`) 
  che invoca il servizio **hello** in un ciclo infinito e consente di monitorare la versione attualmente in esecuzione dell'applicazione 
 
* per aggiornare l'applicazione **hello** alla versione **2.0**, eseguire lo script `b-update-hello-v2.sh` 

* nell'altra finestra, verificare la transizione dalla versione **1.0** alla versione **2.0** per tutte le repliche del servizio  

* per aggiornare l'applicazione **hello** alla versione **3.0**, eseguire lo script `c-update-hello-v3.sh` 

* nell'altra finestra, verificare la transizione dalla versione **2.0** alla versione **3.0** per tutte le repliche del servizio  

* la versione **3.0** dell'applicazione è però lenta e problematica; 
  per effettuare il rollback alla versione precedente dell'applicazione, eseguire lo script `d-rollback-hello` 

* nell'altra finestra, verificare la transizione dalla versione **3.0** alla versione **2.0** per tutte le repliche del servizio  

* per arrestare l'applicazione **hello**, eseguire lo script `undeploy-hello.sh` 

