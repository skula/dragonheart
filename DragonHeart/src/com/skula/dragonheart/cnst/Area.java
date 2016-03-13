package com.skula.dragonheart.cnst;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Area {
	private PictureLibrary lib;
	private int x;
	private int y;

	public Area(Resources res, int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void draws(Canvas c, int drawableId) {
		Bitmap bmp = lib.get(drawableId);
		Rect src = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
		c.drawBitmap(bmp, src, new Rect(x, y, x + bmp.getWidth(), y + bmp.getHeight()), null);
	}

	public boolean contains(int x, int y, int drawableId) {
		return getRect(drawableId).contains(x, y);
	}

	public Rect getRect(int drawableId) {
		Bitmap bmp = lib.get(drawableId);
		return new Rect(x, y, x + bmp.getWidth(), y + bmp.getHeight());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
