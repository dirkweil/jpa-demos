Im GlassFish kann mit den folgenden Schritten eine Datasource mit dem JNDI-Namen jdbc/jpaDemos konfiguriert werden:

- Bereitstellung des JDBC-Treibers:
  Das Projekt verwendet per Default eine H2-Datenbank. Ihr Treiber ist nach einem erfolgreichen Maven-Build im 
  lokalen Repository vorhanden:
    ~/.m2/repository/com/h2database/h2/1.3.171/h2-1.3.171.jar (~ = Home-Verzeichnis des Users)
  Diese Datei wird in das Verzeichnis glassfish/domains/domain1/lib/ext der GlassFish-Installation kopiert. Der Server
  muss anschliessend neu gestartet werden.
  
- Konfiguration eines JDBC Connection Pools und einer dazu passenden Datasource:
  - Start der Administration Console im Browser (http://localhost:4848)
  - Im Menüpunkt "Resources -> JDBC -> JDBC Connection Pools" mit dem Button "New" einen neuen Eintrag erzeugen mit diesen Parametern:
     Pool Name              jpaDemosPool
     Resource Type          javax.sql.DataSource
     Database Driver Vendor H2
     User                   jpa-demos
     Password	            jpa-demos
     URL                    jdbc:h2:~/h2/jpa-demos;AUTO_SERVER=TRUE
  - Im Menüpunkt "Resources -> JDBC -> JDBC Resources" mit dem Button "New" einen neuen Eintrag erzeugen mit diesen Parametern:
     JNDI Name              jdbc/jpaDemos
     Pool Name              jpaDemosPool
     Status	                enabled