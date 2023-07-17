package com.example.myproject2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

@RestController
@RequestMapping("/")
public class HelloController {

    private final VaultTemplate vaultTemplate;
    private final String secretPath;

    public HelloController(VaultTemplate vaultTemplate, @Value("${secret.path}") String secretPath) {
        this.vaultTemplate = vaultTemplate;
        this.secretPath = secretPath;
    }

    @GetMapping("/hello")
    public String hello() {
        VaultResponse response = vaultTemplate.read(secretPath);
        System.out.println("secretPath: " + secretPath);
        System.out.println("Response: " + response);

        if (response != null && response.getData() != null) {
            String username = response.getData().get("username").toString();
            String password = response.getData().get("password").toString();
            // Use the retrieved username and password in your application logic
            return "Database credentials: username=" + username + ", password=" + password;
        } else {
            return "Failed to retrieve database credentials.";
        }
    }
}
