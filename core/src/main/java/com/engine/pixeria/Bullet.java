package com.engine.pixeria;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
	Texture text;
	float x;
	float y;
	float speedX,speedY;
	
	public Bullet(Texture text, float x, float y, float speedX, float speedY) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	public void update() {
		x += speedX;
		y += speedY;
	}
	public void render(SpriteBatch bat){ 
		bat.draw(text , x , y);
	}
	
}
