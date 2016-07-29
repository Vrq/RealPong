package com.jtveiro.pong.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jtveiro.pong.Constants;
import com.jtveiro.pong.objects.Ball;

/**
 * Created by Varq on 2016-07-16.
 */
public class ComputerShield {

    Vector2 position;
    Viewport viewport;
    public float reactionStart = 0;
    private boolean calculateFlag = true;

    public ComputerShield(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(Constants.SCREEN_WIDTH/2 - Constants.COMPUTERSHIELD_WIDTH/2, Constants.SCREEN_HEIGHT-Constants.COMPUTERSHIELD_HEIGHT);
    }

    public void update(float delta, Ball ball) {

       //TODO: add AI here
        //comp should start moving, when the ball reaches a % of the screen height


        if(calculateFlag && ball.movementSpeed.y < 0) {
            reactionStart = MathUtils.random(50,90)/100f;
            calculateFlag = false;
        }
        if(!calculateFlag && ball.movementSpeed.y > 0) {
            calculateFlag = true;
        }

        if(ball.position.y < viewport.getWorldHeight()/2) {
            if(position.x + Constants.COMPUTERSHIELD_WIDTH/2 < viewport.getWorldWidth()/2) {
                position.x += delta*Constants.COMPUTERSHIELD_SPEED;
            }
            if(position.x + Constants.COMPUTERSHIELD_WIDTH/2 > viewport.getWorldWidth()/2) {
                position.x -= delta*Constants.COMPUTERSHIELD_SPEED;
            }
        }
        else {
            if(ball.position.y > viewport.getWorldHeight() * reactionStart) {
                if(ball.position.x > position.x + Constants.COMPUTERSHIELD_WIDTH / 2) {
                    position.x += delta * Constants.COMPUTERSHIELD_SPEED;
                }

                if(ball.position.x < position.x + Constants.COMPUTERSHIELD_WIDTH / 2) {
                    position.x -= delta * Constants.COMPUTERSHIELD_SPEED;
                }
            }
        }

        keepInBounds();
    }

    public void keepInBounds() {
        //keep ComputerShield within screen
        if(position.x < 0) {
            position.x = 0;
        }
        if(position.x + Constants.COMPUTERSHIELD_WIDTH > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constants.COMPUTERSHIELD_WIDTH;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.COMPUTERSHIELD_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);

        renderer.rect(position.x,position.y,Constants.COMPUTERSHIELD_WIDTH,Constants.COMPUTERSHIELD_HEIGHT);
    }

}
