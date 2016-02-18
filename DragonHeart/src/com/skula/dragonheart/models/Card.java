package com.skula.dragonheart.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skula.dragonheart.R;
import com.skula.dragonheart.enums.CardType;

public class Card {
	private int drawId;
	private CardType type;
	private int points;

	public Card(int drawId, CardType type, int points) {
		this.drawId = drawId;
		this.type = type;
		this.points = points;
	}

	public static List<Card> getCards() {
		List<Card> res = new ArrayList<Card>();
		// TODO: ajouter les cartes
		res.add(new Card(R.drawable.huntress_1, CardType.HUNTRESS, 1));
		res.add(new Card(R.drawable.huntress_2, CardType.HUNTRESS, 2));
		res.add(new Card(R.drawable.huntress_3, CardType.HUNTRESS, 3));
		res.add(new Card(R.drawable.huntress_4, CardType.HUNTRESS, 4));
		res.add(new Card(R.drawable.dragon_fire_1, CardType.DRAGON_FIRE, 1));
		res.add(new Card(R.drawable.dragon_fire_2, CardType.DRAGON_FIRE, 2));
		res.add(new Card(R.drawable.dragon_fire_3, CardType.DRAGON_FIRE, 3));
		res.add(new Card(R.drawable.dragon_fire_4, CardType.DRAGON_FIRE, 4));
		res.add(new Card(R.drawable.treasure_1, CardType.TREASURE, 1));
		res.add(new Card(R.drawable.treasure_2, CardType.TREASURE, 2));
		res.add(new Card(R.drawable.treasure_3, CardType.TREASURE, 3));
		res.add(new Card(R.drawable.treasure_4, CardType.TREASURE, 4));
		res.add(new Card(R.drawable.princess_1, CardType.PRINCESS, 1));
		res.add(new Card(R.drawable.princess_2, CardType.PRINCESS, 2));
		res.add(new Card(R.drawable.princess_3, CardType.PRINCESS, 3));
		res.add(new Card(R.drawable.princess_4, CardType.PRINCESS, 4));
		res.add(new Card(R.drawable.dragon_stone_1_v, CardType.DRAGON_STONE, 1));
		res.add(new Card(R.drawable.dragon_stone_2_v, CardType.DRAGON_STONE, 2));
		res.add(new Card(R.drawable.dragon_stone_3_v, CardType.DRAGON_STONE, 3));
		res.add(new Card(R.drawable.dragon_stone_4_v, CardType.DRAGON_STONE, 4));
		res.add(new Card(R.drawable.dwarf_1, CardType.DWARF, 1));
		res.add(new Card(R.drawable.dwarf_2, CardType.DWARF, 2));
		res.add(new Card(R.drawable.dwarf_3, CardType.DWARF, 3));
		res.add(new Card(R.drawable.dwarf_4, CardType.DWARF, 4));
		res.add(new Card(R.drawable.troll_1, CardType.TROLL, 1));
		res.add(new Card(R.drawable.troll_2, CardType.TROLL, 2));
		res.add(new Card(R.drawable.troll_3, CardType.TROLL, 3));
		res.add(new Card(R.drawable.troll_4, CardType.TROLL, 4));
		res.add(new Card(R.drawable.knight_1, CardType.KNIGHT, 1));
		res.add(new Card(R.drawable.knight_2, CardType.KNIGHT, 2));
		res.add(new Card(R.drawable.knight_3, CardType.KNIGHT, 3));
		res.add(new Card(R.drawable.knight_4, CardType.KNIGHT, 4));
		res.add(new Card(R.drawable.ship, CardType.SHIP, 0));
		Collections.shuffle(res);
		return res;
	}

	public int getDrawableId() {
		return drawId;
	}

	public void setDrawId(int drawId) {
		this.drawId = drawId;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
