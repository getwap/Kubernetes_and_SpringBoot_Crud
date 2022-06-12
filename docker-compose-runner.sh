#!/bin/bash

#Package the services
mvn clean install -DskipTests=true

#Stop docker container if they are up
docker-compose down

#Build images and Start image instances (containers)
docker-compose up --build --force-recreate -d