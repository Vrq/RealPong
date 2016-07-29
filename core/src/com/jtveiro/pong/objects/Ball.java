package com.jtveiro.pong.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Varq on 2016-07-16.
 */
public class Ball {

    public Vector2 position;
    Vector2 movementSpeed;
    Viewport viewport;
    PlayerShield playerShield;
    ComputerShield computerShield;

    public Ball(Viewport viewport, PlayerShield playerShield, ComputerShield computerShield) {
        this.viewport = viewport;
        this.playerShield = playerShield;
        this.computerShield = computerShield;
        init();
    }

    public void init() {
        position = new Vector2(com.jtveiro.pong.Constants.SCREEN_WIDTH/2, com.jtveiro.pong.Constants.SCREEN_HEIGHT/2);
        int xSpeed = MathUtils.random(200,600);
        int ySpeed = 800-xSpeed;
        movementSpeed = new Vector2(xSpeed,ySpeed);
    }

    public void update(float delta) {
        position.x += delta*movementSpeed.x;
        position.y += delta*movementSpeed.y;

        whenBounce();
    }

    public void whenBounce() {

        //bounce from left side
        if(position.x - com.jtveiro.pong.Constants.BALL_RADIUS < 0) {
            position.x = com.jtveiro.pong.Constants.BALL_RADIUS;
            movementSpeed.x = -movementSpeed.x;
        }

        //bounce from right side
        if(position.x + com.jtveiro.pong.Constants.BALL_RADIUS > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - com.jtveiro.pong.Constants.BALL_RADIUS;
            movementSpeed.x = -movementSpeed.x;
        }

        //bounce from ComputerShield:
        if(position.y + com.jtveiro.pong.Constants.BALL_RADIUS > computerShield.position.y  && position.y + com.jtveiro.pong.Constants.BALL_RADIUS < computerShield.position.y + com.jtveiro.pong.Constants.COMPUTERSHIELD_HEIGHT/2 && position.x > computerShield.position.x -3 && position.x < computerShield.position.x + com.jtveiro.pong.Constants.COMPUTERSHIELD_WIDTH + 3) {
            position.y = computerShield.position.y - com.jtveiro.pong.Constants.BALL_RADIUS;
            movementSpeed.y = -movementSpeed.y;
        }

        //bounce from PlayerShield
        if(position.y - com.jtveiro.pong.Constants.BALL_RADIUS < com.jtveiro.pong.Constants.PLAYERSHIELD_HEIGHT  && position.y - com.jtveiro.pong.Constants.BALL_RADIUS > com.jtveiro.pong.Constants.PLAYERSHIELD_HEIGHT/2 && position.x > playerShield.position.x -3 && position.x < playerShield.position.x + com.jtveiro.pong.Constants.PLAYERSHIELD_WIDTH + 3) {
            position.y = com.jtveiro.pong.Constants.BALL_RADIUS + com.jtveiro.pong.Constants.PLAYERSHIELD_HEIGHT;
            movementSpeed.y = -movementSpeed.y;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(com.jtveiro.pong.Constants.BALL_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);

        renderer.circle(position.x,position.y, com.jtveiro.pong.Constants.BALL_RADIUS);

    }

    public boolean isOut() {
        if(position.y > viewport.getWorldHeight() || position.y < 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
