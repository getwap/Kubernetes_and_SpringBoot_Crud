#!/bin/bash

#Package the spring boot service
cd .. && mvn -DskipTests clean install && cd k8s

#Build spring boot image
cd .. && docker build -t <docker-hub-username>/spring-sample-app-image:1.0 . && cd k8s

#Tag the image
docker tag spring-sample-app-image <docker-hub-username>/spring-sample-app-image:1.0

#Login to dockerhub
docker login

#Push image to docker hub
docker push <docker-hub-username>/spring-sample-app-image:1.0

#Start cluster
minikube start

#Create postgres database credentials
kubectl apply -f postgres-credentials.yaml

#Create postgres database configurations
kubectl apply -f postgres-configmap.yaml

#Create postgres database
kubectl apply -f postgres-k8s-deployment.yaml

#Deploy the spring boot image to kubernetes
kubectl apply -f sample-app-k8s-deployment.yaml