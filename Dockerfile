FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/final_project-1.0.0.jar Project_Backend.jar
ENTRYPOINT ["java","-jar","/Project_Backend.jar"]