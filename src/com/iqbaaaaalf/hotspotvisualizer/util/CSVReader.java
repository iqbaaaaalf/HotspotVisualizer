package com.iqbaaaaalf.hotspotvisualizer.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * kelas untuk membaca file csv dan mengambil kolom pertama
 */

public class CSVReader {
	ArrayList<List<Long>> listSeq = new ArrayList<List<Long>>();
	
	public List<String> CsvBaca(String alamatFile){
		String line = "";
		String csvSplitBy = ",";
		List<String> list = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(alamatFile))) {

            while ((line = br.readLine()) != null) {

                // menggunakan pembatas koma - comma separated value
                String[] kolom = line.split(csvSplitBy);
                // untuk mengambil kolom pertama, akses kolom[0]
                list.add(kolom[0]);
                System.out.println(kolom[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return list;
		
	}
	
	public List<String> CsvSequence(String alamatFile){
		String line = "";
		String csvSplitBy = ",";
		List<String> list = new ArrayList<String>();
		String temp = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(alamatFile))) {
			br.readLine();
            while ((line = br.readLine()) != null) {

                // menggunakan pembatas koma - comma separated value
                String[] kolom = line.split(csvSplitBy);
                // untuk mengambil kolom pertama, akses kolom[0] dan kolom kedua kolom[2]
                if(kolom[0] != null){
                	if(kolom[1] != null){
                		temp = kolom[0] + " " + kolom[1];
                	}
                }
                list.add(temp);
            }

        } catch (IOException e) {
        	System.err.println("Gagal membaca file input :(");
            e.printStackTrace();
        }
		
		
		return list;
		
	}
	
	public void csvSearch(double longit, double latit, String alamatFile){
		String line = "";
		String csvSplitBy = ",";
		List<Long> listUnix = new ArrayList<Long>();
		Double longitCsv = (double) 0;
		Double latitCsv = (double) 0;
		Long unixTimeCsv = (long) 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(alamatFile))) {
			br.readLine();
            while ((line = br.readLine()) != null) {
                // menggunakan pembatas koma - comma separated value
                String[] kolom = line.split(csvSplitBy);
                longitCsv = Double.parseDouble(kolom[0]);
                latitCsv = Double.parseDouble(kolom[1]);
                if(longitCsv.equals(longit)){
                	//System.out.println(longitCsv + " " + longit);
                	if(latitCsv.equals(latit)){
                	//	System.out.println(latitCsv);
                		unixTimeCsv = Long.parseLong(kolom[3]);
//                		System.out.println(unixTimeCsv);
                		listUnix.add(unixTimeCsv);
                	}
                }
            }
            listSeq.add(listUnix);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public ArrayList<List<Long>> ambilListSeq(){
		return this.listSeq;
	}

	
}
