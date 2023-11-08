# Use an official Tomcat base image
FROM tomcat:9.0-jdk11-openjdk-slim

# Create a directory for your application
RUN mkdir /usr/local/your_web_app

# Copy the pom.xml file to the container (this allows Docker to cache your dependencies)
COPY pom.xml /usr/local/your_web_app/

# Change working directory to your application directory
WORKDIR /usr/local/your_web_app

# Copy the entire project to the container
COPY . /usr/local/your_web_app

# Build the application using Maven
RUN mvn clean package

# Copy the WAR file to the webapps directory of Tomcat
RUN cp target/maven-war-plugin.war /usr/local/tomcat/webapps/

# Expose the port that the servlet container will listen on
EXPOSE 8080

# Start Tomcat when the container launches
CMD ["catalina.sh", "run"]