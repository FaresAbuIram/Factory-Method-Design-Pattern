package com.company;
import java.io.FileReader;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.PrintWriter;


public class ReadJsonFile implements FileParser {

public  void    ParseFile() {



    JSONParser parser = new JSONParser();
    try {
        PrintWriter pw = new PrintWriter("result.txt");
        Object obj = parser.parse(new FileReader("Test.json"));
        JSONObject jsonObj = (JSONObject) obj;
        FileWriter fw = new FileWriter("result.txt", true);
        JSONObject type = (JSONObject) jsonObj.get("note");
        fw.write("Type: Note \n------------------\n");
        String To = (String) type.get("to");
        fw.write("to : " + To+'\n');
        String From = (String) type.get("from");
        fw.write("from: " + From+'\n');
        String Heading = (String) type.get("heading");
        fw.write("heading: " + Heading+'\n');
        String Body = (String) type.get("body");
        fw.write("body: " + Body+'\n');

        fw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}