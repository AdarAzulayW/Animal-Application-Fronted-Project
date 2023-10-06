package com.example.ourfinalapp.DataService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AnimalData {

    public static void main(String[] args) throws Exception {
        // Create a URL object

        URL url = new URL("https://api.api-ninjas.com/v1/animals?name=");

        // Create an HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");

        // Get the input stream
        InputStream inputStream = connection.getInputStream();

        // Create an object mapper
        ObjectMapper mapper = new ObjectMapper();

        // Read the JSON data
        JsonNode root = mapper.readTree(inputStream);

        // Print the fact
        System.out.println(root.path("fact").asText());
    }
}