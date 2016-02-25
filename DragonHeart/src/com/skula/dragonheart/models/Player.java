package com.skula.dragonheart.models;

import java.util.List;

public class Player {
	private int id;
	private int score;
	private boolean bonus;
	private List<Card> deck;
	private Card[] hand;

	public Player(int id) {
		this.id = id;
		this.score = 0;
		this.bonus = false;
		this.deck  = Card.getCards();
		this.hand = new Card[6];
		for (int i = 0; i < 5; i++) {
			this.hand[i] = this.deck.remove(0);
		}
	}

	public Card getCard(int i) {
		return hand[i];
	}
	
	public Card removeCard(int i) {
		Card c = hand[i];
		hand[i] = deck.remove(0);
		return c;
	}

	// TODO: si un joueur perd le bonus: remettre la 6em cartes dans son deck
	public void setBonus(boolean bonus) {
		this.bonus = bonus;
		if (bonus == true) {
			hand[5] = deck.remove(0);
		} else {
			hand[5] = null;
		}
	}

	public void pickCard(int i) {
		hand[i] = deck.remove(0);
	}

	public int getCardsLeft() {
		return deck.size();
	}

	public boolean hasBonus() {
		return bonus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addPoints(int p) {
		score += p;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}
}
