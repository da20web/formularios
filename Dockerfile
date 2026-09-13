# Estágio 1: Construção (Build)
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copia os arquivos do projeto
COPY pom.xml .
COPY src ./src
# Compila o projeto e pula os testes para o deploy ser mais rápido
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Run)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia apenas o arquivo .war gerado no estágio anterior
COPY --from=build /app/target/*.war app.war

# O Spring Boot roda na porta 8080 por padrão
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-Xmx150m", "-Xms150m", "-jar", "app.war"]
