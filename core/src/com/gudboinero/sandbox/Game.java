package com.gudboinero.sandbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	private static Vector2 VIEWPORT_SIZE;
	private static Vector2 MAP_SIZE;
	private static int cellSize;

	public Game(int vx, int vy, int cs) {
		cellSize = cs;
		VIEWPORT_SIZE = new Vector2(vx, vy);
		MAP_SIZE = new Vector2(VIEWPORT_SIZE.x / cellSize, VIEWPORT_SIZE.y / cellSize);
	}

	private ArrayList<ArrayList<Integer>> map;

	private SpriteBatch batch;
	private OrthographicCamera camera;

	@Override
	public void create() {
		// Creates a camera and sets it to 2D and sets dimensions
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_SIZE.x, VIEWPORT_SIZE.y);

		// Initializes the sprite batch for our grid
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);

		batch.begin(); // Start drawing pixmap

		// Init pixmap
		Pixmap pixmap = new Pixmap(
				(int) VIEWPORT_SIZE.x, (int) VIEWPORT_SIZE.y,
				Pixmap.Format.RGBA8888
		);

		pixmap.setColor( 0, 1, 0, 0.75f ); // Set color

		// TODO: Use `map` to render pixels to screen

		Texture pixmapTex = new Texture( pixmap ); // Create texture from pixmap

		// Render pixmap
		batch.draw(pixmapTex, 0, 0);
		// Stop drawing pixmap
		batch.end();

		pixmap.dispose();
	}
}
