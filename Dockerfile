FROM openjdk:8
EXPOSE 8060
ADD target/pfeeeeedocker.jar pfeeeeedocker.jar
ENTRYPOINT ["java","-jar","/pfeeeeedocker.jar"]