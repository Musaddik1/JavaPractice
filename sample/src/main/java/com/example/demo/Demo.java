package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://restmock.techgig.com/news?author=sama&page=1")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String str = response.body();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject(str);
		Iterator<?> itr = jsonObject.keys();
		while (itr.hasNext()) {
			Object value = null;
			String key = (String) itr.next();
			if (jsonObject.get(key) instanceof String) {
				value = jsonObject.getString(key);
			} else if (jsonObject.get(key) instanceof Integer) {
				value = jsonObject.getInt(key);
				String str1 = String.valueOf(value);

			} else {
				value = jsonObject.getJSONArray(key);
			}
			map.put(key, value);

			System.out.println("Key : " + key + "| Value : " + value);
		}
		Map<String, String> map1 = new HashMap<String, String>();
		for (Map.Entry<String, Object> temp : map.entrySet()) {
			if (temp.getKey().contains("content")) {
				JSONArray jsonarr = (JSONArray) temp.getValue();
				String str23 = jsonarr.toString();
				System.out.println(str23);
				str23 = str23.replace("[", "").replace("]", "");
				System.out.println(str23);

				jsonObject = new JSONObject(str23);
				Iterator<?> itr1 = jsonObject.keys();
				String value1=null;
				while (itr1.hasNext()) {

					String key1 = (String) itr1.next();
					if(jsonObject.get(key1) instanceof Integer) {
						 int value12=jsonObject.getInt(key1);
						 value1=String.valueOf(value12);
					}else {
						 value1 = (String) jsonObject.get(key1);
					}
					
					map1.put(key1, value1);

				}

			}

		}

		for (Entry<String, String> mp : map1.entrySet()) {
			System.out.println("Key : " + mp.getKey());
			System.out.println("Value : " + mp.getValue());
		}
	}

}
