package com.skula.dragonheart.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.dragonheart.activities.views.BoardView;
import com.skula.dragonheart.services.GameEngine;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new BoardView(this, new GameEngine()));
	}

	@Override
	public void onBackPressed() {

	}
}