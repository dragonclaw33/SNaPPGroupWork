package com.ce0941a.logicat2.view;


import java.io.File;
import java.io.OutputStream;
import com.ce0941a.logicat2.model.Line;
import com.ce0941a.logicat2.model.Lines;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;


//Class ImageView


public class ImageView extends View {
	
	//Variables to be used in the class
    private final Lines lines;
    Bitmap ImageDraw;
    private final Bitmap mBitmapFromSdcard;
    
    //ImageView background images to be used
    //Allow for the line to be draw in the view
    
    public ImageView(Context context, Lines lines) {
        super(context);
        mBitmapFromSdcard = BitmapFactory.decodeFile("/storage/sdcard0/cat_two.png");
        this.lines = lines;
        setMinimumWidth(360);
        setMinimumHeight(250);
        setFocusable(true);       
        
    }
    
    //Set view dimension
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
            getSuggestedMinimumWidth(),
            getSuggestedMinimumHeight());
    }
    
    //canvas on which to draw on
    //Colour
    //Checks to see if there is an image, or sets it to null
	@Override 
    protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.RED);
		Canvas g = canvas;
		
		if (mBitmapFromSdcard != null) {
           g.drawBitmap(mBitmapFromSdcard, 0, 0, null);
		
		
		
		//ImageDraw = Bitmap.createScaledBitmap(ImageDraw,100, 100, true);
		//canvas.drawBitmap(ImageDraw, 0, 0, null);	
		
		
        Paint paint = new Paint();
        paint.setTextSize(25);
 
        //Sets the text to canvas
        //Creates the text to an arch, by the  x, y and size
        Path path = new Path();
        path.addArc(new RectF(75, 65, 180, 150), 200, 150);
        paint.setColor(Color.WHITE);
        canvas.drawTextOnPath("Draw Here!", path, 0, 0, paint);
        
        //this sets the colour of the border around the view depending if its in focus or not
        paint.setStyle(Style.STROKE);
        if(hasFocus()){
        	paint.setColor(Color.BLACK);
        }
        else{
        	paint.setColor(Color.YELLOW);
        }        
        
        //this bit draws all the dots on our model to the screen.
        //Calls the methods from the model class
        paint.setStyle(Style.FILL);
        for (Line line : lines.getLines()) {
            paint.setColor(line.getColor());
            canvas.drawCircle(
                line.getX(),
                line.getY(),
                line.getDiameter(),
                paint);
        }}
	}
	

	public static void compress(CompressFormat png, int i, OutputStream fOut) {
		// TODO Auto-generated method stub
		
	}
}

		



