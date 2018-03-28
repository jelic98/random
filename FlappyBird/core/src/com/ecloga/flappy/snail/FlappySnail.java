package com.ecloga.flappy.snail;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ecloga.flappy.snail.states.Menu;

public class FlappySnail extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "FlappySnail";

	private com.ecloga.flappy.snail.states.GameStateManager gsm;
	private SpriteBatch sb;

	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new com.ecloga.flappy.snail.states.GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
	}
}
