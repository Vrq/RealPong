package com.jtveiro.pong;

import com.badlogic.gdx.graphics.Color;

/** Class for declaring constant values
 *
 * Created by Varq on 2016-07-08.
 */
public class Constants {

    //display sizes:
    public final static int SCREEN_WIDTH = 400;
    public final static int SCREEN_HEIGHT = 700;

    //menu buttons:
    public final static float MENU_BUTTON_HEIGHT = SCREEN_HEIGHT/12;
    public final static float MENU_BUTTON_WIDTH = SCREEN_WIDTH*2/3;

    public final static float BTN_START_X = SCREEN_WIDTH/4;
    public final static float BTN_START_Y = 9*SCREEN_HEIGHT/15;
    public final static String BTN_START_LABEL = "Start";

    public final static float BTN_SCOREBOARD_X = SCREEN_WIDTH/10;
    public final static float BTN_SCOREBOARD_Y = 7*SCREEN_HEIGHT/15;
    public final static String BTN_SCOREBOARD_LABEL = "Scoreboard";

    public final static float BTN_OPTIONS_X = SCREEN_WIDTH/4;
    public final static float BTN_OPTIONS_Y = 5*SCREEN_HEIGHT/15;
    public final static String BTN_OPTIONS_LABEL = "Options";

    public final static float BTN_EXIT_X = SCREEN_WIDTH/10;
    public final static float BTN_EXIT_Y = 3*SCREEN_HEIGHT/15;
    public final static String BTN_EXIT_LABEL = "Exit";

    public final static float BTN_RETURN_X = SCREEN_WIDTH/10;
    public final static float BTN_RETURN_Y = SCREEN_HEIGHT/10;
    public final static float BTN_RETURN_WIDTH = 80;
    public final static float BTN_RETURN_HEIGHT = 90;

    public final static float BTN_PAUSE_X = SCREEN_WIDTH/10;
    public final static float BTN_PAUSE_Y = SCREEN_HEIGHT/2;
    public final static float BTN_PAUSE_WIDTH = 60;
    public final static float BTN_PAUSE_HEIGHT = 60;

    //text settings:
    public final static float TEXT_SCALE = 2.5f;


    //colors:
    public final static Color BACKGROUND_COLOR = Color.WHITE;
    public final static Color BTN_COLOR = new Color(42/255f,92/255f,179/255f,0);
    public final static Color FONT_COLOR = Color.GOLDENROD;
    public final static Color PLAYERSHIELD_COLOR = Color.NAVY;
    public final static Color BALL_COLOR = Color.CORAL;
    public final static Color COMPUTERSHIELD_COLOR = Color.MAROON;


    //dynamics:
    public final static float PLAYERSHIELD_SPEED = 500;
    public final static float COMPUTERSHIELD_SPEED = 500;
    public final static float MENUBUTTON_SPEED = 200;
    public final static float BALL_SPEED = 1000;
    public final static float ACCELEROMETER_GRAVITY = 9.8f;
    public final static float ACCELEROMETER_SENSITIVITY = 0.5f;

    //game objects:
    public final static float PLAYERSHIELD_WIDTH = 80;
    public final static float PLAYERSHIELD_HEIGHT = 15;
    public final static float BALL_RADIUS = 7;
    public final static float COMPUTERSHIELD_WIDTH = 80;
    public final static float COMPUTERSHIELD_HEIGHT = 15;


}
