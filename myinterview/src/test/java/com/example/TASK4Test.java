package com.example;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


public class TASK4Test {

    @Mock
    private AmazonS3 amazonS3;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCountGenders() {
        // Creating a JSON array with gender data
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(new JSONObject().put("gender", "male"));
        jsonArray.put(new JSONObject().put("gender", "female"));
        jsonArray.put(new JSONObject().put("gender", "male"));

        // Calling the method under test
        Map<String, Integer> genderCounts = TASK4.countGenders(jsonArray);

        // Verifying that the gender counts are as expected
        assertThat(genderCounts).containsOnly(
                entry("male", 2),
                entry("female", 1)
        );
    }

    // Helper method to simplify assertions
    private static Map.Entry<String, Integer> entry(String key, int value) {
        return new HashMap.SimpleEntry<String, Integer>(key, value);
    }
}
