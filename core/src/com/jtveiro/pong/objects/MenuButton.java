package com.jtveiro.pong.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jtveiro.pong.Constants;


/**
 * Created by Varq on 2016-07-16.
 */
public class MenuButton {
    public Vector2 position;
    Viewport viewport;
    String buttonLabel;
    float movementSpeed;

    public MenuButton(Vector2 initPosition, Viewport viewport, String buttonLabel, float movementSpeed) {
        this.position = initPosition;
        this.viewport = viewport;
        this.buttonLabel = buttonLabel;
        this.movementSpeed = movementSpeed;
    }

    public void update(float delta) {

        //keyboard control for desktop:
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta*movementSpeed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta*movementSpeed;
        }

        float accelerometerInput = Gdx.input.getAccelerometerX()/(Constants.ACCELEROMETER_GRAVITY* Constants.ACCELEROMETER_SENSITIVITY);

        position.x -= delta*accelerometerInput*movementSpeed;

        keepInBounds();
    }

    public void keepInBounds() {
        //keep PlayerShield within screen
        if(position.x < 0) {
            position.x = 0;
        }
        if(position.x + Constants.MENU_BUTTON_WIDTH > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constants.MENU_BUTTON_WIDTH;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BTN_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);

        renderer.rect(position.x,position.y, Constants.MENU_BUTTON_WIDTH, Constants.MENU_BUTTON_HEIGHT);

    }
}
