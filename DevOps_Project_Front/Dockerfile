# Use an official Nginx runtime as a parent image
FROM nginx:latest

# Copy the build files from your local machine into the image
COPY dist/summer-workshop-angular /usr/share/nginx/html

# Expose the port the app runs on
EXPOSE 80

# Command to run the application
CMD ["nginx", "-g", "daemon off;"]