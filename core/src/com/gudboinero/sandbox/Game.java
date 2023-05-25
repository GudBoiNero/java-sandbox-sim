package com.gudboinero.sandbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gudboinero.sandbox.cells.DirtCell;
import com.gudboinero.sandbox.cells.SandCell;
import com.gudboinero.sandbox.cells.WaterCell;

import java.util.Arrays;
import java.util.Random;

public class Game extends ApplicationAdapter {
	private static Vector2 VIEWPORT_SIZE;
	private static Vector2 MAP_SIZE;
	private static int CELL_SIZE;

	private final Grid map;
	private SpriteBatch batch;
	private OrthographicCamera camera;

	public Game(int vx, int vy, int cs) {
		CELL_SIZE = cs;
		VIEWPORT_SIZE = new Vector2(vx, vy);
		MAP_SIZE = new Vector2(VIEWPORT_SIZE.x / CELL_SIZE, VIEWPORT_SIZE.y / CELL_SIZE);
		map = new Grid((int) MAP_SIZE.x, (int) MAP_SIZE.y);
	}

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
		map.physicsUpdate(Gdx.graphics.getDeltaTime());

		// Draw cells
		Vector3 mousePos = new Vector3();
		mousePos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			map.putCell(new Vector2(mousePos.x / CELL_SIZE, mousePos.y / CELL_SIZE), new SandCell());
		}

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			map.putCell(new Vector2(mousePos.x / CELL_SIZE, mousePos.y / CELL_SIZE), new DirtCell());
		}

		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			map.putCell(new Vector2(mousePos.x / CELL_SIZE, mousePos.y / CELL_SIZE), new WaterCell());
		}

		batch.setProjectionMatrix(camera.combined);

		batch.begin(); // Start drawing pixmap

		// Init pixmap
		Pixmap pixmap = new Pixmap(
				(int) VIEWPORT_SIZE.x, (int) VIEWPORT_SIZE.y,
				Pixmap.Format.RGBA8888
		);

		pixmap.setColor( 0, 1, 0, 0.75f ); // Set color

		// TODO: Use `map` to render pixels to screen
		for (int yi = 0; yi < map.getGridSize().y; yi++) {
			for (int xi = 0; xi < map.getGridSize().x; xi++) {
				Vector2 pos = new Vector2(xi, yi);
				Cell cell = map.getCell(pos);

				if (cell == null) continue;

				for (int xp = 0; xp < CELL_SIZE; xp++) {
					for (int yp = 0; yp < CELL_SIZE; yp++) {
						pixmap.drawPixel((xi * CELL_SIZE) + xp, (yi * CELL_SIZE) + yp, cell.getColor().toIntBits());
					}
				}
			}
		}

		Texture pixmapTex = new Texture( pixmap ); // Create texture from pixmap

		// Render pixmap
		batch.draw(pixmapTex, 0, 0);
		// Stop drawing pixmap
		batch.end();

		pixmap.dispose();
	}
}
