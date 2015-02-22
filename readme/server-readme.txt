Das Projekt kann als Web-Anwendung auf verschiedenen Java-EE-7-Servern deployt werden. 

Die Server selbst sind nicht Bestandteil der Projekte. Sie müssen vielmehr von den jeweiligen Download-Seiten geladen werden:
- GlassFish: http://glassfish.java.net/public/downloadsindex.html#top
- WildFly: http://www.wildfly.org/downloads/

Die Installation geschieht einfach durch Entpacken des Download-Files an einer Stelle Ihrer Wahl.


Das Deployment der Anwendung geschieht durch Kopieren des Ergebnisses des Maven-Builds aus dem
target-Verzeichnis in das Autodeploy-Verzeichnis des Servers, z. B. (Server-Startverzeichnisse bitte anpassen):
- jpa-demos.war --> wildfly-8.x\standalone\deployments
Alternativ kann der gewünschte Server auch in die genutzte IDE integriert werden. Siehe dazu die Doku der IDE.
