# Vault Installation using Helm

This guide demonstrates the installation of Vault using Helm and the setup of basic configurations for integrating with Kubernetes.

## Prerequisites

- Clone the repository from GitHub:
    ```
    git clone https://github.com/miraccan00/vault-workshop
    cd vault-workshop
    ```

## Installation

1. Install Consul and Vault using Helm:
 - Consul is used as the storage backend for Vault to ensure high availability.
 - Run the following command to install Consul:
   ```
   helm install consul hashicorp/consul --values helm-consul-values.yml
   ```
 - Run the following command to install Vault:
   ```
   helm install vault hashicorp/vault --values helm-vault-values.yml
   ```

## Verify Vault Installation

1. Check if Vault is running properly inside the container:

kubectl exec vault-0 -- vault status



2. Access the Vault UI by port-forwarding:
kubectl port-forward vault-0 8200:8200


## Initialize Vault

1. Initialize Vault with key shares and threshold (for demo purposes only):

```
kubectl exec vault-0 -- vault operator init -key-shares=1 -key-threshold=1 -format=json > cluster-keys.json
```


2. Unseal Vault using the cluster key and login with the root token:
```
kubectl exec -it vault-0 -- /bin/bash
vault login clusterkeyjson.[root_token]
```

## Secrets Management

1. Enable the Key-Value (KV) secrets engine in Vault:
```
vault secrets enable -path=secret kv-v2
```

1. Store secrets in Vault using the KV engine:
```
vault kv put secret/webapp/config username="static-user" password="static-password"
```


3. Retrieve secrets from Vault using the CLI:
```
vault kv get secret/webapp/config
```

## Kubernetes Integration

1. Enable Kubernetes service account authentication in Vault:
```
vault auth enable kubernetes
```

2. Configure Vault with Kubernetes settings:

```
vault write auth/kubernetes/config kubernetes_host="https://$KUBERNETES_PORT_443_TCP_ADDR:443"
```

1. Define a policy to control access to secrets:
```
vault policy write webapp - <<EOF
path "secret/data/webapp/config" {
capabilities = ["read"]
}
EOF
```

4. Create a role and bind it to the Kubernetes service account:
```
vault write auth/kubernetes/role/webapp
bound_service_account_names=vault
bound_service_account_namespaces=default
policies=webapp
ttl=24h
```

## Required Information

To retrieve data from Vault, you will need the following:

- `VAULT_HOST_URL`: The URL of your Vault server.
- `TOKEN`: The initial root token generated during Vault initialization.

Please ensure that you have properly configured your Vault server and Kubernetes environment. Adjust the instructions above based on your specific setup if needed.
Feel free to modify the content and instructions based on your specific project's requirements and context.