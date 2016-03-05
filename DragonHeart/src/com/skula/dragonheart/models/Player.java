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
		this.deck = Card.getCards();
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
		hand[i] = null;
		return c;
	}

	// TODO: a refaire
	public boolean fillHand() {
		for (int i = 0; i < 5; i++) {
			if (hand[i] == null) {
				if (deck.isEmpty()) {
					return false;
				} else {
					hand[i] = this.deck.remove(0);
				}
			}
		}

		if (hasBonus()) {
			if (hand[5] == null) {
				if (deck.isEmpty()) {
					return false;
				} else {
					hand[5] = this.deck.remove(0);
				}
			}
		}
		return true;
	}

	// TODO: (a tester) si un joueur perd le bonus: remettre la 6em cartes dans
	// son deck
	// TODO: fin de partie quand la 6eme carte ne peut pas etre prise ???
	public boolean setBonus(boolean bonus) {
		this.bonus = bonus;
		if (bonus == true) {
			if (!deck.isEmpty()) {
				hand[5] = deck.remove(0);
				return true;
			} else {
				return false;
			}
		} else {
			deck.add(hand[5]);
			hand[5] = null;
			return true;
		}
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
