package firstLibrary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;

public class Downloader {

	private static URL web;
	private static ReadableByteChannel channel;
	private static FileOutputStream out;
	private static LocalDate date;
	public static void downloader(String path) throws IOException{
		
		web = new URL(path);
		channel = Channels.newChannel(web.openStream());
		out = new FileOutputStream("C:\\myDownloader\\"+ date.now());
		out.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
	}
	
	
}
