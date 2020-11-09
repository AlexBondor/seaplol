# Specify a base image
FROM node:alpine AS build
WORKDIR /app
# Install some depenendencies
COPY frontend/package.json .
RUN yarn install
COPY frontend/ .
RUN yarn build

# Build a small nginx image with static website
FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY nginx.conf /etc/nginx/conf.d/default.conf
RUN cat /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
