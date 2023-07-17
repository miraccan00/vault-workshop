package com.example.myproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableWebApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        VaultTemplate vaultTemplate = context.getBean(VaultTemplate.class);
        String secretPath = "secret/myapp/database"; // Replace with your actual secret path

        VaultResponse response = vaultTemplate.read(secretPath);
        System.out.println("Secret Path: " + secretPath);
        System.out.println("Response: " + response);

        if (response != null && response.getData() != null) {
            String username = response.getData().get("username").toString();
            String password = response.getData().get("password").toString();
            System.out.println("Database credentials: username=" + username + ", password=" + password);
        } else {
            System.out.println("Failed to retrieve database credentials.");
        }
    }
}
