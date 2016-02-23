package com.skula.dragonheart.cnst;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.skula.dragonheart.R;

// TODO: supprimer les images inutiles
// TODO: faire image fond
public class PictureLibrary {
	private Map<Integer, Bitmap> map;

	@SuppressLint("UseSparseArrays")
	public PictureLibrary(Resources res) {
		this.map = new HashMap<Integer, Bitmap>();
		this.map.put(R.drawable.board, BitmapFactory.decodeResource(res, R.drawable.board));
		this.map.put(R.drawable.parchemin, BitmapFactory.decodeResource(res, R.drawable.parchemin));
		this.map.put(R.drawable.card_sel_h, BitmapFactory.decodeResource(res, R.drawable.card_sel_h));
		this.map.put(R.drawable.card_sel_v, BitmapFactory.decodeResource(res, R.drawable.card_sel_v));
		this.map.put(R.drawable.huntress_1, BitmapFactory.decodeResource(res, R.drawable.huntress_1));
		this.map.put(R.drawable.huntress_2, BitmapFactory.decodeResource(res, R.drawable.huntress_2));
		this.map.put(R.drawable.dragon_fire_2, BitmapFactory.decodeResource(res, R.drawable.dragon_fire_2));
		this.map.put(R.drawable.dragon_fire_3, BitmapFactory.decodeResource(res, R.drawable.dragon_fire_3));
		this.map.put(R.drawable.dragon_fire_4, BitmapFactory.decodeResource(res, R.drawable.dragon_fire_4));
		this.map.put(R.drawable.treasure_1, BitmapFactory.decodeResource(res, R.drawable.treasure_1));
		this.map.put(R.drawable.treasure_2, BitmapFactory.decodeResource(res, R.drawable.treasure_2));
		this.map.put(R.drawable.treasure_3, BitmapFactory.decodeResource(res, R.drawable.treasure_3));
		this.map.put(R.drawable.treasure_4, BitmapFactory.decodeResource(res, R.drawable.treasure_4));
		this.map.put(R.drawable.princess_1, BitmapFactory.decodeResource(res, R.drawable.princess_1));
		this.map.put(R.drawable.princess_2, BitmapFactory.decodeResource(res, R.drawable.princess_2));
		this.map.put(R.drawable.dragon_stone_2_h, BitmapFactory.decodeResource(res, R.drawable.dragon_stone_2_h));
		this.map.put(R.drawable.dragon_stone_2_v, BitmapFactory.decodeResource(res, R.drawable.dragon_stone_2_v));
		this.map.put(R.drawable.dwarf_1, BitmapFactory.decodeResource(res, R.drawable.dwarf_1));
		this.map.put(R.drawable.dwarf_2, BitmapFactory.decodeResource(res, R.drawable.dwarf_2));
		this.map.put(R.drawable.dwarf_3, BitmapFactory.decodeResource(res, R.drawable.dwarf_3));
		this.map.put(R.drawable.troll_1, BitmapFactory.decodeResource(res, R.drawable.troll_1));
		this.map.put(R.drawable.troll_2, BitmapFactory.decodeResource(res, R.drawable.troll_2));
		this.map.put(R.drawable.troll_3, BitmapFactory.decodeResource(res, R.drawable.troll_3));
		this.map.put(R.drawable.knight_1, BitmapFactory.decodeResource(res, R.drawable.knight_1));
		this.map.put(R.drawable.knight_2, BitmapFactory.decodeResource(res, R.drawable.knight_2));
		this.map.put(R.drawable.ship, BitmapFactory.decodeResource(res, R.drawable.ship));
		this.map.put(R.drawable.deck_green, BitmapFactory.decodeResource(res, R.drawable.deck_green));
		this.map.put(R.drawable.deck_red, BitmapFactory.decodeResource(res, R.drawable.deck_red));
		this.map.put(R.drawable.bonus, BitmapFactory.decodeResource(res, R.drawable.bonus));
	}

	public Bitmap get(int id) {
		return map.get(id);
	}
}