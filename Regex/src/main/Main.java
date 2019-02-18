package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String regex = "\\d{2,4}";
		
		Pattern pattern = Pattern.compile(regex);
		String test = "123word45689 986365";
		Matcher matcher = pattern.matcher(test);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
		System.out.println(isValidIP("10.0.0.9"));			//true
		System.out.println(isValidIP("not a valid IP"));	//false
		System.out.println(isValidIP("10..0.0.9"));			//false
		System.out.println(isValidIP("192.168.0.102"));		//true
		System.out.println(isValidIP("192.168.0.102.100"));	//false
	}
	
	static boolean isValidIP(String ip) {
		String ipRegex = "(\\d{1,3}[\\.]){3}\\d{1,3}";
		Pattern pattern = Pattern.compile(ipRegex);
		Matcher matcher = pattern.matcher(ip);
		
		boolean matched = matcher.find();
		return matched && (ip.equals(matcher.group()));
	}
}
