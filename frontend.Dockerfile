# Build a small nginx image with static website
FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY nginx.conf /etc/nginx/conf.d/default.conf
RUN cat /etc/nginx/conf.d/default.conf
COPY frontend/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]