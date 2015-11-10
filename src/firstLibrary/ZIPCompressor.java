package firstLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPCompressor {

	private static LocalDate date;
	private static FileOutputStream fileOutput;
	private static ZipOutputStream zipOutput;
	private static ZipEntry zipEntry;
	private static FileInputStream fileInput;
	
	public static void compressFile(String path) {
		newZip(new File(path), "C:\\myDownloader\\"+ date.now() +".zip");
	}
	
	private static void newZip(File file, String zipFileName) {
        try {
            
            fileOutput = new FileOutputStream(zipFileName);
            zipOutput = new ZipOutputStream(fileOutput);
            zipEntry = new ZipEntry(file.getName());
            zipOutput.putNextEntry(zipEntry);
            fileInput = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInput.read(buffer)) > 0) {
                zipOutput.write(buffer, 0, len);
            }
           
            zipOutput.closeEntry();
            zipOutput.close();
            fileInput.close();
            fileOutput.close();
            System.out.println(file.getCanonicalPath()+" is zipped to "+zipFileName);
             
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
