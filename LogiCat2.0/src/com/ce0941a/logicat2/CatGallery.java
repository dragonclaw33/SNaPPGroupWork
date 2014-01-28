package com.ce0941a.logicat2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;


//Class Name, extends activity methods 
public class CatGallery extends Activity {
	
	
	//Static variable for my imagebutton 
	private static ImageButton main;
	//Variables used in the activity
	GridView gridview;
	ImageView imageview;
	
		//Class Name, and extends activity to override methods if need be
		//allows the subclass to inherit public and protected methods
		//and variables of the superclass 
		@Override
		public void onCreate(Bundle state) {
			super.onCreate(state);
			setContentView(R.layout.cat_gallery);
			gridview=(GridView)findViewById(R.id.CatGallery);
			//imageview=(ImageView)findViewById(R.id.CatGallery);
			gridview.setAdapter(new ImageAdapter(this));
		
		//Used to set up my button navigation
		//Also used to set an image button
		main = (ImageButton)findViewById(R.id.Home);
		main.setImageResource(R.drawable.mainmenu);
		main.setAdjustViewBounds(true);
		main.setMaxHeight(150);
		main.setMaxWidth(200);
		main.setOnClickListener(new OnClickListener(){
		
			
	//Used to make my button do something from the onClicklistener
    //Will move from Cat Gallery back to Main menu screen
			
	@Override
    public void onClick(View v){
       			
       	Intent openMainMenu = new Intent(CatGallery.this, MainMenu.class);
       	startActivity(openMainMenu);
       	}
    });
}		
		
		//Destroys Screen once activity losses foreground
		public void onPause(){
			finish();
	        System.exit(0);
		}	
}	

