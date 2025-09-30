FROM tomcat:9.0.109-jdk17-temurin-noble

ENV JAVA_OPTS="-Xmx4096m -Xms4096m"

COPY ./hti-ss-web/target/sstool.war /usr/local/tomcat/webapps/sstool.war
COPY ./dockerConfigs/webapp/context.xml /usr/local/tomcat/conf/context.xml
COPY ./dockerConfigs/webapp/server.xml /usr/local/tomcat/conf/server.xml

CMD ["catalina.sh", "run"]