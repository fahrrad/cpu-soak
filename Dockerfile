FROM openjdk:11-jre-sid

COPY target/cpu_soak.jar /app.jar

CMD ["/usr/bin/java", "-jar", "/app.jar"]


