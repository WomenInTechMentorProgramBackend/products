FROM openjdk:17-oracle
COPY  target/products-0.0.1-SNAPSHOT.jar products-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/products-0.0.1-SNAPSHOT.jar"]
