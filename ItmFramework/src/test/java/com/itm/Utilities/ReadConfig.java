package com.itm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String Url = pro.getProperty("baseUrl");
		return Url;
	}

	public String getusername() {
		String Username = pro.getProperty("username");
		return Username;
	}

	public String getpassword() {
		String Password = pro.getProperty("password");
		return Password;
	}


}
