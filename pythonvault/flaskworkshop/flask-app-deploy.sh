docker build -t my-flask-app .
docker tag my-flask-app:latest miraccan/flaskvaultapp:1.0.0
docker push miraccan/flaskvaultapp:1.0.0
kubectl apply -f flask-app-deployment.yaml
kubectl apply -f flask-app-service.yaml