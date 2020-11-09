#Prepare backend for deployment
Prepare backend for deployment
docker container rm -f backend
docker image rm -f backend
docker build -f backend.Dockerfile -t backend .

#Prepare frontend for deployment
docker container rm -f frontend
docker image rm -f frontend
docker build -f frontend.Dockerfile -t frontend .

docker-compose up
