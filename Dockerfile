# Use the official Nginx base image
FROM nginx:latest

# Copy the custom configuration file to Nginx's configuration directory
COPY ./nginx.conf /etc/nginx/nginx.conf
