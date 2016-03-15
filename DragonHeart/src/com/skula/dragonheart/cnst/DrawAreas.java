package com.skula.dragonheart.cnst;

import com.skula.dragonheart.enums.CardType;
import com.skula.dragonheart.models.Point;

public class DrawAreas {
	public static final Point CARD_1 = new Point(530, 800);
	public static final Point CARD_2 = new Point(655, 800);
	public static final Point CARD_3 = new Point(780, 800);
	public static final Point CARD_4 = new Point(905, 800);
	public static final Point CARD_5 = new Point(1030, 800);
	public static final Point CARD_6 = new Point(1155, 800);
	
	public static final Point BOARD = new Point(15, 0);	
	public static final Point SHIP_HOLD = new Point(560, 620);
	
	public static final Point HUNTRESS = new Point(44, 250);
	public static final Point DRAGON_FIRE = new Point(290, 26);
	public static final Point TREASURE = new Point(745, 24);
	public static final Point PRINCESS = new Point(1160, 24);
	public static final Point DRAGON_STONE = new Point(1416, 52);
	public static final Point DWARF = new Point(1586, 258);
	public static final Point TROLL = new Point(1368, 292);
	public static final Point KNIGHT = new Point(941, 295);
	public static final Point SHIP = new Point(490, 250);
	
	public static final Point DECK_PLAYER_1 = new Point(10, 600);
	public static final Point DECK_PLAYER_2 = new Point(10, 700);
	public static final Point COUNT_CARDS_PLAYER_1 = new Point(60, 600);
	public static final Point COUNT_CARDS_PLAYER_2 = new Point(60, 700);
	public static final Point SCORE_PLAYER_1 = new Point(200, 600);
	public static final Point SCORE_PLAYER_2 = new Point(200, 700);
	public static final Point BONUS_PLAYER_1 = new Point(280, 600);
	public static final Point BONUS_PLAYER_2 = new Point(280, 700);
	
	public static final Point ACTS = new Point(500, 300);
	
	public static Point get(CardType ct){
		switch(ct){
		case HUNTRESS:
			return  HUNTRESS;
		case DRAGON_FIRE:
			return  DRAGON_FIRE;
		case TREASURE:
			return  TREASURE;
		case PRINCESS:
			return  PRINCESS;
		case DRAGON_STONE:
			return  DRAGON_STONE;
		case DWARF:
			return  DWARF;
		case TROLL:
			return  TROLL;
		case KNIGHT:
			return  KNIGHT;
		case SHIP:
			return  SHIP;
		default:
			return null;
		}
	}
}
