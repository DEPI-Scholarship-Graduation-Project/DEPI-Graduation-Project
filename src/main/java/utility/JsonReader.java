package utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {

    public static Object[][] getJsonData(String filePath, String arrayName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(filePath));
            JsonNode dataArray = rootNode.get(arrayName);

            Object[][] testData = new Object[dataArray.size()][1];

            for (int i = 0; i < dataArray.size(); i++) {
                testData[i][0] = dataArray.get(i);
            }

            return testData;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}
