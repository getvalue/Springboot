FROM java:8
ADD target/mldemo-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8081
ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]