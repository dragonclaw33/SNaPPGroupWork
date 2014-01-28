package com.ce0941a.logicat2;

import java.io.File;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;
import com.ce0941a.logicat2.model.Lines;
import com.ce0941a.logicat2.view.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditCat extends Activity {
	
	//Sets the dot, which is used to draw to the view
    public static final int LINE_DIAMETER = 2;
    private final Random rand = new Random();
    //Used to set the constructor to the method onCreateOptionsMenu
    public static final int MENU_ADD = Menu.FIRST;
    public static final int MENU_DELETE = Menu.FIRST + 1;
    //Sets the method to check for if there is any valid SD card image
    
	protected static final String  APP_PATH_SD_CARD = "/test";

    //Sets the model, to allow lines to be drawn
    final Lines lineModel = new Lines();
    
    //Sets the application view
    ImageView lineView;
    
    //Variables 
	private static ImageButton EditCatBT;
	private static ImageButton GalleryBT;
	private static ImageButton SaveBT;
	
	//Main code to allow application view EditCat to be rendered
	//Intents to allow button navigation
	public void onCreate(Bundle state) {
       	super.onCreate(state);
       	lineView = new ImageView(this, lineModel);
       	      	
       	      	
       	setContentView(R.layout.edit_cat);
       	((LinearLayout) findViewById(R.id.EditCat)).addView(lineView, 0);
       	
       	//Used to set up my button navigation
       	//Also used to set an image button
       		
	       	EditCatBT = (ImageButton)findViewById(R.id.MainMenu);
       		EditCatBT.setImageResource(R.drawable.mainmenu);
       		EditCatBT.setAdjustViewBounds(true);
       		EditCatBT.setMaxHeight(75);
       		EditCatBT.setMaxWidth(75);
       		EditCatBT.setOnClickListener(new OnClickListener(){
	       	
	       		
	  @Override
	  public void onClick(View v){
		  
	       		Intent openMainMenu = new Intent(EditCat.this, MainMenu.class);
	       		startActivity(openMainMenu);
	       			
	       		}
	       	});
       		
       		//Method in which is was trying to change colour of the dot
	       	
	  //lineView.setOnKeyListener(new OnKeyListener() {
	  //public boolean onKey(View v, int keyCode, KeyEvent event) {
		  
	                //if (KeyEvent.ACTION_UP != event.getAction()) {
	                //    return false;
	                //}

	                //int color = Color.YELLOW;
	                //switch (keyCode) {
	                   // case KeyEvent.KEYCODE_VOLUME_UP:
	                    	//color = Color.RED;
	                       // return false;
	                    //case KeyEvent.KEYCODE_VOLUME_DOWN:
	                       // color = Color.BLUE;
	                       // break;
	                    
	                   // default:
	               // }

            //makeLine(lineModel, lineView, color);
           // return true;
	       // }});
	  
	  	//Used to set up my button navigation
     	//Also used to set an image button
	
	       	GalleryBT = (ImageButton)findViewById(R.id.GalleryView);
	       	GalleryBT.setImageResource(R.drawable.galley1);
	       	GalleryBT.setAdjustViewBounds(true);
	       	GalleryBT.setMaxHeight(75);
	       	GalleryBT.setMaxWidth(75);
       		GalleryBT.setOnClickListener(new OnClickListener(){
       			
     @Override
     public void onClick(View v){
       		
	       	Intent openGallery = new Intent(EditCat.this, CatGallery.class);
	       	startActivity(openGallery);
	       			
	       		}
	       	});
       		//Sets the listener for the save button
       		//Gives it an image button
       		
       		SaveBT = (ImageButton)findViewById(R.id.Save);
       		SaveBT.setImageResource(R.drawable.save);
       		SaveBT.setAdjustViewBounds(true);
       		SaveBT.setMaxHeight(75);
       		SaveBT.setMaxWidth(75);
       		SaveBT.setOnClickListener(new OnClickListener(){
       			
     //This is to save the ImageView and its current form after
     public void onClick(View v, ImageView canvas){

     String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/sdcard0/MyImages";
       	       	
       	       	
       	       	try {
       	         File dir = new File(fullPath);
       	         if (!dir.exists()) {
       	              dir.mkdirs();
       	         }
       	      OutputStream fOut = null;
       	      File file = new File(fullPath, "cattwo.png");
       	      file.createNewFile();
       	      fOut = new FileOutputStream(file);

       	   // 100 means no compression, the lower you go, the stronger the compression
       	   ImageView.compress(Bitmap.CompressFormat.PNG, 100, fOut);
       	   fOut.flush();
       	   fOut.close();
       	   
       	   

     	       	//ImageView.compress(Bitmap.CompressFormat.PNG, 100, dir);

       	       	  Toast.makeText(getBaseContext(), "image saved",Toast.LENGTH_SHORT).show();
       	       	 }
       	       	 catch (Exception e) {
       	          	e.printStackTrace();
       	          Toast.makeText(getBaseContext(), "error",Toast.LENGTH_SHORT).show();
       	       	 }

	       		}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	       	});
	
	
    //Listener to allow for the lines to be draw to our view
	lineModel.setLinesChangeListener(new Lines.LinesChangeListener() {
       			
    public void onLinesChange(Lines lines) {
    	
    lineView.invalidate();
            
       		}});
			lineView.setOnTouchListener(new TrackingTouchListener(lineModel));
	}
	
	
		
    //Sets my menu options and its name in EditCat
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);

	    menu.add(Menu.NONE, MENU_ADD, Menu.NONE, "Add");
	    menu.add(Menu.NONE, MENU_DELETE, Menu.NONE, "Clear");
	    return true;
	}
		//This provides my application EditCat screen with a menu
		//Menu selection Delete, will clear any line that has been rendered on the view
	   @Override
	public boolean onOptionsItemSelected(MenuItem item)
	    {
	        switch(item.getItemId())
	        {
	            case MENU_ADD:

	            return true;
	            case MENU_DELETE:
	                lineModel.clearLine();
	                return true;
	                
	            default: ;
	        
	            return super.onOptionsItemSelected(item);
	        }
	    }

    //Sets my menu options in my EditCat screen
    @Override 
    public void onCreateContextMenu(
    		
        ContextMenu menu,
        View v,
        ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
    };
	
    //Allows the activity to respond to user selection
    @Override 
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
	
    //Method in which the dots are controlled and placed on screen when called
    //and insures it is within the view window
    //From the model class
    //defines also the colour parameter 
	void makeLine(Lines lines, ImageView view, int color) {
        int pad = (LINE_DIAMETER + 2) * 2;
        lines.addLine(
        	LINE_DIAMETER + (rand.nextFloat() * (view.getWidth() - pad)),
        	LINE_DIAMETER + (rand.nextFloat() * (view.getHeight() - pad)),
            color,
            LINE_DIAMETER);
	};

	//Destroys the screen so that it doesn't save

	public void onPause(){
		finish();
		System.exit(0);
}
	
}

