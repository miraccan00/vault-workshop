# SpringBoot Workshop

## Project Overview
This project demonstrates the implementation of Vault for Spring applications. It showcases how to retrieve data from a Vault server in a Spring Boot application.

## Getting Started

### Prerequisites
- Install Vault on your Kubernetes cluster.
- Seal Vault.
- Java and Maven installed on your machine.
- Docker Hub account.

### Building and Deploying the Java Application

1. Build your Java project:
   - Make sure you have Java and Maven installed.
   - Navigate to the project directory and run the following command:
     ```
     $ mvn clean package
     ```

2. Push the Java project to Docker Hub:
   - Set up an account on Docker Hub if you don't have one.
   - Build a Docker image of your Java project:
     ```
     $ docker build -t your-dockerhub-username/springbootapp .
     ```
   - Push the Docker image to Docker Hub:
     ```
     $ docker push your-dockerhub-username/springbootapp
     ```

3. Update the deployment configuration:
   - Open the `helmchart/springbootapp/deployment.yaml` file.
   - Replace `<your-dockerhub-username>` with your actual Docker Hub username in the `image` field.

4. Install your Java application on your Kubernetes cluster:
   - Use Helm to deploy your Java application:
     ```
     $ helm install springbootapp springbootworkshop/helmchart/
     ```

5. Access the application:
   - Open a web browser and go to `http://localhost:8080/hello`.
   - You should see the secret value retrieved from the Vault server.

6. Set up the Vault secret:
   - Store the database credentials in the Vault server:
     ```
     $ vault kv put secret/myapp/database username=your-username password=your-password
     ```
     Replace `your-username` and `your-password` with the actual credentials you want to store.

7. Verify the secret retrieval:
   - Refresh the web browser page (`http://localhost:8080/hello`).
   - The application should display the updated secret value retrieved from the Vault server.

Please ensure that you have Vault properly installed and configured on your Kubernetes cluster, and adjust the instructions above based on your specific setup if needed.

Enjoy the Spring Boot Workshop with Vault!
