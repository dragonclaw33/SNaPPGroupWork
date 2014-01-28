package com.ce0941a.logicat2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

//Class Name, and extends activity to override methods if need be
//allows the subclass to inherit public and protected methods
//and variables of the superclass 
public class MainMenu extends Activity{
	

	//static Variables used in the class
	private static ImageButton EditCatBT;
	private static ImageButton GalleryCat;
	private static ImageButton UploadCat;
	private static ImageButton ExitBT;

	
	//Called when the activity class is first created
	//Helps pass my data to other activities
	//Sets the layout to be used
	@Override
	public void onCreate(Bundle state) {
	       	super.onCreate(state);
	       	setContentView(R.layout.activity_main);
	       	
	       	//Used to set up my button navigation
	       	//Also used to set an image button
	       	EditCatBT = (ImageButton)findViewById(R.id.EditCat);
       		EditCatBT.setImageResource(R.drawable.editcat);
       		EditCatBT.setAdjustViewBounds(true);
       		EditCatBT.setMaxHeight(75);
       		EditCatBT.setMaxWidth(150);
       		EditCatBT.setOnClickListener(new OnClickListener(){
	       	
	       	
       		//Used to make my button do something from the onClicklistener
       		//Will move from Main menu to Edit cat screen
       			
	       	@Override
	       	public void onClick(View v){
	       			
	       		Intent openEditCat = new Intent(MainMenu.this, EditCat.class);
	       		startActivity(openEditCat);
	       	}
	       	});
	       	
       		//Used to set up my button navigation
	       	//Also used to set an image button
       		
	       	GalleryCat = (ImageButton)findViewById(R.id.Gallery);
	       	GalleryCat.setImageResource(R.drawable.galley1);
	       	GalleryCat.setAdjustViewBounds(true);
	       	GalleryCat.setMaxHeight(75);
	       	GalleryCat.setMaxWidth(20);
	       	GalleryCat.setOnClickListener(new OnClickListener(){
	       		
	       		
	       		//Used to make my button do something from the onClicklistener
	       		//Will move from Main menu to Gallery cat screen
	       		
	       	public void onClick(View v){
	       			
	       		Intent openGalleryCat = new Intent(MainMenu.this, CatGallery.class);
	       		startActivity(openGalleryCat);
	       	}
	       	});  
	       	
	       	//Used to set up my button navigation
	       	//Also used to set an image button
	       	
	       	UploadCat = (ImageButton)findViewById(R.id.Upload);
	       	UploadCat.setImageResource(R.drawable.upload);
	       	UploadCat.setAdjustViewBounds(true);
	       	UploadCat.setMaxHeight(60);
	       	UploadCat.setMaxWidth(40);
	       	UploadCat.setOnClickListener(new OnClickListener(){
	       	
	       	
	       	//Used to make my button do something from the onClicklistener
	       	//Will move from Main menu to Gallery cat screen
	       		
	       	@Override
	       	public void onClick(View v){
	       			
	       		Intent openEditCat = new Intent(MainMenu.this, UpLoad.class);
	       		startActivity(openEditCat);
	       	}
	       	});
 		
	       	//Used to set up my button navigation
	       	//Also used to set an image button
	       	
	       	ExitBT = (ImageButton)findViewById(R.id.Exit);
	       	ExitBT.setImageResource(R.drawable.exitimage);
	       	ExitBT.setAdjustViewBounds(true);
	       	ExitBT.setMaxHeight(250);
	       	ExitBT.setMaxWidth(150);
	       	ExitBT.setOnClickListener(new OnClickListener(){
	       	
	       	//Destroys the screen so that it doesn't save
	       	@Override
	       	public void onClick(View v){
	       			
	       		finish();
	            System.exit(0);
	       		}
	       	});
	}
}	
		
		