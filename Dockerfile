# Etapa de compilación
FROM maven:3.8.4-openjdk-17 AS build

# Copiar el proyecto padre
COPY ./pom.xml /app/
COPY ./payment-domain /app/payment-domain
COPY ./payment-infrastructure /app/payment-infrastructure
COPY ./payment-application /app/payment-application

# Compilar el proyecto
WORKDIR /app
RUN mvn clean package

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Copiar el JAR ejecutable desde la etapa de compilación
COPY --from=build /app/payment-application/target/*.jar /app/app.jar

# Exponer el puerto (ajusta según sea necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]