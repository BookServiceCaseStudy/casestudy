FROM java:8
ENV SPRING_PROFILES_ACTIVE cloud
VOLUME /tmp
ADD registry-server-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 12871
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
