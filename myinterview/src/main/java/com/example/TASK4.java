package com.example;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
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
    private static final String API_ENDPOINT = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
    private static final String S3_BUCKET_NAME = "interview-digiage";
    private static final String S3_FILE_NAME = "gender_counts.txt";

    public static void main(String[] args) {
        try {
            // Faz a chamada para a API e obtém a resposta como uma string JSON
            String jsonResponse = callAPI(API_ENDPOINT);

            // Converte a resposta JSON em um JSONArray
            JSONArray jsonArray = new JSONArray(jsonResponse);

            // Conta quantos registros existem para cada gênero
            Map<String, Integer> genderCounts = countGenders(jsonArray);

            // Cria uma string com os resultados
            StringBuilder resultString = new StringBuilder();
            for (Map.Entry<String, Integer> entry : genderCounts.entrySet()) {
                resultString.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            // Salva a string de resultados em um arquivo no bucket S3
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

    private static Map<String, Integer> countGenders(JSONArray jsonArray) {
        Map<String, Integer> genderCounts = new HashMap<String, Integer>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String gender = jsonObject.getString("gender");
            genderCounts.put(gender, genderCounts.getOrDefault(gender, 0) + 1);
        }
        return genderCounts;
    }

    private static void saveToS3(String content) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAU7BHLOLBKPZTHAP2", "OLBdHAT62RJ5Odwl98JIbOWKL9LQxtOBYqNMQ9TY");
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
