package com.ce0941a.logicat2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

//Class name and extends my activity to use methods from Activity class
public class UpLoad extends Activity {
	
	
	//This was meant for the media links
	
	public void onCreate(Bundle state) {
       	super.onCreate(state);
       	setContentView(R.layout.uploading);
       	
       	SharedPreferences prefs = getSharedPreferences("myDataStorge", MODE_PRIVATE);
       	Editor mEditor = prefs.edit();
       	mEditor.putString("UserName","Neil");
       	mEditor.putString("Password","Password");
       	mEditor.commit();
	}
}
