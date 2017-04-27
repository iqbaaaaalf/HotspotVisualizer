package com.iqbaaaaalf.hotspotvisualizer.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter {
	StringBuilder sb = new StringBuilder();
	String namaFile = "test.csv";
	PrintWriter pw;
	public CSVWriter(String namaFile){
		try {
			pw = new PrintWriter(new File(namaFile));
		} catch (FileNotFoundException e) {
			System.out.println("pembuatan file bermasalah :(");
			e.printStackTrace();
		}
		label();
	}
	
	public void label(){
		sb.append("long");
		sb.append(",");
		sb.append("lat");
		sb.append(",");
		sb.append("tanggal");
		sb.append(",");
		sb.append("unixDate");
		sb.append('\n');
	}
	
	public void csvTulis(double longit, double latit, String tanggalBaru, long tanggalUnix){
			sb.append(longit);
			sb.append(",");
			sb.append(latit);
			sb.append(",");
			sb.append(tanggalBaru);
			sb.append(",");
			sb.append(tanggalUnix);
			sb.append('\n');
	}
	
	public void set() throws FileNotFoundException{
		pw.write(sb.toString());
        pw.close();
        System.out.println("File berhasil dibuat :)");
	}
	

}
