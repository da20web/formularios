# STAGE 1: BUILD
FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copia apenas o pom.xml primeiro para aproveitar cache do Maven
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o restante do código
COPY src ./src

# Build do WAR
RUN mvn clean package -DskipTests -B

# STAGE 2: RUNTIME
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o WAR gerado pelo build
COPY --from=build /app/target/*.war app.war

# A Vercel define a porta em $PORT; o Spring deve escutar nela
ENV PORT=8080
EXPOSE $PORT

# Executa o WAR como aplicação standalone (Tomcat embutido)
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.war"]
