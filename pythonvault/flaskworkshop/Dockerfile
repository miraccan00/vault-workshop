# Use the official Python base image
FROM python:3.9-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the requirements file
COPY requirements.txt .

# Install the required packages
RUN pip install --no-cache-dir -r requirements.txt

# Copy the Flask app files to the working directory
COPY app.py .

# Expose the port on which the Flask app runs
EXPOSE 5000

# Run the Flask app
CMD ["python", "app.py"]