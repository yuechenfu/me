package com.admin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties read(String fileName) throws IOException {
		Properties properties = new Properties();
		try (InputStream inputStream = PropertiesUtil.class.getResourceAsStream(fileName)) {
			properties.load(inputStream);
		} catch (IOException e) {
			throw e;
		}
		return properties;
	}
	
	public static void save(String fileName, Properties properties, String comment) throws URISyntaxException, IOException {
		URL url = PropertiesUtil.class.getResource(fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(new File(url.toURI()));
		properties.store(fileOutputStream, comment);
	}
}
