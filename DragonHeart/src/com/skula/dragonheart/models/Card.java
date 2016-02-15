package com.skula.dragonheart.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		res.add(new Card(0, CardType.HUNTRESS, 1));
		res.add(new Card(0, CardType.HUNTRESS, 2));
		res.add(new Card(0, CardType.HUNTRESS, 3));
		res.add(new Card(0, CardType.HUNTRESS, 2));
		res.add(new Card(0, CardType.DRAGON_FIRE, 2));
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
