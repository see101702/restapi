package com.example.hwapi;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HwapiApplication {
	
	
	public static void main(String[] args) {
		
		ArrayList<Student> SL = new ArrayList<Student>();
		
		Crawling.crawlingProcess(SL);
		DbDao.UploadToDB(SL);
		
		
		SpringApplication.run(HwapiApplication.class, args);
	}

}