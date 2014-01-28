package com.ce0941a.logicat2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//Class Name, and extends activity to override methods if need be
//allows the subclass to inherit public and protected methods
//and variables of the superclass 

public class Splash extends Activity {
	
	//Called when the activity class is first created
	//Helps pass my data to other activities
	//Sets the layout to be used (splash)
	
	public void onCreate(Bundle state) {
       	super.onCreate(state);
       	setContentView(R.layout.splash);
       	
       	// Allow my splash to run for 5 seconds
       	// catches when your thread wait for
       	// a specific amount of time 
       	// Run MainAcivity to display main menu
       	
       	
       	Thread timer = new Thread(){
       		public void run(){
       			try{
       				sleep(5000);
       			}catch (InterruptedException e){
       				e.printStackTrace();
       			}finally{
       				Intent openMainMenu = new Intent("com.ce0941a.logicat2.MAINMENU");
       				startActivity(openMainMenu);
       			}
       		}
       		
       	};
       	timer.start();
      }
	
	//Destorys the screen
	public void onPause(){
		finish();
        System.exit(0);
	}
}

