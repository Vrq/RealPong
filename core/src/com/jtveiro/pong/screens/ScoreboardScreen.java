package com.jtveiro.pong.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Varq on 2016-07-08.
 */
public class ScoreboardScreen extends AbstractScreen {
    public ScoreboardScreen(com.jtveiro.pong.RealPongGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        bitmapFont.getData().setScale(2);
        bitmapFont.draw(spriteBatch,"Scoreboard", com.jtveiro.pong.Constants.SCREEN_WIDTH/2, com.jtveiro.pong.Constants.SCREEN_HEIGHT - com.jtveiro.pong.Constants.SCREEN_HEIGHT/8,0, Align.center,false);
        spriteBatch.draw(returnArrow, com.jtveiro.pong.Constants.BTN_RETURN_X, com.jtveiro.pong.Constants.BTN_RETURN_Y, com.jtveiro.pong.Constants.BTN_RETURN_WIDTH, com.jtveiro.pong.Constants.BTN_RETURN_HEIGHT);
        spriteBatch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //return super.touchDown(screenX, screenY, pointer, button);
        Vector2 touchCords = viewport.unproject(new Vector2(screenX,screenY));

        if(touchCords.x > com.jtveiro.pong.Constants.BTN_RETURN_X && touchCords.x < com.jtveiro.pong.Constants.BTN_RETURN_X+ com.jtveiro.pong.Constants.BTN_RETURN_WIDTH && touchCords.y > com.jtveiro.pong.Constants.BTN_RETURN_Y && touchCords.y < com.jtveiro.pong.Constants.BTN_RETURN_Y+ com.jtveiro.pong.Constants.BTN_RETURN_HEIGHT) {
            game.showMenu();
        }

        return true;
    }
}
