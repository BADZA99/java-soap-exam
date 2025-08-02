# Projet Maven SOAP Exam

## Prérequis
- **Version Java** : JDK 17
- **Version Tomcat** : Tomcat 10
- **Version Maven** : 3.9.9
- **Docker** : Docker Compose pour la configuration de la base de données

## Architecture

### Modules
1. **Module Metier** :
   - Contient la logique métier et les couches d'accès aux données.
   - **Fichiers** :
     - `dao` et `entity` pour la couche d'accès aux données.
     - `dto`, `mapper`, et `service` pour la couche métier.
   - Localisé dans `metier/src/main/java/com/exam`.

2. **Module Webservices** :
   - Contient l'implémentation des services web SOAP.
   - **Fichiers** :
     - `SectorWebService` et `SectorWebServiceImpl` pour les opérations liées aux secteurs.
     - `ClasseWebService` et `ClasseWebServiceImpl` pour les opérations liées aux classes.
   - Localisé dans `webservices/src/main/java/com/groupeisi/webservice`.

### Couches
1. **Couche Présentation** :
   - Gère l'interaction utilisateur et expose les API.
   - Inclut les services web SOAP dans le module `webservices`.

2. **Couche Métier** :
   - Gère la logique principale et le traitement des données.
   - Implémentée dans le module `metier`.

3. **Couche Accès aux Données** :
   - Gère les interactions avec la base de données.
   - Inclut les classes DAO et entity dans le module `metier`.

## Comment démarrer le projet

### Étapes
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/BADZA99/java-soap-exam.git
   ```
2. Naviguer dans le répertoire du projet :
   ```bash
   cd maven-soap-exam
   ```
3. Construire le projet :
   ```bash
   mvn clean install
   ```
4. Déployer le module `webservices` sur Tomcat 10.
5. Accéder au lien WSDL pour le service web SOAP et tester avec Postman.

### Configuration de la base de données avec Docker
1. Naviguer dans le répertoire `docker` :
   ```bash
   cd docker
   ```
2. Démarrer les services de base de données et phpMyAdmin :
   ```bash
   docker-compose up -d
   ```
3. Accéder à phpMyAdmin via `http://localhost:81`.

## Diagramme de Classe
Le diagramme de classe ci-dessous représente la structure du projet :

![Diagramme de Classe](DiagrammeDeClasse.png)

## Images
### Tests des services web SOAP
#### Tous les secteurs
![Tous les secteurs](images/all%20sectors.png)
#### Obtenir un secteur
![Obtenir un secteur](images/get%20sector%20.png)
#### Sauvegarder un secteur
![Sauvegarder un secteur](images/save%20sector.png)
#### Tous les classes
![Tous les classes](images/all%20classes.png)

## Problèmes rencontrés
### Erreur lors de la sauvegarde d'une classe
- **Message d'erreur** :
  ```
  02-Aug-2025 19:19:37.081 SEVERE [RMI TCP Connection(2)-127.0.0.1] com.sun.xml.ws.transport.http.servlet.WSServletContextListener.parseAdaptersAndCreateDelegate WSSERVLET11 : échec de l'analyse du descripteur d'exécution : jakarta.xml.ws.WebServiceException: class com.groupeisi.webservice.service.jaxws.Save do not have a property of the name classe
  jakarta.xml.ws.WebServiceException: class com.groupeisi.webservice.service.jaxws.Save do not have a property of the name classe
  ```

### Erreur lors de la récupération d'une classe
- **Réponse SOAP** :
  ```xml
  <?xml version='1.0' encoding='UTF-8'?>
  <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
      <S:Body>
          <S:Fault xmlns:ns4="http://www.w3.org/2003/05/soap-envelope">
              <faultcode>S:Server</faultcode>
              <faultstring>Can not set com.exam.metier.dto.SectorDto field com.groupeisi.webservice.service.jaxws.GetResponse._return to com.exam.metier.dto.ClasseDto</faultstring>
          </S:Fault>
      </S:Body>
  </S:Envelope>
  ```
