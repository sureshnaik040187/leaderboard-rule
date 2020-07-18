FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/league-*.jar
COPY . /league
RUN git reset --hard
    git pull origin master