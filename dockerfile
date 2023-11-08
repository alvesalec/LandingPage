#BUILD
FROM maven:3.9-amazoncorretto-19 AS BUILD

COPY . .

RUN mvn clean package -DskipTests=true #Compilar/Buildar o projeto maven, pulando os testes

#Stage Package

FROM openjdk:17-jdk-slim
#Usando o slim para ficar mais leve, pois o de cima é só para buildar e esse para deixar no ar

COPY --from=BUILD /target/servletMude-1.0-SNAPSHOT.jar ServletAdm.jar
##O arquivo foi pego do pom.xml, pegando o artifact e a snapshot, colocando um .jar

#parametros: 1 - maquina, da onde vai vir, no caso, do build que fiz acima
#parametros: 2 - diretório da origem

#O artifact é o resultado da compilação

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "ServletAdm.jar"]