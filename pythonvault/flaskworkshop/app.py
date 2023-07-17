from flask import Flask
import hvac

app = Flask(__name__)

@app.route('/')
def get_secret():
    # Create a Vault client
    client = hvac.Client(url='http://localhost:8200', token='hvs.HyQumksPbSrZqHBeRgh2f28h')
    
    # Check if the client is authenticated
    if not client.is_authenticated():
        return "Vault authentication failed."
    print("Vault authentication successful.")
    # Read a secret from Vault
    secret_path = 'webapp/config'
    response = client.secrets.kv.v2.read_secret_version(path=secret_path)

    # Check if the secret was read successfully
    if not response['data']:
        return "Secret not found."

    # Access the secret value
    print(response)
    data = response['data']['data']
    username = data['username']
    password = data['password']
    # Return the secret values as a response
    return f"Username: {username}\nPassword: {password}"

if __name__ == '__main__':
    app.run()
