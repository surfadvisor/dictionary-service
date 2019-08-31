FROM openjdk:11-slim

MAINTAINER Daniel Poznański "misterdannypl@gmail.com"

EXPOSE 5001

ADD app.jar app.jar

CMD ["java","-Xmx50m","-jar","app.jar"]
