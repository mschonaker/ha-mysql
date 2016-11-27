FROM jboss/wildfly:10.1.0.Final
MAINTAINER Martín Schonaker <mschonaker@gmail.com>
ADD source/target/ROOT.war /opt/jboss/wildfly/standalone/deployments/
ADD mysql-connector-java-5.1.40.jar /opt/jboss/wildfly/modules/system/layers/base/mysql/mysql-connector-java/main/
ADD module.xml /opt/jboss/wildfly/modules/system/layers/base/mysql/mysql-connector-java/main/
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
