package com.ce0941a.logicat2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

//Class Name, and extends activity to override methods if need be
//allows the subclass to inherit public and protected methods
//and variables of the superclass 
public class GalleryScreen extends Activity{
	
	//This is the screen which displays the clicked images from gallery
	//and places them in this class activity screen, to set it larger screen
	//Calls my methods from the superclass (activity) 
	//Renders the myimage screen once called
	@Override
	protected void onCreate(Bundle savedInstance){
	super.onCreate(savedInstance);
	setContentView(R.layout.myimage);  
	
	//pull the data the image from imageadapter to this activity
   	Bundle bundle=getIntent().getExtras();   	    	
   	//imageView.setResource(imageId);
   	//Pass the image from gallery (Bundle) to the gallery screen
   	String imageId=bundle.getString("myImageId");
   	
   	Uri uri=Uri.parse(imageId);
   	//Sets the image on screen to be displayed
   	ImageView imageView=(ImageView)findViewById(R.id.myimage);
   	//int imageId=bundle.getInt("myImageId");
   	//Sets the image to screen from the SD card
   	imageView.setImageURI(uri);
	}
   	
   	
	//Destorys my screen once losses foreground
	public void onPause(){
		finish();
        System.exit(0);
	}
}
