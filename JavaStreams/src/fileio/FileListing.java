package fileio;

import java.io.File;

public class FileListing {

	public static void main(String[] args) {
		
		String dirPath = "C:\\course\\java course\\javabyexample\\files";
		File baseDir = new File(dirPath);
		
		if (baseDir != null && baseDir.exists()) {
			File[] files = baseDir.listFiles(); // lists all the files in the directory path
			System.out.print("Directory path: " + baseDir.getAbsolutePath());
			System.out.println("\nNumber of files: " + files.length);
			File file;
			for (int i = 0 ; i < files.length; i++) {
				file = files[i];
				if (file.isDirectory()) {
					System.out.println("Directory: " + file.getName());
				} 
				else {
					System.out.println("File: " + file.getName());
				}
			}
		}
		else {
			System.out.println("Please provide real directory");
		}

	}

}
