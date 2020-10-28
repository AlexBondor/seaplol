#Prepare backend for deployment
cd backend
mvn package
cd ..
docker container rm -f backend
docker image rm -f backend
docker build -f backend.Dockerfile -t backend .

#Prepare frontend for deployment
cd frontend
yarn install
yarn run serve
cd ..
docker container rm -f frontend
docker image rm -f frontend
docker build -f frontend.Dockerfile -t frontend .

docker-compose up