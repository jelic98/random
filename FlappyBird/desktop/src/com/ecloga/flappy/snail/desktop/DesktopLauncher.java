package com.ecloga.flappy.snail.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ecloga.flappy.snail.FlappySnail;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappySnail.WIDTH;
		config.height = FlappySnail.HEIGHT;
		config.title = FlappySnail.TITLE;
		new LwjglApplication(new FlappySnail(), config);
	}
}
