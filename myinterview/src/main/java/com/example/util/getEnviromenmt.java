package com.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class getEnviromenmt {
    public static Map<String, String> load() {
        Map<String, String> env = new HashMap<String, String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".env"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String chave = parts[0];
                    String valor = parts[1];
                    env.put(chave, valor);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return env;
    }
}
