package com.example.hwapi;

import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	
	
	
	static void crawlingProcess(ArrayList<Student> SL) {
		String url = "https://apl.hongik.ac.kr/lecture/dbms";
		Document doc = null;
		int graduation;
		String str_tmp = null;
		String name_tmp = null;
		String email_tmp = null;
		String degree_tmp = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Elements els1 = doc.select("div > div > ul:nth-child(3)").select("li");
		Elements els2 = doc.select("div > div > ul:nth-child(6)").select("li");
		Elements els3 = doc.select("div > div > ul:nth-child(10)").select("li");
		
		int count = 0;
		
		for (Element el: els1) {
			str_tmp = el.text();
			String[] strs = str_tmp.split(",");
			name_tmp = strs[0];
			if (strs[1].startsWith(" ")) {
				strs[1] = strs[1].substring(1);
			}
			email_tmp = strs[1];
			if (strs[2].startsWith(" ")) {
				strs[2] = strs[2].substring(1);
			}
			graduation = Integer.parseInt(strs[2]);
			degree_tmp = "phd";
			
			SL.add(new Student(count, name_tmp, email_tmp, degree_tmp, graduation));
			
			count++;
		}
		
		for (Element el: els2) {
			str_tmp = el.text();
			String[] strs = str_tmp.split(",");
			name_tmp = strs[0];
			if (strs[1].startsWith(" ")) {
				strs[1] = strs[1].substring(1);
			}
			email_tmp = strs[1];
			if (strs[2].startsWith(" ")) {
				strs[2] = strs[2].substring(1);
			}
			graduation = Integer.parseInt(strs[2]);
			degree_tmp = "master";
			
			SL.add(new Student(count, name_tmp, email_tmp, degree_tmp, graduation));
			
			count++;
		}
		
		for (Element el: els3) {
			str_tmp = el.text();
			String[] strs = str_tmp.split(",");
			name_tmp = strs[0];
			if (strs[1].startsWith(" ")) {
				strs[1] = strs[1].substring(1);
			}
			email_tmp = strs[1];
			if (strs[2].startsWith(" ")) {
				strs[2] = strs[2].substring(1);
			}
			graduation = Integer.parseInt(strs[2]);
			degree_tmp = "undergrad";
			
			SL.add(new Student(count, name_tmp, email_tmp, degree_tmp, graduation));
			
			count++;
		}
		
	}
}
