package com.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.util.getEnviromenmt;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */

public class TASK4 {
    static Map<String, String> env = getEnviromenmt.load();
    private static final String API_ENDPOINT = env.get("API_ENDPOINT");
    private static final String S3_BUCKET_NAME = env.get("S3_BUCKET_NAME");
    private static final String S3_FILE_NAME = env.get("S3_FILE_NAME");
    private static final String S3_ACESS_KEY = env.get("S3_ACESS_KEY");
    private static final String S3_SECRET_ACCESS_KEY = env.get("S3_SECRET_ACCESS_KEY");

    public static void main(String[] args) {
        try {
            String jsonResponse = callAPI(API_ENDPOINT);

            JSONArray jsonArray = new JSONArray(jsonResponse);

            Map<String, Integer> genderCounts = countGenders(jsonArray);

            StringBuilder resultString = new StringBuilder();
            for (Map.Entry<String, Integer> entry : genderCounts.entrySet()) {
                resultString.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            saveToS3(resultString.toString());
            System.out.println(resultString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String callAPI(String endpoint) throws Exception {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            byte[] responseBytes = inputStream.readAllBytes();
            return new String(responseBytes, StandardCharsets.UTF_8);
        } else {
            throw new Exception("Failed to call API. Response code: " + responseCode);
        }
    }

    public static Map<String, Integer> countGenders(JSONArray jsonArray) {
        Map<String, Integer> genderCounts = new HashMap<String, Integer>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String gender = jsonObject.getString("gender");
            genderCounts.put(gender, genderCounts.getOrDefault(gender, 0) + 1);
        }
        return genderCounts;
    }

    public static void saveToS3(String content) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(S3_ACESS_KEY, S3_SECRET_ACCESS_KEY);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_WEST_2)
                .build();

        InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(content.getBytes().length);
        s3Client.putObject(new PutObjectRequest(S3_BUCKET_NAME, S3_FILE_NAME, inputStream, metadata));
    }
}
