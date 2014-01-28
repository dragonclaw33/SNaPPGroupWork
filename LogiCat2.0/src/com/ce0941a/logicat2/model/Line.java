package com.ce0941a.logicat2.model;

	//coordinates
	public final class Line {
		private float x, y;
		private final int color;
		private final int diameter;

  //Variable used to defind the line 
    public Line(float x, float y, int color, int diameter) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.diameter = diameter;
    }

    //horizontal coordinate
    public float getX() { return x; }

    //vertical coordinate
    public float getY() { return y; }
    
    //horizontal coordinate
    public void setX(float newX) { this.x= newX; }

    //vertical coordinate
    public void setY(float newY) { this.y= newY; }

    //Colour
    public int getColor() { return color; }

    //Line Size
    public int getDiameter() { return diameter; }

	
	}

		


	
