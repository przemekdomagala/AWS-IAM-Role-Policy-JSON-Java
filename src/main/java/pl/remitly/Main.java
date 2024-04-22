package pl.remitly;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JSONVerifier jsonVerifier = new JSONVerifier();
        ObjectMapper mapper = new ObjectMapper();
        var path = System.getProperty("user.dir");
        JsonNode node = mapper.readTree(new File(path+"\\src\\main\\resources\\data.json"));
        var str = node.toString();
        JSONObject jsonObject = new JSONObject(str);
        System.out.println(jsonVerifier.verify(jsonObject));
    }
}
