package com.ce0941a.logicat2;

import com.ce0941a.logicat2.model.Lines;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;


//Class Name and implements the on touch for the view class

final class TrackingTouchListener implements View.OnTouchListener
{
	
	//Variables used in the class
	private final Lines mLine;
	float x;
	float y;

	
	//Will allow for the view to listen for touch events on the view
	TrackingTouchListener(Lines lines){ mLine = lines; }	
	
	
	//Main Method to allow the positions of the dots to be rendered on screen
	//when the user is actually touching the screen
	public boolean onTouch(View v, MotionEvent evt) {
	
		switch(evt.getAction()){
			case MotionEvent.ACTION_DOWN:
				break;
			//Handles history events of the touch onto a single event
			//History of the x and y of the touch to draw the dot
			//Pressure and size determined by location by determining the dot size
			//will not work in emulator 
			case MotionEvent.ACTION_MOVE:
				for(int i = 0, n = evt.getHistorySize(); i < n; i++){
					addLine(	
					mLine,
						evt.getHistoricalX(i),
						evt.getHistoricalY(i),
						evt.getHistoricalPressure(i),
						evt.getHistoricalSize(i));
				}			
				break;	
		
		}
			
			return true;
		}
	
	//This will use the model constructors to add the dots to the screen
	//Give its colour
	//And size of the dot to be drawn
 	private void addLine(Lines lines, float X, float Y, float p, float s){
		lines.addLine(
				X,
				Y,
				Color.YELLOW,
				(int) ((p * s * EditCat.LINE_DIAMETER) + 2));
	}}
