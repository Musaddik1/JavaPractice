package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Stack {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpClient client=HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api-football-v1.p.rapidapi.com/v2/predictions/157462"))
				.header("x-rapidapi-key", "e25a26fb6bmsh377a821e43496bep1a0255jsn88ee9371582f").header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		
		HttpResponse response=client.send(request, HttpResponse.BodyHandlers.ofString());
		if(response.statusCode()==200) {
			
			System.out.println("Successfull....");
		}else {
			System.out.print("unsuccessfull.....");
		}
	}
	

}
