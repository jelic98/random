package com.ecloga.flappy.snail.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.ecloga.flappy.snail.*;

/**
 * Created by Lazar on 14.12.2015.
 */
public class Menu extends State {
    private Texture background, playBtn;
    private Rectangle bounds;

    public Menu(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappySnail.WIDTH / 2, FlappySnail.HEIGHT / 2);
        background = new Texture("sky.png");
        playBtn = new Texture("replay.png");
        bounds = new Rectangle(cam.position.x - playBtn.getWidth() / 2, cam.position.y, playBtn.getWidth(), playBtn.getHeight());
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
