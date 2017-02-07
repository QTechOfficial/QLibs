package com.qtech.first.qLibs.math;

public class Vector {
	private double x, y;
	private double theta;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector v) {
		this.x = v.x;
		this.y = v.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
//			if(x*y > 0)
//				return Math.sqrt(x * x + y * y);
//			else
//				return -1 *Math.sqrt(x * x + y * y);
		return Math.sqrt(x*x + y*y);
	}

	public double getAngleDeg() {
		if(x != 0 || y != 0) {
			if (Math.abs(x) > Math.abs(y)) {
				if(x > 0)
					theta = (Math.toDegrees(Math.atan(y / x)) + 90)%360;
				else
					theta = (Math.toDegrees(Math.atan(y / x)) + 270)%360;
			} else {
				if(y > 0)
					theta = (Math.toDegrees(-Math.atan(x / y)) + 180)%360;
				else
					theta = (Math.toDegrees(-Math.atan(x / y)) + 360)%360;
			}
			return theta;
		}else{
			return theta;
		}
	}
	
	public void addAngle(double angle){
		double tempAngle = getAngleDeg() + angle;
		tempAngle  %= 360;
		if(tempAngle < 0)
			tempAngle += 360;
		double mag = getMagnitude();
		x = Math.sin(tempAngle*Math.PI/180)*mag;
		y = Math.cos(tempAngle*Math.PI/180)*mag;
	}

	public static Vector add(Vector a, Vector b) {
		return new Vector(a.x - b.x, a.y - b.y);
	}

	public static Vector sub(Vector a, Vector b) {
		return new Vector(a.x - b.x, b.y - a.y);
	}
	
	public static Vector multByScalar(Vector vector, double scalar) {
		return new Vector(vector.x * scalar, vector.y * scalar);
	}
	
	public static Vector divByScalar(Vector vector, double scalar) {
		if(scalar != 0)
			return new Vector(vector.x / scalar, vector.y / scalar);
		else
			return null;
	}
	
	public static Vector cross2D(double z, Vector v) {
		double x = -z * v.y;
		double y = z * v.x;
		return new Vector(x, y);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+": ("+Math.floor(x)+", "+Math.floor(y)+") = "+Math.floor(getAngleDeg());
	}
}