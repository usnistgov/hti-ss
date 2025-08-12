#!/bin/bash
cd hti-ss-web/client
grunt build
cd ../..
mvn clean install

docker compose build

docker image tag nist775hit/hti-ss-svap-tool nist775hit/hti-ss-svap-tool:dev
docker image tag nist775hit/hti-ss-svap-mysql nist775hit/hti-ss-svap-mysql:dev

docker push nist775hit/hti-ss-svap-mysql:dev
docker push nist775hit/hti-ss-svap-tool:dev
