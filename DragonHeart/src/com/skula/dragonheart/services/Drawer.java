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
	private static final int CARD_DX = 23;
	private static final int CARD_DY = 18;

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
		switch(gEngine.getGamePhase()){
		case GameEngine.GAMEPHASE_INGAME:
			switch (gEngine.getTurnPhase()) {
			case GameEngine.TURNPHASE_PLAY:
				drawBoard(c);
				drawScore(c);
				drawHand(c);
				drawCardsSel(c);
				break;
			case GameEngine.TURNPHASE_END_TURN:
				drawBoard(c);
				drawScore(c);
				drawHand(c);
				drawCardsSel(c);
				paint.setColor(Color.LTGRAY);
				paint.setTextSize(40f);
				c.drawText("Cliquer pour finir le tour", DrawAreas.LOG.getX(), DrawAreas.LOG.getY(), paint);
				break;
			case GameEngine.TURNPHASE_WAIT_PLAYER:
				drawBoard(c);
				paint.setTextSize(40f);
				paint.setColor(Color.LTGRAY);
				c.drawText("En attente du joueur suivant", DrawAreas.LOG.getX(), DrawAreas.LOG.getY(), paint);
				break;
			}
			break;
		case GameEngine.GAMEPHASE_LAST_TURN:
			switch (gEngine.getTurnPhase()) {
			case GameEngine.TURNPHASE_PLAY:
				drawBoard(c);
				drawScore(c);
				drawHand(c);
				drawCardsSel(c);
				break;
			case GameEngine.TURNPHASE_END_TURN:
				drawBoard(c);
				drawScore(c);
				drawHand(c);
				drawCardsSel(c);
				break;
			case GameEngine.TURNPHASE_WAIT_PLAYER:
				drawBoard(c);
				paint.setTextSize(40f);
				c.drawText("msg a effacer", 150, 600, paint);
				break;
			}
			paint.setColor(Color.LTGRAY);
			c.drawText("Dernier tour !", DrawAreas.LOG.getX(), DrawAreas.LOG.getY(), paint);
			break;
		case GameEngine.GAMEPHASE_END:
			break;
		}
		//drawTouchAreas(c);
		

		//int w = lib.get(R.drawable.board).getWidth();
		//int h = lib.get(R.drawable.board).getHeight();
		//c.drawText("board: " + w + ", " + h, 200, 200, paint);
	}

	private void drawScore(Canvas c) {
		paint.setTextSize(60f);
		paint.setColor(Color.WHITE);
		
		drawPict(c, R.drawable.deck_green, DrawAreas.DECK_PLAYER_1);
		c.drawText(gEngine.players[0].getCardsLeft() + "", DrawAreas.COUNT_CARDS_PLAYER_1.getX(), DrawAreas.COUNT_CARDS_PLAYER_1.getY(), paint);
		drawPict(c, R.drawable.deck_red, DrawAreas.DECK_PLAYER_2);
		c.drawText(gEngine.players[1].getCardsLeft() + "", DrawAreas.COUNT_CARDS_PLAYER_2.getX(), DrawAreas.COUNT_CARDS_PLAYER_2.getY(), paint);

		paint.setColor(Color.DKGRAY);
		if(gEngine.getToken() == 0){
			c.drawText(gEngine.players[0].getScore() + "pts", DrawAreas.SCORE_PLAYER_1.getX(), DrawAreas.SCORE_PLAYER_1.getY(), paint);
		}else{
			c.drawText(gEngine.players[1].getScore() + "pts", DrawAreas.SCORE_PLAYER_2.getX(), DrawAreas.SCORE_PLAYER_2.getY(), paint);
		}
		
		if (gEngine.players[0].hasBonus()) {
			drawPict(c, R.drawable.bonus, DrawAreas.BONUS_PLAYER_1);
		}
		if (gEngine.players[1].hasBonus()) {
			drawPict(c, R.drawable.bonus, DrawAreas.BONUS_PLAYER_2);
		}
	}

	private void drawBoard(Canvas c) {
		//drawPict(c, R.drawable.parchemin, new Rect(0,0,1350,756));
		drawPict(c, R.drawable.board, DrawAreas.BOARD);
		Map<CardType, List<Card>> board = gEngine.getBoard();
		Point p = null;
		for (CardType ct : board.keySet()) {
			p = DrawAreas.get(ct);
			for (int i = 0; i < board.get(ct).size(); i++) {
				if (ct == CardType.HUNTRESS || ct == CardType.SHIP || ct == CardType.KNIGHT || ct == CardType.DWARF) {
					drawPict(c, board.get(ct).get(i).getDrawableId(), p.clone(i * CARD_DX, i * CARD_DY));
				} else {
					switch (board.get(ct).get(i).getDrawableId()) {
					case R.drawable.dragon_stone_2_v:
						drawPict(c, R.drawable.dragon_stone_2_h, p);
						break;
					default:
						drawPict(c, board.get(ct).get(i).getDrawableId(), p);
						break;
					}
				}
			}
		}

		for (Card sh : gEngine.getShipHold()) {
			drawPict(c, sh.getDrawableId(), DrawAreas.SHIP_HOLD);
		}

		paint.setTextSize(50f);
		paint.setColor(Color.WHITE);
		c.drawText("x " + gEngine.getAct() + "/3",DrawAreas.ACTS.getX(), DrawAreas.ACTS.getY(), paint);
	}

	private void drawTouchAreas(Canvas c) {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);

		c.drawRect(TouchAreas.CARD_1, paint);
		c.drawRect(TouchAreas.CARD_2, paint);
		c.drawRect(TouchAreas.CARD_3, paint);
		c.drawRect(TouchAreas.CARD_4, paint);
		c.drawRect(TouchAreas.CARD_5, paint);
		c.drawRect(TouchAreas.CARD_6, paint);

		c.drawRect(TouchAreas.BOARD, paint);
		c.drawRect(TouchAreas.DRAGON_STONE, paint);
		c.drawRect(TouchAreas.TREASURE, paint);
		c.drawRect(TouchAreas.PRINCESS, paint);
		c.drawRect(TouchAreas.TROLL, paint);
	}

	private void drawHand(Canvas c) {
		Player p = gEngine.getPlayer();
		for(int i =0; i<6; i++){
			if(p.getCard(i)!= null){
				switch(i){
				case 0:
					drawPict(c, p.getCard(0).getDrawableId(), DrawAreas.CARD_1);
					break;
				case 1:
					drawPict(c, p.getCard(1).getDrawableId(), DrawAreas.CARD_2);
					break;
				case 2:
					drawPict(c, p.getCard(2).getDrawableId(), DrawAreas.CARD_3);
					break;
				case 3:
					drawPict(c, p.getCard(3).getDrawableId(), DrawAreas.CARD_4);
					break;
				case 4:
					drawPict(c, p.getCard(4).getDrawableId(), DrawAreas.CARD_5);
					break;
				case 5:
					if (p.hasBonus()) {
						drawPict(c, p.getCard(5).getDrawableId(), DrawAreas.CARD_6);
					}
					break;
				}
			}
		}
	}

	private void drawCardsSel(Canvas c) {
		if (gEngine.getMode() == GameEngine.MODE_PLAY) {
			for (Integer i : gEngine.getSelCards()) {
				switch (i) {
				case 0:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_1);
					break;
				case 1:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_2);
					break;
				case 2:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_3);
					break;
				case 3:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_4);
					break;
				case 4:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_5);
					break;
				case 5:
					drawPict(c, R.drawable.card_sel_v, DrawAreas.CARD_6);
					break;
				}
			}
		} else if (gEngine.getMode() == GameEngine.MODE_CHOOSE_PRINCESS) {
			drawPict(c, R.drawable.card_sel_h, DrawAreas.DRAGON_STONE);
			drawPict(c, R.drawable.card_sel_v, DrawAreas.TREASURE);
		} else {
			drawPict(c, R.drawable.card_sel_v, DrawAreas.TROLL);
			drawPict(c, R.drawable.card_sel_v, DrawAreas.PRINCESS);
		}
	}

	private void drawPict(Canvas c, int id, Point p) {
		Bitmap bmp = lib.get(id);
		Rect src = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
		Rect dest = new Rect(0 + p.getX(), 0 + p.getY(), bmp.getWidth() + p.getX(), bmp.getHeight() + p.getY());
		c.drawBitmap(bmp, src, dest, paint);
	}
	
	private void drawPict(Canvas c, int id, Rect dest) {
		Bitmap bmp = lib.get(id);
		Rect src = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
		c.drawBitmap(bmp, src, dest, paint);
	}
}