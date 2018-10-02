FROM clojure:lein as builder

COPY ./ /source/ 
WORKDIR /source
RUN lein ring uberjar

FROM openjdk:11-jre-slim

EXPOSE 3000
COPY --from=builder /source/target/cpu_soak.jar /app.jar
RUN useradd --home /cpusoak --uid 1001 cpusoak 
USER cpusoak
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app.jar"]
