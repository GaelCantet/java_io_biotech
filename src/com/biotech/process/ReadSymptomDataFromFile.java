package com.biotech.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public HashMap<String, Integer> getSymptoms() throws IOException {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    if (result.containsKey(line)) {
                        int value = result.get(line) + 1;
                        result.put(line, value);
                    } else {
                        result.put(line, 1);
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                throw e;
            }
        }
        return result;
    }

}
