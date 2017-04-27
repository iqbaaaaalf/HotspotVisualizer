package com.iqbaaaaalf.hotspotvisualizer.util;

public class FormatType {
	
	private double longitude;
	private double latitude;
	private long date;
	
	public void setValue(double longit, double latit, long tanggal){
		this.longitude = longit;
		this.latitude = latit;
		this.date = tanggal;
	}
	
	public void reset(){
		this.longitude = (double) 0;
		this.latitude = (double) 0;
		this.date = 0;
	}
	
	public FormatType() {
		this.longitude = (double) 0;
		this.latitude = (double) 0;
		this.date = 0;
	}

	public double getLong(){
		return this.longitude;
	}
	
	public double getLat(){
		return this.latitude;
	}
	public long getdate(){
		return this.date;
	}
}
