package com.skula.dragonheart.cnst;

import com.skula.dragonheart.enums.CardType;
import com.skula.dragonheart.models.Point;



public class DrawAreas {
	public static final Point CARD_1 = new Point(600, 500);
	public static final Point CARD_2 = new Point(720, 500);
	public static final Point CARD_3 = new Point(840, 500);
	public static final Point CARD_4 = new Point(960, 500);
	public static final Point CARD_5 = new Point(1080, 500);
	public static final Point CARD_6 = new Point(1200, 500);
	
	public static final Point BOARD = new Point(0, 0);	
	
	public static final Point HUNTRESS = new Point(36, 160);
	public static final Point DRAGON_FIRE = new Point(198, 18);
	public static final Point TREASURE = new Point(0, 0);
	public static final Point PRINCESS = new Point(0, 0);
	public static final Point DRAGON_STONE = new Point(0, 0);
	public static final Point DWARF = new Point(0, 0);
	public static final Point TROLL = new Point(0, 0);
	public static final Point KNIGHT = new Point(0, 0);
	public static final Point SHIP = new Point(330, 160);
	
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
