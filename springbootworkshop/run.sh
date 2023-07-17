servicename="springk8s"
tag="1.0.0"
docker build -t $servicename .
docker image tag $servicename:$tag yourdockerhubusername/$servicename:$tag
docker push yourdockerhubusername/$servicename:$tag