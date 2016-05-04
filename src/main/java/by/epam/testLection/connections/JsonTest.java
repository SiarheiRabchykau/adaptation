package main.java.by.epam.testLection.connections;

import com.google.gson.Gson;

/**
 * Created by Siarhei_Rabchykau on 5/4/2016.
 */
public class JsonTest {

    static String file = "json";

    public static void main(String[] args) {
        Gson gson = new Gson();

        gson.toJson("");
    }
}
