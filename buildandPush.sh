#!/bin/bash

if [ "$#" -eq 0 ]; then
  echo "No arguments were provided."
  exit
fi

if [ -n "$1" ]; then
 echo "buildind, tagging and pushing $1"
 cd hti-ss-web/client
 grunt build
 cd ../..
 mvn clean install

 docker compose build
 docker image tag nist775hit/hti-ss-svap-tool nist775hit/hti-ss-svap-tool:$1
 docker image tag nist775hit/hti-ss-svap-mysql nist775hit/hti-ss-svap-mysql:$1
 docker image tag nist775hit/hti-ss-svap-tool nist775hit/hti-ss-svap-tool:latest
 docker image tag nist775hit/hti-ss-svap-mysql nist775hit/hti-ss-svap-mysql:latest


 docker push nist775hit/hti-ss-svap-tool:$1
 docker push nist775hit/hti-ss-svap-mysql:$1
 docker push nist775hit/hti-ss-svap-tool:latest
 docker push nist775hit/hti-ss-svap-mysql:latest

fi
