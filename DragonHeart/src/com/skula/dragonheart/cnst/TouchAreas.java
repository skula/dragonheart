package com.skula.dragonheart.cnst;

import android.graphics.Rect;

public class TouchAreas {
	public static final int NONE = -1;
	public static final Rect CARD_1 = new Rect(DrawAreas.CARD_1.getX(), DrawAreas.CARD_1.getY(), DrawAreas.CARD_1.getX() +187, DrawAreas.CARD_1.getY()+296);
	public static final int CARD_1_ID = 0;
	public static final Rect CARD_2 = new Rect(DrawAreas.CARD_2.getX(), DrawAreas.CARD_2.getY(), DrawAreas.CARD_2.getX() +187, DrawAreas.CARD_2.getY()+296);
	public static final int CARD_2_ID = 1;
	public static final Rect CARD_3 = new Rect(DrawAreas.CARD_3.getX(), DrawAreas.CARD_3.getY(), DrawAreas.CARD_3.getX() +187, DrawAreas.CARD_3.getY()+296);
	public static final int CARD_3_ID = 2;
	public static final Rect CARD_4 = new Rect(DrawAreas.CARD_4.getX(), DrawAreas.CARD_4.getY(), DrawAreas.CARD_4.getX() +187, DrawAreas.CARD_4.getY()+296);
	public static final int CARD_4_ID = 3;
	public static final Rect CARD_5 = new Rect(DrawAreas.CARD_5.getX(), DrawAreas.CARD_5.getY(), DrawAreas.CARD_5.getX() +187, DrawAreas.CARD_5.getY()+296);
	public static final int CARD_5_ID = 4;
	public static final Rect CARD_6 = new Rect(DrawAreas.CARD_6.getX(), DrawAreas.CARD_6.getY(), DrawAreas.CARD_6.getX() +187, DrawAreas.CARD_6.getY()+296);
	public static final int CARD_6_ID = 5;

	public static final Rect BOARD = new Rect(DrawAreas.BOARD.getX(), DrawAreas.BOARD.getY(), DrawAreas.BOARD.getX() + 1867, DrawAreas.BOARD.getY()+663);
	public static final int BOARD_ID = 6;

	public static final Rect TREASURE = new Rect(DrawAreas.TREASURE.getX(), DrawAreas.TREASURE.getY(), DrawAreas.TREASURE.getX() +187, DrawAreas.TREASURE.getY()+296);
	public static final int TREASURE_ID = 7;
	public static final Rect DRAGON_STONE = new Rect(DrawAreas.DRAGON_STONE.getX(), DrawAreas.DRAGON_STONE.getY(), DrawAreas.DRAGON_STONE.getX() +296, DrawAreas.DRAGON_STONE.getY()+187);
	public static final int DRAGON_STONE_ID = 8;
	public static final Rect PRINCESS = new Rect(DrawAreas.PRINCESS.getX(), DrawAreas.PRINCESS.getY(), DrawAreas.PRINCESS.getX() +187, DrawAreas.PRINCESS.getY()+296);
	public static final int PRINCESS_ID = 9;
	public static final Rect TROLL = new Rect(DrawAreas.TROLL.getX(), DrawAreas.TROLL.getY(), DrawAreas.TROLL.getX() +187, DrawAreas.TROLL.getY()+296);
	public static final int TROLL_ID = 10;
	
	public static final Rect BTN_END_TURN = new Rect(DrawAreas.BTN_END_TURN.getX(), DrawAreas.BTN_END_TURN.getY(), DrawAreas.BTN_END_TURN.getX() +400, DrawAreas.BTN_END_TURN.getY()+133);
	public static final int BTN_END_TURN_ID = 10;
	public static final Rect BTN_NEXT_PLAYER = new Rect(DrawAreas.BTN_NEXT_PLAYER.getX(), DrawAreas.BTN_NEXT_PLAYER.getY(), DrawAreas.BTN_NEXT_PLAYER.getX() +667, DrawAreas.BTN_NEXT_PLAYER.getY()+133);
	public static final int BTN_NEXT_PLAYER_ID = 10;
}
