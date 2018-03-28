package com.ecloga.flappy.snail.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.ecloga.flappy.snail.*;
import com.ecloga.flappy.snail.sprites.Pipe;
import com.ecloga.flappy.snail.sprites.Snail;

/**
 * Created by Lazar on 14.12.2015.
 */
public class PlayState extends State {
    private int counter;
    private Snail snail;
    private Texture background, ground;
    private Vector2 groundPos1, groundPos2;
    private static final int PIPE_SPACING = 100;
    private static final int PIPE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;
    private static final int FIRST_PIPE_SPACING = 500;
    private Array<Pipe> pipes;
    private Label scoreLabel;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        counter = 0;
        snail = new Snail(50, 300);
        cam.setToOrtho(false, FlappySnail.WIDTH / 2, FlappySnail.HEIGHT / 2);
        background = new Texture("sky.png");
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2(cam.position.x - cam.viewportWidth / 2 + ground.getWidth(), GROUND_Y_OFFSET);
        pipes = new Array<Pipe>();
        scoreLabel = new Label(String.valueOf(counter), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel.setPosition(
                cam.viewportWidth * 0.5f - scoreLabel.getWidth() * 0.5f,
                scoreLabel.getHeight() * 0.3f);

        for(int i = 1; i <= PIPE_COUNT; i++) {
            pipes.add(new Pipe(i * (PIPE_SPACING + Pipe.PIPE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            snail.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        snail.update(dt);
        cam.position.x = snail.getPosition().x + 80;

        for(int i = 0; i < pipes.size; i++) {
            Pipe pipe = pipes.get(i);

            if(cam.position.x - cam.viewportWidth / 2 > pipe.getPosPipeUp().x + pipe.getPipeUp().getWidth()) {
                pipe.reposition(pipe.getPosPipeUp().x + (Pipe.PIPE_WIDTH + PIPE_SPACING) * PIPE_COUNT);
            }

            if(pipe.collides(snail.getBounds())) {
                gsm.set(new Menu(gsm));
            }

            if(pipe.scores(snail.getBounds())) {
                counter++;
            }
        }

        if(snail.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET) {
            gsm.set(new Menu(gsm));
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(snail.getSnail(), snail.getPosition().x, snail.getPosition().y);

        for(Pipe pipe : pipes){
            sb.draw(pipe.getPipeUp(), pipe.getPosPipeUp().x, pipe.getPosPipeUp().y);
            sb.draw(pipe.getPipeDown(), pipe.getPosPipeDown().x, pipe.getPosPipeDown().y);
            sb.draw(pipe.getScore(), pipe.getPosScore().x, pipe.getPosScore().y);
        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        snail.dispose();
        ground.dispose();

        for(Pipe pipe : pipes) {
            pipe.dispose();
        }
    }

    private void updateGround() {
        if(cam.position.x - cam.viewportWidth / 2 > groundPos1.x + ground.getWidth()) {
            groundPos1.add(ground.getWidth() * 2, 0);
        }

        if(cam.position.x - cam.viewportWidth / 2 > groundPos2.x + ground.getWidth()) {
            groundPos2.add(ground.getWidth() * 2, 0);
        }
    }
}
