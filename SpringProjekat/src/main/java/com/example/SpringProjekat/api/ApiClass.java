package com.example.SpringProjekat.api;


import okhttp3.*;
import java.io.*;

public class ApiClass {
	
	
	public static String nadjiPrevodPrekoAPIA(String lang) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String value = "{\"from\": \"en_GB\",\"to\": \"" + lang + "\", \"data\": \"Hello World!\",\"platform\": \"api\"}";
        RequestBody body = RequestBody.create(mediaType, value);
        Request request = new Request.Builder()
                .url("https://lingvanex-translate.p.rapidapi.com/translate")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("X-RapidAPI-Key", "ec29577649mshbe75a484063146fp1204c0jsn2c06c60b01af")
                .addHeader("X-RapidAPI-Host", "lingvanex-translate.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            String[] splitted = responseBody.split(":");
            splitted = splitted[2].split("\"");
            return splitted[1];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
