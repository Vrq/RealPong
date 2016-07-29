package com.jtveiro.pong.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jtveiro.pong.Constants;

/**
 * Created by Varq on 2016-07-16.
 */
public class PlayerShield {

    Vector2 position;
    Viewport viewport;

    public PlayerShield(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(Constants.SCREEN_WIDTH/2 - Constants.PLAYERSHIELD_WIDTH/2, 0);
    }

    public void update(float delta) {

        //keyboard control for desktop:
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta* Constants.PLAYERSHIELD_SPEED;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta* Constants.PLAYERSHIELD_SPEED;
        }

        float accelerometerInput = Gdx.input.getAccelerometerX()/(Constants.ACCELEROMETER_GRAVITY* Constants.ACCELEROMETER_SENSITIVITY);

        position.x -= delta*accelerometerInput* Constants.PLAYERSHIELD_SPEED;

        keepInBounds();
    }

    public void keepInBounds() {
        //keep PlayerShield within screen
        if(position.x < 0) {
            position.x = 0;
        }
        if(position.x + Constants.PLAYERSHIELD_WIDTH > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constants.PLAYERSHIELD_WIDTH;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYERSHIELD_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);

        renderer.rect(position.x,position.y, Constants.PLAYERSHIELD_WIDTH, Constants.PLAYERSHIELD_HEIGHT);
    }

}

