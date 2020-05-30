#!/bin/sh

########################################################################
# title:          Build Complete Project
# author:         varadharajan
# url:            https://github.com/varadharajaan
# description:    Build complete Java microservice project
# usage:          sh ./build_project.sh
########################################################################

set -ex


# mount a named volume on host to store mongo and elk data
# ** assumes your project folder is 'todo' **
docker volume create --name todo_data
docker volume create --name todo_elk

# create bridge network for project
# ** assumes your project folder is 'todo' **
docker network create -d bridge todo_net

# build images and orchestrate start-up of containers (in this order)
# -p = --project-name
docker-compose -p todo up 

