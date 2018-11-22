package com.mycervello.adb.config;

/**
 * This class provides utilities for application settings.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-06-2018
 */
public class AppSettings {
	
	//
	//Constants
	//
	private static final String DEFAULT_DB_URL = "postgres://xmrhqvsshvqjug"
		+ ":e510fd007df5f81c7d0ddc71d4c99cb8e94bfc5d65213495d26774fa7cbf1012"
		+ "@ec2-54-163-230-178.compute-1.amazonaws.com:5432/d7tas1qekm8pdq";
	
	public static final String DATABASE_URL;
	static {
		String dbUrlFromSystemVar = System.getenv("DATABASE_URL");
		DATABASE_URL = (dbUrlFromSystemVar != null ? dbUrlFromSystemVar : DEFAULT_DB_URL);
	}
	//
}