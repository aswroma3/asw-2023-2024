# Spring Boot (asw-825)

Questo progetto contiene alcune applicazioni 
che esemplificano l'uso di [Spring Boot](https://spring.io/projects/spring-boot):  

* **a-hello** è un esempio minimale di applicazione Spring Boot  

* **b-hello-web** è un esempio minimale di applicazione web Spring Boot 

* **c-hello-web-mvc** esemplifica Spring Web MVC 

* **d-restaurant-web-data-jpa** è un'applicazione per la gestione di ristoranti, che esemplifica l'uso di Spring Data JPA (nel contesto di un'applicazione Spring Web MVC)

* **e-restaurant-with-menu** estende l'applicazione precedente con la gestione dei menu dei ristoranti 

* **f-restaurant-actuator** esemplifica l'uso di Spring Boot Actuator 

* **g-lucky-word-properties** esemplifica l'uso delle proprietà per la configurazione delle applicazioni 

* **h-lucky-word-profiles** esemplifica l'uso dei profili per la configurazione delle applicazioni

Le diverse applicazioni hanno una struttura simile, 
e la loro costruzione ed esecuzione è descritta qui di seguito. 

### Build  

Per la costruzione di ciascuna applicazione, vedere le istruzioni 
descritte nella sezione [projects/](../). 

In pratica, per compilare e assemblare ciascuna applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-825-spring-boot/a-hello`

2. per compilare e assemblare l'applicazione, usare il comando `gradle build` 

### Componenti eseguibili 

Ciascuna di queste applicazioni è composta da un unico componente eseguibile. 
Le applicazioni web possono essere accedute sulla porta **8080** dell'host, 
sia se eseguite sul proprio PC che se vengono eseguite 
nell'ambiente [developer](../../environments/developer/), sul nodo **dev**. 

### Ambiente di esecuzione 

Ciascuna di queste applicazioni può essere eseguita direttamente sul proprio PC,
oppure nell'ambiente [developer](../../environments/developer/), sul nodo **dev**. 
In questo modo, però, le applicazioni web che espongono servizi alla porta **8080** del nodo **dev** 
vengono pubblicate sulla porta **8080** dell'host. 

### Esecuzione 

Per eseguire un'applicazione (ad eccezione delle applicazioni 
**g-lucky-word-properties** e **h-lucky-word-profiles**, descritte più avanti): 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-825-spring-boot/a-hello`

2. eseguire il comando `gradle bootRun` (attenzione, bisogna usare il task `bootRun` di Gradle, e non il task `run`)

#### Esecuzione dell'applicazione **g-lucky-word-properties** 

Posizionarsi nella cartella principale dell'applicazione, `~/projects/asw-825-spring-boot/g-lucky-word-properties` e poi: 

* eseguire lo script `../run-with-default-property.sh` (oppure il comando `gradle bootRun`) 
  per avviare il servizio usando la parola fortunata di default (la parola fortunata è *Default*)

* eseguire lo script `../run-with-argument.sh` (oppure il comando `gradle bootRun --args="--lucky.word=Argument"`)
  per avviare il servizio passando la parola fortunata come un argomento (la parola fortunata è *Argument*)

* eseguire lo script `../run-with-env-variable.sh` (oppure il comando `LUCKY_WORD="Environment variable" gradle bootRun`)
  per avviare il servizio passando la parola fortunata mediante una variabile d'ambiente (la parola fortunata è *Environment variable*)

#### Esecuzione dell'applicazione **h-lucky-word-profiles** 

Posizionarsi nella cartella principale dell'applicazione, `~/projects/asw-825-spring-boot/h-lucky-word-profiles` e poi: 

* eseguire lo script `../run-as-default.sh` (oppure il comando `gradle bootRun`)
  per avviare il servizio usando il profilo di default (la parola fortunata è *Default*)

* eseguire lo script `../run-as-english.sh` (oppure il comando `SPRING_PROFILES_ACTIVE="english" gradle bootRun`)
  per avviare il servizio usando il profilo **english** (la parola fortunata è *Happy*)

* eseguire lo script `../run-as-italian.sh` (oppure il comando `SPRING_PROFILES_ACTIVE="italian" gradle bootRun`)
  per avviare il servizio usando il profilo **italian** (la parola fortunata è *Evviva*)

