package com.ce0941a.logicat2;

import java.io.File;
import java.io.FilenameFilter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends BaseAdapter {
	
	//Class in which allows for images from SD card to be displayed on a screen
	
	//Variables
	private Context mContext;
	
	
	public ImageAdapter(Context context) {
		this.mContext=context;
	}
	@Override
	public int getCount() {
		/*return mThumbsId.length;*/
		return getImages().length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//This will set up the imageview in the gallery, with the
	//Defined space between the images
	//Sets a listener, to watch for clicks on the image and sets to the gallery screen
	@Override
	public View getView(final int position, View convertview, ViewGroup arg2) {
		ImageView imageView;
		if(convertview==null){
			imageView = new ImageView(mContext);
			imageView.setPadding(8, 8, 8, 8);
			imageView.setLayoutParams(new GridView.LayoutParams(125,125));
			imageView.setOnClickListener(new OnClickListener(){
			
				//This will take the images and place it in the galleryscreen
				@Override
				public void onClick(View arg0){
					Toast.makeText(mContext, "position["+position+"]", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(mContext, GalleryScreen.class);	
					//intent.putExtra("myImageId", mThumbsId[position]);
					intent.putExtra("myImageId", mFiles[position]);
					mContext.startActivity(intent);
				}
			});	
			
		}else{
			imageView=(ImageView)convertview;
			
		}
		/*imageView.setImageResource(mThumbsId[position]);*/
		imageView.setImageURI(getImages()[position]);
		return imageView;
	}
	
	//Resources from the res folder drawable
	
	//private Integer[] mThumbsId={
			//R.drawable.catone,
			//R.drawable.cattwo,
			//R.drawable.catthree,
			//R.drawable.catfour,
			//R.drawable.androidpiss,
			//R.drawable.background,
			//R.drawable.ic_launcher
		
	//};
	
	
	//This is where the images are loaded from, the SD card, and back into the gallery view
	//will collect Uri that have images from SD card, from external Storage
	//File Name Filter will check for jpg's and png's files
	
	Uri[] mUrls;
	public String[] mFiles=null;
	public Uri[] getImages(){
		
		File images = Environment.getExternalStorageDirectory();
		
		File[] imagelist=images.listFiles(new FilenameFilter(){
			
			@Override
			public boolean accept(File dir, String name){
				
				return((name.endsWith(".jpg")||(name.endsWith(".png"))));
			}
			
		});
		
		//Sets up the files to be loaded from SD card to the application
		//mFiles will collect the path from imagelist
		mFiles= new String[imagelist.length];
		for(int i=0; i<imagelist.length; i++){
			mFiles[i]=imagelist[i].getAbsolutePath();
		}
		//mFiles sets itself into the mUri which will return the getImages
		mUrls=new Uri[mFiles.length];
		for(int i=0; i<mFiles.length; i++){
			mUrls[i]=Uri.parse(mFiles[i]);
	}
		return mUrls;
	}
}
