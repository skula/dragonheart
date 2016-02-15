package com.skula.dragonheart.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skula.dragonheart.cnst.TouchAreas;
import com.skula.dragonheart.enums.CardType;
import com.skula.dragonheart.models.Card;
import com.skula.dragonheart.models.Player;

public class GameEngine {
	public static final int MODE_PLAY = 0;
	public static final int MODE_CHOOSE_PRINCESS = 1;
	public static final int MODE_CHOOSE_KNIGHT = 2;

	public Player[] players;
	public int token;
	private Map<CardType, List<Card>> board;
	private List<Card> shipHold;
	private List<Integer> selCards;
	private int act;
	private int mode;

	public GameEngine() {
		this.act = 0;
		this.mode = MODE_PLAY;

		this.token = 0;
		this.players = new Player[2];

		List<Card> deck = Card.getCards();
		this.players[0] = new Player(0, deck);
		this.players[1] = new Player(1, deck);

		this.board = new HashMap<CardType, List<Card>>();
		this.board.put(CardType.HUNTRESS, new ArrayList<Card>());
		this.board.put(CardType.DRAGON_FIRE, new ArrayList<Card>());
		this.board.put(CardType.TREASURE, new ArrayList<Card>());
		this.board.put(CardType.PRINCESS, new ArrayList<Card>());
		this.board.put(CardType.DRAGON_STONE, new ArrayList<Card>());
		this.board.put(CardType.DWARF, new ArrayList<Card>());
		this.board.put(CardType.TROLL, new ArrayList<Card>());
		this.board.put(CardType.KNIGHT, new ArrayList<Card>());
		this.board.put(CardType.SHIP, new ArrayList<Card>());

		this.shipHold = new ArrayList<Card>();

		this.selCards = new ArrayList<Integer>();
	}

	public boolean process(int areaId) {
		switch (areaId) {
		case TouchAreas.CARD_1_ID:
			return handleCardSelected(0);
		case TouchAreas.CARD_2_ID:
			return handleCardSelected(1);
		case TouchAreas.CARD_3_ID:
			return handleCardSelected(2);
		case TouchAreas.CARD_4_ID:
			return handleCardSelected(3);
		case TouchAreas.CARD_5_ID:
			return handleCardSelected(4);
		case TouchAreas.CARD_6_ID:
			return handleCardSelected(5);
		case TouchAreas.BOARD_ID:
			// TODO: gerer les modes avec le nextplayer
			if (handleCardPlayed()) {
				nextPlayer();
				return true;
			} else {
				return false;
			}
		case TouchAreas.TREASURE_ID:
			for (Card c : board.get(CardType.TREASURE)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.TREASURE).clear();
			mode = MODE_PLAY;
			return true;
		case TouchAreas.DRAGON_STONE_ID:
			for (Card c : board.get(CardType.DRAGON_STONE)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.DRAGON_STONE).clear();
			players[token].setBonus(true);
			players[token == 0 ? 1 : 0].setBonus(false);
			mode = MODE_PLAY;
			return true;
		case TouchAreas.PRINCESS_ID:
			for (Card c : board.get(CardType.PRINCESS)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.PRINCESS).clear();
			mode = MODE_PLAY;
			return true;
		case TouchAreas.TROLL_ID:
			for (Card c : board.get(CardType.TROLL)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.TROLL).clear();
			mode = MODE_PLAY;
			return true;
		default:
			return false;
		}
	}

	private boolean handleCardSelected(int id) {
		for (Integer i : selCards) {
			if (players[token].getCard(i).getType() != players[token].getCard(id).getType()) {
				return false;
			}
		}

		if (selCards.contains(id)) {
			selCards.remove(new Integer(id));
		} else {
			selCards.add(id);
		}

		return true;
	}

	private boolean handleCardPlayed() {
		if (selCards.isEmpty()) {
			return false;
		}

		int tmp = 0;
		switch (players[token].getCard(selCards.get(0)).getType()) {
		case HUNTRESS:
			tmp = board.get(CardType.HUNTRESS).size() + selCards.size();
			if (tmp > 3) {
				return false;
			} else if (tmp == 3) {
				// on met dans la cale du navire
				for (Card c : board.get(CardType.HUNTRESS)) {
					shipHold.add(c);
				}
				board.get(CardType.HUNTRESS).clear();
				for (Integer i : selCards) {
					shipHold.add(players[token].getCard(i));
					players[token].pickCard(i);
				}

				// on prend les dragons de feu
				for (Card c : board.get(CardType.DRAGON_FIRE)) {
					players[token].addPoints(c.getPoints());
				}
				board.get(CardType.DRAGON_FIRE).clear();
				return true;
			} else {
				for (Integer i : selCards) {
					board.get(CardType.HUNTRESS).add(players[token].getCard(i));
					players[token].pickCard(i);
				}
				return true;
			}
		case DRAGON_FIRE:
			// on ajout les dragon
			for (Integer i : selCards) {
				board.get(CardType.DRAGON_FIRE).add(players[token].getCard(i));
				players[token].pickCard(i);
			}
			// on prend les trésors
			for (Card c : board.get(CardType.TREASURE)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.TREASURE).clear();
			return true;
		case TREASURE:
			// on ajout les tresors
			for (Integer i : selCards) {
				board.get(CardType.TREASURE).add(players[token].getCard(i));
				players[token].pickCard(i);
			}
			return true;
		case PRINCESS:
			for (Integer i : selCards) {
				board.get(CardType.PRINCESS).add(players[token].getCard(i));
				players[token].pickCard(i);
			}
			mode = MODE_CHOOSE_PRINCESS;
			return true;
		case DRAGON_STONE:
			// on ajout les dragons de pierre
			for (Integer i : selCards) {
				board.get(CardType.DRAGON_STONE).add(players[token].getCard(i));
				players[token].pickCard(i);
			}
			return true;
		case DWARF:
			tmp = board.get(CardType.DWARF).size() + selCards.size();
			if (tmp > 4) {
				return false;
			} else if (tmp == 4) {
				// on prends les nains
				for (Card c : board.get(CardType.DWARF)) {
					players[token].addPoints(c.getPoints());
				}
				board.get(CardType.DWARF).clear();

				for (Integer i : selCards) {
					players[token].addPoints(players[token].getCard(i).getPoints());
					players[token].pickCard(i);
				}
				return true;
			} else {
				// on ajoute les nains
				for (Integer i : selCards) {
					board.get(CardType.DWARF).add(players[token].getCard(i));
					players[token].pickCard(i);
				}
				return true;
			}
		case TROLL:
			// on ajout les troll
			for (Integer i : selCards) {
				board.get(CardType.TROLL).add(players[token].getCard(i));
				players[token].pickCard(i);
			}
			// on prend les putes a cheval
			for (Card c : board.get(CardType.PRINCESS)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.PRINCESS).clear();
			return true;
		case KNIGHT:
			tmp = board.get(CardType.KNIGHT).size() + selCards.size();
			if (tmp > 2) {
				return false;
			} else if (tmp == 2) {
				// on met dans la cale du navire
				for (Card c : board.get(CardType.KNIGHT)) {
					shipHold.add(c);
				}
				board.get(CardType.KNIGHT).clear();
				for (Integer i : selCards) {
					shipHold.add(players[token].getCard(i));
					players[token].pickCard(i);
				}

				mode = MODE_CHOOSE_KNIGHT;
				return true;
			} else {
				for (Integer i : selCards) {
					board.get(CardType.KNIGHT).add(players[token].getCard(i));
					players[token].pickCard(i);
				}
				return true;
			}
		case SHIP:
			tmp = board.get(CardType.SHIP).size() + selCards.size();
			if (tmp > 3) {
				return false;
			} else if (tmp == 3) {
				for (Integer i : selCards) {
					players[token].pickCard(i);
				}
				board.get(CardType.SHIP).clear();

				for (Card c : shipHold) {
					players[token].addPoints(c.getPoints());
				}
				shipHold.clear();

				act++;
				return true;
			} else {
				// on ajoute les navires
				for (Integer i : selCards) {
					board.get(CardType.SHIP).add(players[token].getCard(i));
					players[token].pickCard(i);
				}
				return true;
			}
		}
		return false;
	}

	public int getMode() {
		return mode;
	}

	public boolean isEndOfGame() {
		return act == 3;
	}

	public void nextPlayer() {
		token = token == 0 ? 1 : 0;
		selCards.clear();
	}
}
