package com.skula.dragonheart.services;

import java.util.List;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.dragonheart.R;
import com.skula.dragonheart.cnst.DrawAreas;
import com.skula.dragonheart.cnst.PictureLibrary;
import com.skula.dragonheart.cnst.TouchAreas;
import com.skula.dragonheart.enums.CardType;
import com.skula.dragonheart.models.Card;
import com.skula.dragonheart.models.Player;
import com.skula.dragonheart.models.Point;

public class Drawer {	
	private static final int CARD_DX = 10;
	private static final int CARD_DY = 10;

	private GameEngine gEngine;
	
	private PictureLibrary lib;
	private Paint paint;

	private String log;

	public Drawer(Resources res, GameEngine gEngine) {
		this.paint = new Paint();
		this.lib = new PictureLibrary(res);
		this.gEngine = gEngine;
	}

	public void draw(Canvas c) {
		drawBoard(c);
		drawPict(c, R.drawable.dwarf_4, DrawAreas.DRAGON_FIRE);
		//drawHand(c);
		//drawCardsSel(c);
		//drawTouchAreas(c);
	}

	private void drawBoard(Canvas c) {
		drawPict(c, R.drawable.board, new Point(0,0));
		
		/*Map<CardType, List<Card>> board = gEngine.getBoard();
		Point p = null;
		for(CardType ct : board.keySet()){
			p = DrawAreas.get(ct);
			for(int i =0; i<board.get(ct).size(); i++){
				drawPict(c, board.get(ct).get(i).getDrawableId(), p.clone(i*CARD_DX, i*CARD_DY));
			}
		}*/
	}

	private void drawTouchAreas(Canvas c) {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		
		c.drawRect(TouchAreas.CARD_1, paint);
		c.drawRect(TouchAreas.CARD_2, paint);
		c.drawRect(TouchAreas.CARD_3, paint);
		c.drawRect(TouchAreas.CARD_4, paint);
		c.drawRect(TouchAreas.CARD_5, paint);
		
		c.drawRect(TouchAreas.BOARD, paint);
		c.drawRect(TouchAreas.DRAGON_STONE, paint);
		c.drawRect(TouchAreas.TREASURE, paint);
		c.drawRect(TouchAreas.PRINCESS, paint);
		c.drawRect(TouchAreas.TROLL, paint);
	}

	private void drawHand(Canvas c) {
		Player p = gEngine.getPlayer();
		drawPict(c, p.getCard(0).getDrawableId(), DrawAreas.CARD_1);
		drawPict(c, p.getCard(1).getDrawableId(), DrawAreas.CARD_2);
		drawPict(c, p.getCard(2).getDrawableId(), DrawAreas.CARD_3);
		drawPict(c, p.getCard(3).getDrawableId(), DrawAreas.CARD_4);
		drawPict(c, p.getCard(4).getDrawableId(), DrawAreas.CARD_5);
		if(p.hasBonus()){
			drawPict(c, p.getCard(5).getDrawableId(), DrawAreas.CARD_6);
		}
	}
	
	private void drawCardsSel(Canvas c) {
		if(gEngine.getMode()==GameEngine.MODE_PLAY){
			for(Integer i : gEngine.getSelCards()){
			/*	switch(sel[i]){
				case 0:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_1);
					break;
				case 1:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_2);
					break;
				case 2:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_3);
					break;
				case 3:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_4);
					break;
				case 4:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_5);
					break;
				case 5:
					c.drawPict(c, R.drawable.card_sel_h, DrawAreas.Card_6);
					break;			
				}*/
			}
		}else if(gEngine.getMode()==GameEngine.MODE_CHOOSE_PRINCESS){
			//c.drawPict(c, R.drawable.card_sel_v, DrawAreas.DRAGON_STONE);
			//c.drawPict(c, R.drawable.card_sel_h, DrawAreas.TREASURE);
		}else {
			//c.drawPict(c, R.drawable.card_sel_v, DrawAreas.TROLL);
			//c.drawPict(c, R.drawable.card_sel_v, DrawAreas.PRINCESS);
		}
	}

	private void drawPict(Canvas c, int id, Point p) {
		Bitmap bmp = lib.get(id);
		Rect src = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
		Rect dest = new Rect(0 + p.getX(), 0 + p.getY(), bmp.getWidth() + p.getX(), bmp.getHeight() + p.getY());
		c.drawBitmap(bmp, src, dest, paint);
	}
}