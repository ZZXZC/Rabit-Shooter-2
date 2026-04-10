package com.engine.pixeria;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bots {
	Texture text;
	float x;
	float y;
	float speedX;
	float speedY;
	float dy,dx;
	Player player;
	
	public Bots(Texture text, float x, float y, Player player) {
		this.text = text;
		this.x = x;
		this.y = y;
		//this.speedX = speedX;
		//this.speedY = speedY;
		this.player = player;
	}
	public void update() {
		dx = player.x - x;
		dy = player.y - y;
		float d = (float) Math.sqrt(dx * dx + dy * dy);
		float c_speed = 70f * Gdx.graphics.getDeltaTime();
		if(d>0) {
			speedX = (dx/d)*c_speed;
			speedY = (dy/d)*c_speed;
		}
		x += speedX;
		y += speedY;
	}
	public void render(SpriteBatch bat) {
		bat.draw(text, x, y);
	}
}
