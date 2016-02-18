package com.skula.dragonheart.activities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.skula.dragonheart.cnst.TouchAreas;
import com.skula.dragonheart.services.Drawer;
import com.skula.dragonheart.services.GameEngine;

public class BoardView extends View {
	private Paint paint;
	private Resources res;
	private Drawer drawer;
	private int x0;
	private int y0;

	private GameEngine gEngine;

	public BoardView(Context context, GameEngine gEngine) {
		super(context);
		this.gEngine = gEngine;
		this.res = context.getResources();
		this.drawer = new Drawer(res, gEngine);
		this.paint = new Paint();
		this.x0 = 0;
		this.y0 = 0;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x0 = x;
			y0 = y;
			break;
		case MotionEvent.ACTION_MOVE:
			x0 = x;
			y0 = y;
			break;
		case MotionEvent.ACTION_UP:
			x0 = 0;
			y0 = 0;
			break;
		}
		//invalidate();
		return true;
	}

	private int getArea(int x, int y) {
		switch (gEngine.getMode()) {
		case GameEngine.MODE_PLAY:
			if (TouchAreas.CARD_1.contains(x, y)) {
				return TouchAreas.CARD_1_ID;
			}
			if (TouchAreas.CARD_2.contains(x, y)) {
				return TouchAreas.CARD_2_ID;
			}
			if (TouchAreas.CARD_3.contains(x, y)) {
				return TouchAreas.CARD_3_ID;
			}
			if (TouchAreas.CARD_4.contains(x, y)) {
				return TouchAreas.CARD_4_ID;
			}
			if (TouchAreas.CARD_5.contains(x, y)) {
				return TouchAreas.CARD_5_ID;
			}
			if (TouchAreas.BOARD.contains(x, y)) {
				return TouchAreas.BOARD_ID;
			}
			return TouchAreas.NONE;
		case GameEngine.MODE_CHOOSE_PRINCESS:
			if (TouchAreas.TREASURE.contains(x, y)) {
				return TouchAreas.TREASURE_ID;
			}
			if (TouchAreas.DRAGON_STONE.contains(x, y)) {
				return TouchAreas.DRAGON_STONE_ID;
			}
			return TouchAreas.NONE;
		case GameEngine.MODE_CHOOSE_KNIGHT:
			if (TouchAreas.PRINCESS.contains(x, y)) {
				return TouchAreas.PRINCESS_ID;
			}
			if (TouchAreas.TROLL.contains(x, y)) {
				return TouchAreas.TROLL_ID;
			}
			return TouchAreas.NONE;
		}
		return TouchAreas.NONE;
	}

	@Override
	public void draw(Canvas canvas) {
		drawer.draw(canvas);
	}
}
