# Workstation 

Questo è un ulteriore ambiente di esecuzione pensato per la compilazione dei progetti, 
nonché per l'esecuzione di applicazioni Java distribuite, 
alternativo a *developer*, con le seguenti differenze: 

* ha una configurazione più potente in termini di memoria e processore, 
  per consentire anche l'esecuzione concorrente di molteplici applicazioni
  
* oltre al software di sviluppo per *Java* ha anche *Docker* 
  (utile, per esempio, se si vuole eseguire qualcosa in un contenitore)
  
Per questo, richiede sul sistema host una quantità di risorse maggiori che non l'ambiente *developer*. 

E' composto da una sola macchina virtuale **workstation**. 

## Descrizione delle macchine virtuali 

### workstation

La macchina virtuale **workstation** ha il seguente software 

* Ubuntu 20.04 LTS a 64 bit (by Bento) 

* Java SDK (Open JDK)
  
* Gradle 

* Apache Maven 

* Docker 

* Docker Compose 

Configurazione di rete 

* Indirizzo IP: 10.11.1.121 
  <!-- (come *developer*) --> 

* Porte pubblicate sull'host: 8080 -> 8080 (http) (come *developer*) 
  <!-- , nonché 9092 -> 9092 (Kafka), 5432 -> 5432 (Postgres) -->

Hardware (virtuale) 

* Memoria: 2048 MB (2 GB) --> 4096 MB (4.0 GB) 

* Virtual CPU: 2 --> 4 
