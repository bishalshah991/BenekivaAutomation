package Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadJsonData {
    String n;
    String j;
    String k;

    public String ReadJSONData(String keyword) throws IOException, org.json.simple.parser.ParseException {

        Reader reader = new FileReader("Unity_Test_Data/Data.json");
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            j = (String) jo.get(keyword);
        }
        return j;
    }

    public String Read_JSON_Data(String keyword) throws IOException, ParseException {
        Reader reader = new FileReader("UnityJson_File/Environment.json");
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            k = (String) jo.get(keyword);
        }
        return k;
    }
}
