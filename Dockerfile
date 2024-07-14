FROM openjdk:11
EXPOSE 8080
ADD target/shopping-app.jar  shopping-app.jar 
ENTRYPOINT ["java", ".jar","shopping-app.jar"]
