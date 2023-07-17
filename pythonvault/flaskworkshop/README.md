# Vault and Flask POC

This project is a proof-of-concept (POC) implementation of integrating HashiCorp Vault with a Flask application.

## Table of Contents

- [Vault and Flask POC](#vault-and-flask-poc)
  - [Table of Contents](#table-of-contents)
  - [Project Description](#project-description)
  - [Features](#features)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Configuration](#configuration)
  - [Contributing](#contributing)
  - [Contact](#contact)

## Project Description

This project demonstrates how to securely store sensitive information, such as database credentials, in HashiCorp Vault and retrieve them in a Flask application. It showcases the integration between Vault and Flask to enhance the security of secrets management.

## Features

- Securely store secrets in HashiCorp Vault
- Retrieve secrets from Vault in a Flask application
- Demonstrate the use of Vault client libraries

## Prerequisites

Before running this project, ensure you have the following installed:

- Python 3.x
- Flask
- hvac (HashiCorp Vault API client for Python)
- HashiCorp Vault server (running locally or on a remote server)

## Installation

1. Clone the repository:
```
$ git clone this repo

$ cd flaskworkshop
```
1. Install the required dependencies:

```
$ pip install -r requirements.txt
```
3. Start the Flask application:
```
$ python app.py
```


## Usage

1. Ensure your HashiCorp Vault server is running and accessible.

2. Access the Flask application:
- Open a web browser and go to `http://localhost:5000`.
- The application will retrieve the secrets from Vault and display them.

3. Experiment and customize the project as needed, exploring different aspects of Vault integration with Flask.

## Configuration

1. Set up HashiCorp Vault:
- Install and configure HashiCorp Vault following the official documentation.

2. Configure Vault connection in the Flask application:
- Open `app.py` and update the Vault URL and token to match your Vault server.

3. Store secrets in Vault:
- Use the Vault CLI or API to store secrets in Vault under the appropriate path.

## Contributing

Contributions are welcome! If you find any issues or want to enhance the project, feel free to submit a pull request.

## Contact

For any questions or support, please contact [miraccanyilmazme@gmail.com](mailto:miraccanyilmazme@gmail.com).
