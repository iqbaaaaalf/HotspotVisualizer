package com.iqbaaaaalf.hotspotvisualizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.hotspotvisualizer.R;
import com.iqbaaaaalf.hotspotvisualizer.util.*;
import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int READ_BLOCK_SIZE = 100;
	EditText input;
	Praproses pra = new Praproses();
	RunTime time = new RunTime();
	RunSpade spade = new RunSpade();
	
	String PathInput = Environment.getExternalStorageDirectory().toString()+"/dataSkripsi/input/";
	String PathOutput= Environment.getExternalStorageDirectory().toString()+"/dataSkripsi/output/";
	String NamaFile = null;
	String SeqOutput = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		input = (EditText)findViewById(R.id.inptFile);
		NamaFile = input.getText().toString();
	}
	
	
	public void TransformBtn(View v){
		time.start();
		String InputFile = PathInput + NamaFile + ".csv";
		String OutputFile =  PathOutput + NamaFile + ".csv";
		
		try {
			pra.penyesuaianData(InputFile, OutputFile);
			Toast.makeText(getBaseContext(), "Eksekusi dalam "+time.end()+" millsec Berhasil! Data tersimpan di "+OutputFile,
                    Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(getBaseContext(), "Gagal melakukan penyesuaian data, File tidak ditemukan!",
                    Toast.LENGTH_LONG).show();
		}
	}
	
	public void SequentialBtn(View v){
		time.start();
		String InputFile = PathOutput + NamaFile + ".csv";
		String OutputFile = PathOutput + "Seq-" + NamaFile + ".txt";
		
		try {
			pra.convert2Sequential(InputFile, OutputFile);
			Toast.makeText(getBaseContext(), "Eksekusi dalam "+time.end()+" millsec Berhasil! Data tersimpan di "+OutputFile,
                    Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(getBaseContext(), "Gagal melakukan perubahan data Sequential, File tidak ditemukan!",
                    Toast.LENGTH_LONG).show();
		}
		
	}
	
	public void SpadeBtn(View v) throws IOException{
		time.start();
		String InputFile = PathOutput + "Seq-" +NamaFile + ".txt";
		String OutputFile = PathOutput + "Spade-" + NamaFile + ".txt";
		
		try {
			spade.run(InputFile, OutputFile);
			Toast.makeText(getBaseContext(), "Eksekusi dalam "+time.end()+" millsec Berhasil! Data tersimpan di "+OutputFile,
                    Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(getBaseContext(), "Gagal melakukan analisis Spade, File tidak ditemukan!",
                    Toast.LENGTH_LONG).show();
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
