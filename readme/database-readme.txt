Datenbank
=========

Das Projekt benötigt eine Datenbank.

Im (SE-)Test-Anteil des Projekts, d. h. in src/test, ist der Zugriff auf eine H2-Datenbank mit den folgenden Verbindungsparametern 
konfiguriert:
  Connect-URL: jdbc:h2:mem:test;DB_CLOSE_DELAY=-1
  User:        test
  Passwort:    test
Damit wird eine H2-Datenbank im In-Memory-Modus verwendet, d. h. die DB wird für den Test im Speicher aufgebaut und anschließend
wieder verworfen.

Alternativ kann auch eine persistente Form de H2-DB verwendet werden. Das Maven-Profil db_h2-file aktiviert diese Verbindungs-
parameter:
  Connect-URL: jdbc:h2:~/h2/jpa-demos;AUTO_SERVER=TRUE
  User:        jpa-demos
  Passwort:    jpa-demos
Diese H2-DB liegt dann im Dateisystem im Verzeichnis ~/h2, wobei ~ das Home-Verzeichnis des aufrufenden Users bezeichnet. Bei
Bedarf wird die DB automatisch erzeugt. Die Tabellen werden bei Teststart neu angelegt und bleiben danach bestehen.

Mit dem Profil db_mysql kann als weitere Alternative eine MySQL-DB genutzt werden. Dies ist insbesondere für die Tests gedacht,
die Stored Procedures verwenden, da die ansonsten genutzte DB H2 keine (normalen) Stored Procedures unterstützt. Die Verbindungs-
Parameter sind diese:
  Connect-URL: jdbc:mysql://localhost:3306/jpa_demos
  User:        jpa_demos
  Passwort:    jpa_demos
Die Datenbank muss zuvor installiert worden sein. Der User (jpa_demos) benötigt DBA-Rechte für die DB.

Für die Nutzung der Anwendung als Web-Anwendung muss im verwendeten Applikationsserver eine Datasource mit dem JNDI-Namen 
jdbc/jpa-demos konfiguriert werden, die auf die gleiche Datenbank verweist.
Dazu bitte je nach Applikationsserver wie in database/xxx/xxx-database-readme.txt angegeben vorgehen.

Zum direkten Betrachten und Bearbeiten der DB-Inhalte eignen sich diverse JDBC-Tools, z. B. 
  DbVisualizer:    http://www.dbvis.com        (Achtung: Versionen vor 8.x unterstützen Java 7 nicht!)
  SQuirrel SQL:    http://www.squirrelsql.org  (Base-Version reicht)
  SQL Workbench/J: http://www.sql-workbench.net
