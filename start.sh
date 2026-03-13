#!/bin/bash

service postgresql start

echo "Starting Spring Boot..."
cd /app/springboot-app
java -jar target/*.jar &

echo "Starting Angular..."
npm install -g serve
serve -s /app/angular-app/dist -l 4200 &

wait