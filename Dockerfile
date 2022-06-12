FROM openjdk:11.0.7-jre-slim
WORKDIR /opt
COPY target/springBootKubernetesCrud.jar /opt/springBootKubernetesCrud.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springBootKubernetesCrud.jar"]