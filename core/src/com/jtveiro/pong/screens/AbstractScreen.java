package com.jtveiro.pong.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//import com.badlogic.gdx.graphics.g2d.freetype;



/**
 * Created by Varq on 2016-07-08.
 */
public abstract class AbstractScreen extends InputAdapter implements Screen {

    protected com.jtveiro.pong.RealPongGame game;
    protected SpriteBatch spriteBatch;
    protected ShapeRenderer shapeRenderer;
    protected Stage stage;
    protected BitmapFont bitmapFont; //for text
    protected Viewport viewport = new FitViewport(com.jtveiro.pong.Constants.SCREEN_WIDTH, com.jtveiro.pong.Constants.SCREEN_HEIGHT);
    protected Texture returnArrow;

    public AbstractScreen(com.jtveiro.pong.RealPongGame game) {
        this.game = game;
        stage = new Stage(viewport);
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        bitmapFont = new BitmapFont();
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bitmapFont.getData().setScale(com.jtveiro.pong.Constants.TEXT_SCALE);
        bitmapFont.setColor(com.jtveiro.pong.Constants.FONT_COLOR);

        returnArrow = new Texture("pong_return_arrow.png");
        Gdx.input.setInputProcessor(this);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        viewport.apply(true);
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(com.jtveiro.pong.Constants.BACKGROUND_COLOR.r, com.jtveiro.pong.Constants.BACKGROUND_COLOR.g, com.jtveiro.pong.Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.dispose();
        spriteBatch.dispose();
        shapeRenderer.dispose();
        bitmapFont.dispose();
    }

   /* private void createFonts() {
        FileHandle fontFile = Gdx.files.internal("data/Roboto-Bold.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 12;
        textFont = generator.generateFont(parameter);
        parameter.size = 24;
        titleFont = generator.generateFont(parameter);
        generator.dispose();
    }*/
}
