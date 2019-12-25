FROM openjdk:8-jdk-alpine
#RUN mkdir -p /app
COPY target/* /app/
COPY dockerfiles/run.sh /app
RUN chmod +x /app
#ENTRYPOINT "java"
CMD ["java", "-jar", "/app/BookRest-1.jar"]