package com.jtveiro.pong.screens;

import com.badlogic.gdx.utils.Align;
import com.jtveiro.pong.Constants;
import com.jtveiro.pong.RealPongGame;

/**
 * Created by Varq on 2016-07-17.
 */
public class WinnerScreen extends AbstractScreen {

    int winner;

    public WinnerScreen(RealPongGame game, int winner){
        super(game);
        this.winner = winner;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        if(winner==1) {
            bitmapFont.draw(spriteBatch,"You win! Congratulations!", Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/2,0, Align.left,false);

        }
        else {
            bitmapFont.draw(spriteBatch,"Computer wins!", Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/2,0, Align.left,false);

        }
        spriteBatch.end();

    }
}
