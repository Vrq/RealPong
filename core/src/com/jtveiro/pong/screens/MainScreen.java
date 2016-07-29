package com.jtveiro.pong.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.jtveiro.pong.objects.MenuButton;
import com.jtveiro.pong.Constants;

/**
 * Created by Varq on 2016-07-08.
 */
public class MainScreen extends AbstractScreen {

    private Texture pongLogo;
    MenuButton startGameButton;
    MenuButton optionsButton;
    MenuButton scoreboardButton;
    MenuButton exitButton;

    public MainScreen(com.jtveiro.pong.RealPongGame game) {
        super(game);
        init();
    }

    private void init() {
        pongLogo = new Texture("pong_logo_gg.png");
        startGameButton = new MenuButton(new Vector2(Constants.BTN_START_X,Constants.BTN_START_Y),viewport,Constants.BTN_START_LABEL, Constants.MENUBUTTON_SPEED);
        optionsButton = new MenuButton(new Vector2(Constants.BTN_OPTIONS_X,Constants.BTN_OPTIONS_Y),viewport, Constants.BTN_OPTIONS_LABEL, Constants.MENUBUTTON_SPEED*2);
        scoreboardButton = new MenuButton(new Vector2(Constants.BTN_SCOREBOARD_X, Constants.BTN_SCOREBOARD_Y),viewport,Constants.BTN_SCOREBOARD_LABEL, Constants.MENUBUTTON_SPEED*1.2f);
        exitButton = new MenuButton(new Vector2(Constants.BTN_EXIT_X, Constants.BTN_EXIT_Y), viewport, Constants.BTN_EXIT_LABEL, Constants.MENUBUTTON_SPEED*0.5f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        startGameButton.update(delta);
        optionsButton.update(delta);
        scoreboardButton.update(delta);
        exitButton.update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(com.jtveiro.pong.Constants.BTN_COLOR);
        startGameButton.render(shapeRenderer);
        optionsButton.render(shapeRenderer);
        scoreboardButton.render(shapeRenderer);
        exitButton.render(shapeRenderer);
        shapeRenderer.end();

        //menu buttons:
       // shapeRenderer.rect(com.jtveiro.pong.Constants.BTN_START_X, com.jtveiro.pong.Constants.BTN_START_Y, com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH, com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT);
       // shapeRenderer.rect(com.jtveiro.pong.Constants.BTN_SCOREBOARD_X, com.jtveiro.pong.Constants.BTN_SCOREBOARD_Y, com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH, com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT);
       // shapeRenderer.rect(com.jtveiro.pong.Constants.BTN_OPTIONS_X, com.jtveiro.pong.Constants.BTN_OPTIONS_Y, com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH, com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT);
       // shapeRenderer.rect(com.jtveiro.pong.Constants.BTN_EXIT_X, com.jtveiro.pong.Constants.BTN_EXIT_Y, com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH, com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT);


        //display logo:
        spriteBatch.begin();
        spriteBatch.draw(pongLogo, Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT- Constants.SCREEN_HEIGHT/5,290,115);
        bitmapFont.draw(spriteBatch, Constants.BTN_START_LABEL, startGameButton.position.x+ Constants.MENU_BUTTON_WIDTH/2, startGameButton.position.y+ Constants.MENU_BUTTON_HEIGHT*2/3,0, Align.center,false);
        bitmapFont.draw(spriteBatch, Constants.BTN_OPTIONS_LABEL, optionsButton.position.x+ Constants.MENU_BUTTON_WIDTH/2, optionsButton.position.y+ Constants.MENU_BUTTON_HEIGHT*2/3,0, Align.center,false);
        bitmapFont.draw(spriteBatch, Constants.BTN_SCOREBOARD_LABEL, scoreboardButton.position.x+ Constants.MENU_BUTTON_WIDTH/2, scoreboardButton.position.y+ Constants.MENU_BUTTON_HEIGHT*2/3,0, Align.center,false);
        bitmapFont.draw(spriteBatch, Constants.BTN_EXIT_LABEL, exitButton.position.x+ Constants.MENU_BUTTON_WIDTH/2, exitButton.position.y+ Constants.MENU_BUTTON_HEIGHT*2/3,0,Align.center,false);
        spriteBatch.end();



    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       // return super.touchDown(screenX, screenY, pointer, button);

        Vector2 touchCords = viewport.unproject(new Vector2(screenX,screenY));

        if(touchCords.x > com.jtveiro.pong.Constants.BTN_START_X && touchCords.x < com.jtveiro.pong.Constants.BTN_START_X+ com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH && touchCords.y > com.jtveiro.pong.Constants.BTN_START_Y && touchCords.y < com.jtveiro.pong.Constants.BTN_START_Y+ com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT) {
            game.startGame();
        }

        if(touchCords.x > com.jtveiro.pong.Constants.BTN_OPTIONS_X && touchCords.x < com.jtveiro.pong.Constants.BTN_OPTIONS_X+ com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH && touchCords.y > com.jtveiro.pong.Constants.BTN_OPTIONS_Y && touchCords.y < com.jtveiro.pong.Constants.BTN_OPTIONS_Y+ com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT) {
            game.showOptions();
        }

        if(touchCords.x > com.jtveiro.pong.Constants.BTN_SCOREBOARD_X && touchCords.x < com.jtveiro.pong.Constants.BTN_SCOREBOARD_X+ com.jtveiro.pong.Constants.MENU_BUTTON_WIDTH && touchCords.y > com.jtveiro.pong.Constants.BTN_SCOREBOARD_Y && touchCords.y < com.jtveiro.pong.Constants.BTN_SCOREBOARD_Y+ com.jtveiro.pong.Constants.MENU_BUTTON_HEIGHT) {
            game.showScoreboard();
        }


        return true;
    }
}
