package com.skula.dragonheart.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skula.dragonheart.R;
import com.skula.dragonheart.cnst.TouchAreas;
import com.skula.dragonheart.enums.CardType;
import com.skula.dragonheart.models.Card;
import com.skula.dragonheart.models.Player;

public class GameEngine {
	public static final int MODE_PLAY = 0;
	public static final int MODE_CHOOSE_PRINCESS = 1;
	public static final int MODE_CHOOSE_KNIGHT = 2;

	public static final int TURNPHASE_PLAY = 0;
	public static final int TURNPHASE_END_TURN = 1;
	public static final int TURNPHASE_WAIT_PLAYER = 2;

	public static final int GAMEPHASE_INGAME = 0;
	public static final int GAMEPHASE_LAST_TURN = 1;
	public static final int GAMEPHASE_END = 2;

	public Player[] players;
	public int token;
	private Map<CardType, List<Card>> board;
	private List<Card> shipHold;
	private List<Integer> selCards;

	private int act;
	private int mode;
	private int turnPhase;
	private int gamePhase;

	public GameEngine() {
		this.act = 0;
		this.mode = MODE_PLAY;
		this.turnPhase = TURNPHASE_PLAY;
		this.gamePhase = GAMEPHASE_INGAME;

		this.token = 0;
		this.players = new Player[2];

		this.players[0] = new Player(0);
		this.players[1] = new Player(1);

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

		// bouchon:
		if (true) {
			selCards.add(1);
			selCards.add(3);
			selCards.add(4);
			this.board.get(CardType.HUNTRESS).add(new Card(R.drawable.huntress_1, CardType.HUNTRESS, 1));
			this.board.get(CardType.HUNTRESS).add(new Card(R.drawable.huntress_2, CardType.HUNTRESS, 2));
			this.board.get(CardType.SHIP).add(new Card(R.drawable.ship, CardType.SHIP, 1));
			this.board.get(CardType.SHIP).add(new Card(R.drawable.ship, CardType.SHIP, 1));
			this.board.get(CardType.TREASURE).add(new Card(R.drawable.treasure_1, CardType.TREASURE, 1));
			//this.board.get(CardType.TREASURE).add(new Card(R.drawable.treasure_1, CardType.TREASURE, 1));
			this.board.get(CardType.PRINCESS).add(new Card(R.drawable.princess_1, CardType.PRINCESS, 1));
			//this.board.get(CardType.PRINCESS).add(new Card(R.drawable.princess_1, CardType.PRINCESS, 1));
			this.board.get(CardType.KNIGHT).add(new Card(R.drawable.knight_1, CardType.KNIGHT, 1));
			//this.board.get(CardType.KNIGHT).add(new Card(R.drawable.knight_1, CardType.KNIGHT, 1));
			this.board.get(CardType.TROLL).add(new Card(R.drawable.troll_1, CardType.TROLL, 1));
			//this.board.get(CardType.TROLL).add(new Card(R.drawable.troll_1, CardType.TROLL, 1));
			this.board.get(CardType.DWARF).add(new Card(R.drawable.dwarf_1, CardType.DWARF, 1));
			this.board.get(CardType.DWARF).add(new Card(R.drawable.dwarf_1, CardType.DWARF, 1));
			this.board.get(CardType.DWARF).add(new Card(R.drawable.dwarf_1, CardType.DWARF, 1));
			this.board.get(CardType.DRAGON_FIRE).add(new Card(R.drawable.dragon_fire_2, CardType.DRAGON_FIRE, 1));
			this.board.get(CardType.DRAGON_STONE).add(new Card(R.drawable.dragon_stone_2_h, CardType.DRAGON_STONE, 1));

			this.shipHold.add(new Card(R.drawable.knight_1, CardType.KNIGHT, 1));

			players[token].setBonus(true);
		}
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
			if (selCards.isEmpty()) {
				return false;
			}
			CardType ct = players[token].getCard(selCards.get(0)).getType();
			if (handleCardPlayed()) {
				if (mode == MODE_PLAY) {
					turnPhase = TURNPHASE_END_TURN;
				}
				selCards.clear();
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
			turnPhase = TURNPHASE_END_TURN;
			selCards.clear();
			return true;
		case TouchAreas.DRAGON_STONE_ID:
			for (Card c : board.get(CardType.DRAGON_STONE)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.DRAGON_STONE).clear();
			players[token].setBonus(true);
			players[token == 0 ? 1 : 0].setBonus(false);
			mode = MODE_PLAY;
			turnPhase = TURNPHASE_END_TURN;
			selCards.clear();
			return true;
		case TouchAreas.PRINCESS_ID:
			for (Card c : board.get(CardType.PRINCESS)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.PRINCESS).clear();
			mode = MODE_PLAY;
			turnPhase = TURNPHASE_END_TURN;
			selCards.clear();
			return true;
		case TouchAreas.TROLL_ID:
			for (Card c : board.get(CardType.TROLL)) {
				players[token].addPoints(c.getPoints());
			}
			board.get(CardType.TROLL).clear();
			mode = MODE_PLAY;
			turnPhase = TURNPHASE_END_TURN;
			selCards.clear();
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
					shipHold.add(players[token].removeCard(i));
				}
				
				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}

				// on prend les dragons de feu
				for (Card c : board.get(CardType.DRAGON_FIRE)) {
					players[token].addPoints(c.getPoints());
				}
				board.get(CardType.DRAGON_FIRE).clear();
				return true;
			} else {
				for (Integer i : selCards) {
					board.get(CardType.HUNTRESS).add(players[token].removeCard(i));					
				}
				
				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				return true;
			}
		case DRAGON_FIRE:
			// on ajout les dragon
			for (Integer i : selCards) {
				board.get(CardType.DRAGON_FIRE).add(players[token].removeCard(i));				
			}
			
			// on rempli la main
			if(!players[token].fillHand()){
				gamePhase = GAMEPHASE_LAST_TURN;
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
				board.get(CardType.TREASURE).add(players[token].removeCard(i));
			}
			
			// on rempli la main
			if(!players[token].fillHand()){
				gamePhase = GAMEPHASE_LAST_TURN;
			}
			return true;
		case PRINCESS:
			for (Integer i : selCards) {
				board.get(CardType.PRINCESS).add(players[token].removeCard(i));
			}
			
			// on rempli la main
			if(!players[token].fillHand()){
				gamePhase = GAMEPHASE_LAST_TURN;
			}
			mode = MODE_CHOOSE_PRINCESS;
			return true;
		case DRAGON_STONE:
			// on ajout les dragons de pierre
			for (Integer i : selCards) {
				board.get(CardType.DRAGON_STONE).add(players[token].removeCard(i));
			}
			
			// on rempli la main
			if(!players[token].fillHand()){
				gamePhase = GAMEPHASE_LAST_TURN;
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
					Card c = players[token].removeCard(i);
					players[token].addPoints(c.getPoints());
				}
				
				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				return true;
			} else {// on rempli la main
				boolean a= players[token].fillHand();
				if(!a){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				// on ajoute les nains
				for (Integer i : selCards) {
					board.get(CardType.DWARF).add(players[token].removeCard(i));					
				}
				
				
				return true;
			}
		case TROLL:
			// on ajout les troll
			for (Integer i : selCards) {
				board.get(CardType.TROLL).add(players[token].removeCard(i));
			}
			
			// on rempli la main
			if(!players[token].fillHand()){
				gamePhase = GAMEPHASE_LAST_TURN;
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
					shipHold.add(players[token].removeCard(i));
				}
				
				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}

				mode = MODE_CHOOSE_KNIGHT;
				return true;
			} else {
				for (Integer i : selCards) {
					board.get(CardType.KNIGHT).add(players[token].removeCard(i));
				}
				
				// on rempli la main!players[token].fillHand()
				if(false){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				return true;
			}
		case SHIP:
			tmp = board.get(CardType.SHIP).size() + selCards.size();
			if (tmp > 3) {
				return false;
			} else if (tmp == 3) {
				for (Integer i : selCards) {
					players[token].removeCard(i);
				}
				board.get(CardType.SHIP).clear();

				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				
				for (Card c : shipHold) {
					players[token].addPoints(c.getPoints());
				}
				shipHold.clear();

				act++;
				if (act == 3) {
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				return true;
			} else {
				// on ajoute les navires
				for (Integer i : selCards) {
					board.get(CardType.SHIP).add(players[token].removeCard(i));
				}

				// on rempli la main
				if(!players[token].fillHand()){
					gamePhase = GAMEPHASE_LAST_TURN;
				}
				return true;
			}
		}
		return false;
	}

	public int getMode() {
		return mode;
	}

	public int getTurnPhase() {
		return turnPhase;
	}

	public void setTurnPhase(int phase) {
		this.turnPhase = phase;
	}

	public int getGamePhase() {
		return turnPhase;
	}

	public void setGamenPhase(int phase) {
		this.gamePhase = phase;
	}

	public void nextPlayer() {
		token = token == 0 ? 1 : 0;
	}

	public Player getPlayer() {
		return players[token];
	}

	public List<Integer> getSelCards() {
		return selCards;
	}

	public Map<CardType, List<Card>> getBoard() {
		return board;
	}

	public List<Card> getShipHold() {
		return shipHold;
	}

	public int getToken() {
		return token;
	}

	public int getAct() {
		return act;
	}
}
