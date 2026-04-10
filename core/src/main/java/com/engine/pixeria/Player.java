package com.engine.pixeria;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	Texture text;
	float x,y;
	int hp;
	float p_speed;
	public Player(Texture text, float p_speed, int hp) {
		this.text = text;
		this.y =350;
		this.x =350;
		this.p_speed = p_speed;
		this.hp = hp;
	}
	public void update() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			y+=p_speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			y-=p_speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			x+=p_speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			x-=p_speed;
		}
	}
	public void render(SpriteBatch bat) {
		bat.draw(text,x,y);
	}
}
