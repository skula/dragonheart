package com.skula.dragonheart.services;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.dragonheart.R;
import com.skula.dragonheart.cnst.PictureLibrary;
import com.skula.dragonheart.models.Point;

public class Drawer {
	private static final int SCREEN_WIDTH = 1280;
	private static final int SCREEN_HEIGHT = 736;

	private int BACKGROUND_WIDTH;
	private int BACKGROUND_HEIGHT;

	private GameEngine gEngine;
	private PictureLibrary lib;
	private Paint paint;

	private String log;

	public Drawer(Resources res, GameEngine gEngine) {
		this.paint = new Paint();
		this.lib = new PictureLibrary(res);

		this.gEngine = gEngine;

		// this.BACKGROUND_WIDTH = lib.get(R.drawable.background).getWidth();
		// this.BACKGROUND_HEIGHT = lib.get(R.drawable.background).getHeight();
	}

	public void draw(Canvas c) {
		drawBackground(c);
		drawHand(c);
		drawBoardCards(c);
		drawTouchAreas(c);
	}

	private void drawBackground(Canvas c) {
		// c.drawBitmap(lib.get(R.drawable.background), new Rect(0, 0,
		// BACKGROUND_WIDTH, BACKGROUND_HEIGHT), new Rect(0,
		// 0, SCREEN_WIDTH, SCREEN_HEIGHT), paint);
	}

	private void drawTouchAreas(Canvas c) {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);

	}

	private void drawHand(Canvas c) {

	}

	private void drawBoardCards(Canvas c) {

	}

	private void drawPic(Canvas c, int id, Point p) {
		Rect src = new Rect(0, 0, lib.get(id).getWidth(), lib.get(id).getHeight());
		Rect dest = new Rect(0 + p.getX(), 0 + p.getY(), lib.get(id).getWidth() + p.getX(), lib.get(id).getHeight()
				+ p.getY());
		c.drawBitmap(lib.get(id), src, dest, paint);
	}
}