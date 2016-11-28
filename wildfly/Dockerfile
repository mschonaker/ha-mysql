FROM jboss/wildfly:10.1.0.Final
MAINTAINER Martín Schonaker <mschonaker@gmail.com>
ADD source/target/ROOT.war /opt/jboss/wildfly/standalone/deployments/
ADD mariadb-java-client-1.5.5.jar module.xml /opt/jboss/wildfly/modules/system/layers/base/org/mariadb/jdbc/main/
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
