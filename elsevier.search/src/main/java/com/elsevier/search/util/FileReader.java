package com.elsevier.search.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {

	public static String getQueryFromFile() {

		//File file = new File(
		//		"C:\\Dev\\search\\WS_20160516\\elsevier.search\\src\\main\\resources\\DSL_Query.json");
		InputStream input  = FileReader.class.getClassLoader().getResourceAsStream("DSL_Query.json");

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		StringBuffer buffer = new StringBuffer();
		
		try {
			//fis = new FileInputStream(input);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(input);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {

				// this statement reads the line from the file
				String line = dis.readLine();
				buffer.append(line);
				
				//System.out.println(line);
			}



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			// dispose all the resources after using them.
			try {
				if(fis != null)
					fis.close();
				if(bis != null)
					bis.close();
				if(dis != null)
					dis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}
}
