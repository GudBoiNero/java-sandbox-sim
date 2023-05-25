package com.gudboinero.sandbox;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		final Vector2 VIEWPORT_SIZE = new Vector2(800, 400);

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setWindowedMode((int) VIEWPORT_SIZE.x, (int) VIEWPORT_SIZE.y);
		config.setForegroundFPS(60);
		config.setTitle("Sandbox");

		new Lwjgl3Application(new Game((int) VIEWPORT_SIZE.x, (int) VIEWPORT_SIZE.y, 8), config);
	}
}
