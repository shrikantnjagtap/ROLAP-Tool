package mdb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class Commons {

	
	public static void main(String[] args) {

	}

	public static boolean isValidString(Object object) {

		if (object == null) {

			return false;

		} else {

			return isValidString(object.toString());

		}

	}

	public static boolean isValidString(String string) {

		if (string != null && string.trim().length() > 0) {

			return true;

		} else {

			return false;

		}

	}

	public static boolean isValidNumber(Object object) {

		if (object == null) {
			return false;

		} else {
			return isValidNumber(object.toString());

		}

	}
	
	public static boolean isValidNumber(String string) {

		try {

			Double.parseDouble(string);
			return true;

		} catch (Exception ex) {
			// ex.printStackTrace();
		}

		return false;
	}

	public static String getFileExtension(String fileName) {

		String result = "";
		
		if(isValidString(fileName) && fileName.contains(".")) {

			result = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
		
		}
		
		return result;
	}
	
	public static void copyFile(File src, File dst) {

		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dst);

			byte[] buffer = new byte[1024];
			int length;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			is.close();
			os.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static String readFile(String filePath) {

		String result = "";
		String line = "";

		try {

			File file = new File(filePath);
			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {

				result += line;

			}

			br.close();
			fr.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return result;
	}

	public static boolean writeFile(String filePath, String content) {

		try {

			File file = new File(filePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);

			bw.close();
			fw.close();

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return false;

	}

	// Generate unique name
	public static String getUniqueName() {

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "t" + Calendar.getInstance().getTimeInMillis();
		
	}

	public static void createDirectory(String path) {

		try {

			new File(path).mkdir();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}