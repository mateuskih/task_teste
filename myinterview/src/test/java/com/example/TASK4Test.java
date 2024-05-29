package com.example;

import com.amazonaws.services.s3.AmazonS3;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashMap;
import java.util.Map;
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
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(new JSONObject().put("gender", "male"));
        jsonArray.put(new JSONObject().put("gender", "female"));
        jsonArray.put(new JSONObject().put("gender", "male"));

        Map<String, Integer> genderCounts = TASK4.countGenders(jsonArray);

        assertThat(genderCounts).containsOnly(
                entry("male", 2),
                entry("female", 1)
        );
    }

    private static Map.Entry<String, Integer> entry(String key, int value) {
        return new HashMap.SimpleEntry<String, Integer>(key, value);
    }
}
