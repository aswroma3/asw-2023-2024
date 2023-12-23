#!/bin/bash

gradle build
docker compose build
docker compose up -d