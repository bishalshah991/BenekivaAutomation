FROM ubuntu:latest


WORKDIR /app

# Install Java and necessary packages

RUN apt-get update && apt-get install -y openjdk-18-jdk maven xvfb curl jq wget 

ARG JAVA_HOME="/usr/lib/jvm/java-18-openjdk-amd64"
ENV JAVA_HOME=$JAVA_HOME


# Copy the pom.xml file to the app directory and install dependencies
COPY pom.xml /app

RUN mvn package -DskipTests=true


COPY testing.xml /app

# Copy the rest of the files to the app directory
COPY . /app/

COPY src /app/src


# Create Entrypoint here
COPY entrypoint.sh /app/
# COPY start_vnc.sh /app/

RUN chmod +x /app/entrypoint.sh
# RUN chmod +x /app/start_vnc.sh



ENTRYPOINT ["/app/entrypoint.sh"]