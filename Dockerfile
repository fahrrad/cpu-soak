FROM clojure:lein

COPY ./ /source/ 
WORKDIR /source
RUN lein ring uberjar

EXPOSE 3000

RUN useradd --home /cpusoak --uid 1001 cpusoak 
USER cpusoak
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/source/target/cpu_soak.jar"]
