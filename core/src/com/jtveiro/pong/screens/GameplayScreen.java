package com.jtveiro.pong.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.jtveiro.pong.objects.Ball;
import com.jtveiro.pong.objects.ComputerShield;
import com.jtveiro.pong.Constants;
import com.jtveiro.pong.RealPongGame;
import com.jtveiro.pong.objects.PlayerShield;

/**
 * Created by Varq on 2016-07-08.
 */
public class GameplayScreen extends AbstractScreen {


    private Texture pauseButton;
    PlayerShield playerShield;
    ComputerShield computerShield;
    Ball ball;
    int playerPoints;
    int computerPoints;
    int winner; //1-player, 2-comp
    boolean isPaused = false;

    public GameplayScreen(RealPongGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        pauseButton = new Texture("pause_btn_clear.png");
        playerShield = new PlayerShield(viewport);
        computerShield = new ComputerShield(viewport);
        ball = new Ball(viewport,playerShield,computerShield);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if(!isPaused) {
            playerShield.update(delta);
            computerShield.update(delta,ball);
            ball.update(delta);

        }

        //show winner after someone reaches 10 points
        if(playerPoints>9) {
            winner = 1;
            game.setScreen(new WinnerScreen(game,winner));
        }
        if(computerPoints>9) {
            winner = 2;
            game.setScreen(new WinnerScreen(game,winner));
        }

        //add points and reset ball after it gets out of the end line
        if(ball.isOut()) {
            if(ball.position.y > viewport.getWorldHeight()) {
                playerPoints++;
            }
            if(ball.position.y < 0) {
                computerPoints++;
            }
            ball.init();
        }


        spriteBatch.begin();
        spriteBatch.draw(pauseButton, Constants.BTN_PAUSE_X, Constants.BTN_PAUSE_Y,Constants.BTN_PAUSE_WIDTH,Constants.BTN_PAUSE_HEIGHT);
        bitmapFont.getData().setScale(2);
        if(isPaused) {
            bitmapFont.draw(spriteBatch,"Paused", Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT/2,0, Align.center,false);

        }
        //bitmapFont.draw(spriteBatch,"Game", Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/8,0, Align.center,false);
        bitmapFont.draw(spriteBatch,"You: " + playerPoints, Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/8,0, Align.center,false);
        bitmapFont.draw(spriteBatch,"AI: " + computerPoints, Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT - Constants.SCREEN_HEIGHT/8,0, Align.center,false);
        // spriteBatch.draw(returnArrow,Constants.BTN_RETURN_X,Constants.BTN_RETURN_Y,Constants.BTN_RETURN_WIDTH,Constants.BTN_RETURN_HEIGHT);
        bitmapFont.draw(spriteBatch," " + computerShield.reactionStart, Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/2,0, Align.center,false);
        spriteBatch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        playerShield.render(shapeRenderer);
        computerShield.render(shapeRenderer);
        ball.render(shapeRenderer);
        shapeRenderer.end();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //return super.touchDown(screenX, screenY, pointer, button);
        Vector2 touchCords = viewport.unproject(new Vector2(screenX,screenY));

        if(touchCords.x > Constants.BTN_RETURN_X && touchCords.x < Constants.BTN_RETURN_X+Constants.BTN_RETURN_WIDTH && touchCords.y > Constants.BTN_RETURN_Y && touchCords.y < Constants.BTN_RETURN_Y+Constants.BTN_RETURN_HEIGHT) {
            game.showMenu();
        }

        if(touchCords.x > Constants.BTN_PAUSE_X && touchCords.x < Constants.BTN_PAUSE_X + Constants.BTN_PAUSE_WIDTH && touchCords.y > Constants.BTN_PAUSE_Y && touchCords.y < Constants.BTN_PAUSE_Y + Constants.BTN_PAUSE_HEIGHT) {
            isPaused = !isPaused;
        }

        return true;
    }
}
