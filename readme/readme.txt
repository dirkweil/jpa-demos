Allgemeines
===========

Das Projekt ist als Maven-Projekt aufgebaut.

Maven selbst wie auch ein Java-SDK müssen vorweg installiert werden. Benötigt werden zumindest diese Versionen:
- Maven 3 (s. http://maven.apache.org/download.html)
- JDK 7 (s. http://www.oracle.com/technetwork/java/javase/downloads/index.html)

Definieren Sie bitte zwei Environment-Variablen, die die Installationsverzeichnisse von Maven und JDK enthalten:
  
  Variable   Wert
  ---------  --------------------------------------------------------------------------
  M2_HOME    Installations-Verzeichnis von Maven (z. B. D:\programme\apache-maven-3.2.5)
  JAVA_HOME  Installations-Verzeichnis des JDK (z. B. C:\Program Files\Java\jdk1.7.0_72)
  
Ergänzen Sie dann noch die Variable PATH um die jeweiligen bin-Verzeichnisse
  
  PATH       Windows: %M2_HOME%\bin;%JAVA_HOME%\bin;...
             Unix:    $M2_HOME/bin:$JAVA_HOME/bin:...
  
Ein "mvn" auf der Kommandozeile im Projekt sollte ausreichen, um die Anwendung zu bauen (im pom.xml ist als Default-Goal 
"install" eingetragen). Das Build-Ergebniss findet sich dann Maven-typisch im Ordner "target" des Projekts.

Bequemer ist zweifellos die Bearbeitung mit einer IDE. Hinweise dazu finden Sie im Ordner ide. Das Maß der Dinge ist aber der
Maven-Build. Nur wenn der problemlos durchführbar ist, sollten Sie das Projekt in eine IDE ihrer Wahl importieren.

Das Projekt enthält JUnit Tests (im Source-Ordner src/test). Für den normalen Build sind die Tests allerdings
ausgeschaltet. Zur Ausführung der Tests mit Maven muss daher das Maven-Profil test verwendet werden:
  mvn -Ptest test

Das Projekt erlaubt die Nutzung unterschiedlicher Provider und Datenbanken für die Tests. Dazu sind entsprechende Maven-Profile
vorhanden. Sie werden auf der Kommandozeile mit der Option -P aktiviert (mvn -Pprofile,profile,... ...). Folgende Profile
sind vorhanden:

  Profil         Bedeutung
  -------------  ----------------------------------------------------------------------------
  jpa_hibernate  Standardprovider für die Tests ist Eclipselink. Mit diesem Profil wird stattdessen Hibernate verwendet.
  
  db_h2-file     Die Tests werden normalerweise mit einer In-Memory-H2-Datenbank durchgeführt. Durch die Aktivierung
  db_mysql         eines der Profile db_xxx wird stattdessen eine persistente H2-DB bzw. MySQL verwendet.
                   Weitere Details zur genutzten Datenbank siehe database-readme.txt.
   
Innerhalb von Eclipse kann das Profile gewählt werden, indem mit der rechten Maustaste auf das Projekt geklickt wird und dann im
Kontextmenü "Maven" -> "Select Maven Profiles" genutzt wird.   

Die Profile wirken sich nur auf die (SE-)Tests aus. Die Anwendung kann auch als Web-Anwendung auf einen Java-EE-7-Server
deployt werden, um die JPA-Nutzung im EE-Kontext zu demonstrieren. Zur Server-Installation siehe server-readme.txt.

Die Tests sind zum größten Teil "grün". Einige Tests schlagen allerdings abhängig vom JPA-Provider fehl. Der aktuelle
Stand findet sich in bugs-readme.txt. 
