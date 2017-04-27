package com.iqbaaaaalf.hotspotvisualizer.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TxtWriter {
	StringBuilder sb = new StringBuilder();
	String namaFile = "DataSeq.txt";
	PrintWriter pw;
	public void buatFIle(String namaFile){
		try {
			pw = new PrintWriter(new File(namaFile));
		} catch (FileNotFoundException e) {
			System.out.println("pembuatan awal file bermasalah :(");
			e.printStackTrace();
		}
	}
	
	public void txtTulis(Long unixTime){
		sb.append(unixTime+" -1 ");
	}
	
	public void setOneSeq(){
		sb.append(-2);
		sb.append('\n');
	}
	
	public void set() throws FileNotFoundException{
		String text = sb.toString();
		text = text.trim();
		pw.write(text);
        pw.close();
        System.out.println("File seq berhasil dibuat :)");
	}
	
	public void tulisConsole(String namaFile) throws FileNotFoundException{
		PrintStream out = new PrintStream(new FileOutputStream(namaFile));
		System.setOut(out);
	}
}
