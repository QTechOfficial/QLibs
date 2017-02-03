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

		public Vector add(Vector vector) {
			x += vector.getX();
			y += vector.getY();
			return new Vector(x, y);
		}
	}