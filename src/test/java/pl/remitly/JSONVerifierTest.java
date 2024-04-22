package pl.remitly;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONVerifierTest {
    String path = System.getProperty("user.dir");
    File file = new File(path+"\\src\\test\\resources\\data.json");
    ObjectMapper mapper = new ObjectMapper();
    JSONVerifier jsonVerifier = new JSONVerifier();

    @Test
    public void testVerifier() throws IOException {
        JsonNode node = mapper.readTree(file);
        assertTrue(jsonVerifier.verify(new JSONObject(node.toString())));
    }

    @Test
    public void testVerifier1() throws IOException {
        file = new File(path+"\\src\\test\\resources\\data1.json");
        JsonNode node = mapper.readTree(file);
        assertFalse(jsonVerifier.verify(new JSONObject(node.toString())));
    }

    @Test
    public void testVerifier2() throws IOException {
        file = new File(path+"\\src\\test\\resources\\data2.json");
        JsonNode node = mapper.readTree(file);
        assertFalse(jsonVerifier.verify(new JSONObject(node.toString())));
    }

    @Test
    public void testVerifier3() throws IOException {
        file = new File(path+"\\src\\test\\resources\\data3.json");
        JsonNode node = mapper.readTree(file);
        assertFalse(jsonVerifier.verify(new JSONObject(node.toString())));
    }
}