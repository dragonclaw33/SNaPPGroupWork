package com.ce0941a.logicat2.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



/** A list of dots. */
public class Lines {
    //this defines that any listener that listens for changes on our list of dots has a onDotsChangeMethod
    public interface LinesChangeListener {
        /** @param dots the dots that changed. */
        void onLinesChange(Lines lines);
    }
    
    //the lists that hold our list of dots.
    private final LinkedList<Line> lines = new LinkedList<Line>();
    private final List<Line> safeLines = Collections.unmodifiableList(lines);
    
    //defines a changelistener, this is set later on
    private LinesChangeListener linesChangeListener;
    
   //method to allow another class to define where change events are sent to
    public void setLinesChangeListener(LinesChangeListener l) {
        linesChangeListener = l;
    }

    //return the most recently added dot
    public Line getLastLine() {
        return (lines.size() <= 0) ? null : lines.getLast();
    }
    
    //returns a list of dots that can no longer be changed (safe dots)
    public List<Line> getLines() { return safeLines; }
    
    //adds a new dot
    public void addLine(float x, float y, int color, int diameter) {
        lines.add(new Line(x, y, color, diameter));
        notifyListener();
    }

    //Clear my dots//
    public void clearLine() {
        lines.clear();
        notifyListener();
    }
   
  
    //Allows the listener to be told that a change has occurred
    private void notifyListener() {
        if (null != linesChangeListener) {
            linesChangeListener.onLinesChange(this); 
        }
    }

	
		
	}
