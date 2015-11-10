package firstLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIPDecompressor {

	private static ZipInputStream zipInput = null;
	private static ZipEntry zipEntry;
	private static FileOutputStream fileOutput;
	
	public static void decompressFile(String zipFile, String path) throws IOException {
		
		int len;
		String destination = path;
	    byte[] buf = new byte[1024];
	    
	    zipInput = new ZipInputStream(new FileInputStream(zipFile));
	    zipEntry = zipInput.getNextEntry();
	   
	    while (zipEntry != null) {
	      String entryName = zipEntry.getName();
	      
	      File newFile = new File(entryName);
	      String directory = newFile.getParent();

	      if (directory == null) {
	        if (newFile.isDirectory())
	          break;
	      }
	      
	      fileOutput = new FileOutputStream(destination);
	      	      
	      while ((len = zipInput.read(buf, 0, 1024)) > -1){
	        fileOutput.write(buf, 0, len);
	      }
	      
	      fileOutput.close();
	      zipInput.closeEntry();
	      zipEntry = zipInput.getNextEntry();
	    }
	    
	    zipInput.close();
	}
}
