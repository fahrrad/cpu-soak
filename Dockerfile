FROM openjdk:11-jre-sid

COPY target/cpu_soak.jar /app.jar

RUN adduser --home /cpusoak --uid 1001 cpusoak -q  --disabled-login --disabled-password

USER cpusoak


CMD ["/usr/bin/java", "-jar", "/app.jar"]

