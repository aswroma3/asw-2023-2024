# Architettura dei Sistemi Software a Roma Tre (2022-2023)

Benvenuti al repository del corso 
di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/) 
a Roma Tre, 
edizione 2022-2023 (A.A. 2022-2023), 
tenuto dal prof. [Luca Cabibbo](http://cabibbo.dia.uniroma3.it/). 

Questo è invece il link alla [precedente edizione completa del repository](https://github.com/aswroma3/asw-2022). 

Questo repository contiene il codice delle *esercitazioni* 
del corso di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/), 
che sono relative a delle semplici *applicazioni software distribuite* 
(basate sull'uso di *middleware*), 
che vanno eseguite in degli opportuni *ambienti distribuiti*: 
* il software è normalmente scritto in [Java](http://www.oracle.com/technetwork/java/index.html), 
  e costruito con [Gradle](http://gradle.org/); 
* ciascun ambiente di esecuzione distribuito è composto da una o più macchine virtuali create con 
  [VirtualBox](https://www.virtualbox.org/) e [Vagrant](https://www.vagrantup.com/), 
  e accedute tramite [Git](https://git-scm.com/); 
* inoltre, alcuni ambienti di esecuzione sono basati sui container [Docker](https://www.docker.com/)
  e sull'orchestrazione di container [Kubernetes](https://kubernetes.io/)

## Software da installare sul proprio PC 

### Software per la gestione degli ambienti di esecuzione  

Ecco il software utilizzato dal docente per la gestione degli ambienti di esecuzione con *Windows 11 Pro (versione 22H2)*. 

* [VirtualBox](https://www.virtualbox.org/), versione 7.0.6
* [Vagrant](https://www.vagrantup.com/), versione 2.3.4
* [Git](https://git-scm.com/) 
* opzionalmente [Docker](https://www.docker.com/), 
  che però non è strettamente necessario, poiché può essere eseguito nelle macchine virtuali. 

E' importante osservare che VirtualBox potrebbe non essere compatibile con Hyper-V di Microsoft, 
e potrebbe avere un rallentamento significativo dalla Virtualization Based Security di Windows 11. 
A tal fine, io ho utilizzato la seguente configurazione di *Windows 11*: 
* disabilitazione di *Hyper-V*: 
  * tra le *Impostazioni* di *Windows 11*, cercare *Attiva o disattiva funzionalità di Windows* 
    (oppure *Attivazione o disattivazione delle funzionalità di Windows*)
    e disabilitare le opzioni *Piattaforma macchina virtuale*, *Piattaforma Windows Hypervisor* e *Hyper-V* 
  * riavviare il computer 
* disabilitazione di *Virtualization Based Security* (**attenzione: questo migliora le prestazioni di VirtualBox, ma peggiore la sicurezza del sistema**): 
  * con l'*Editor del Registro di Sistema* cercare la voce 
    *Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\DeviceGuard* 
	ed impostare il valore di *EnableVirtualizationBasedSecurity* a *0*  
  * tra le *Impostazioni* di *Windows 11*, cercare *Privacy e Sicurezza*, *Sicurezza di Windows*, *Sicurezza dispositivi*, *Isolamento Core* 
    e disabilitare le opzioni *Integrità della memoria* e *Protezione del firmware* 
  * riavviare il computer 

### Software per lo sviluppo del software 

Ecco il software opzionale per lo sviluppo del software (non è strettamente necessario, poiché può essere eseguito nelle macchine virtuali):
* [Java SDK](http://www.oracle.com/technetwork/java/javase/) 
* [Gradle](http://gradle.org/) 

## Organizzazione del repository 

Questo repository è organizzato in diverse sezioni (cartelle): 
* [projects](projects/) contiene il codice delle *applicazioni distribuite*, 
  con una sottosezione (sottocartella) per ciascuno degli argomenti del corso; 
* [environments](environments/) contiene il codice per la gestione degli *ambienti distribuiti*, 
  con una sottosezione (sottocartella) per ciascuno degli ambienti distribuiti 
  su cui poter eseguire le applicazioni distribuite sviluppate; 
* [shared](shared/) contiene ulteriori risorse condivise per la gestione degli *ambienti distribuiti*. 

Queste sezioni non sono indipendenti, ma correlate (in modo non banale). 
<!---
Per esempio, il progetto **hello-rmi** (in [projects](projects/))
va eseguito nell'ambiente **client-server** (in [environments](environments/)). 
-->

Attualmente non sono presenti tutti i progetti e nemmeno tutti gli ambienti. 
Verranno aggiunti a questo repository durante lo svolgimento del corso. 

## Accesso al repository 

Per effettuare il download del repository, usare il seguente comando Git 
dalla cartella locale in cui si vuole scaricare il repository: 

    git clone https://github.com/aswroma3/asw 

Oppure (se il sistema host è Windows): 

    git clone --config core.autocrlf=input https://github.com/aswroma3/asw 

Per aggiornare il contenuto della propria copia locale del repository, 
usare il seguente comando Git dalla cartella locale in cui è stato scaricato il repository: 

    git pull 
