package com.example.RandomJokes.controller;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ZippopotamAPI {
    public static void main(String[] args) {
        try {
            // URL of the API endpoint
            String apiUrl = "https://api.zippopotam.us/us/33162";

            // Create URL object
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the HTTP method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject masterData = new JSONObject(response.toString());

            // Print the response
            System.out.println("Response: " + response.toString());

            // Handle the response data as needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
