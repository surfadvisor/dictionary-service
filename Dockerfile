FROM openjdk:11-slim

MAINTAINER Daniel Poznański "misterdannypl@gmail.com"

ADD application/target/*-SNAPSHOT.jar app.jar

EXPOSE 5001

CMD ["java","-Xmx50m","-jar","app.jar"]
