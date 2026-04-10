package com.engine.pixeria;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class PowerUp {
	int power_type = 0;
	float x;
	float y;
	boolean power_status = true;
	Texture text;
	Player player;
	Random rand = new Random();
	public PowerUp(Texture text, float x , float y, Player player) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.player = player;
	}
	public void spawn() {
		if(!power_status) {
			int z= rand.nextInt(10);
			if(z==1) {
				power_status = true;
				int r = rand.nextInt(4)+1;
				if(r==1) {
					power_type = 1;
				}
				if(r==2) {
					power_type = 2;
				}
				if(r==3) {
					power_type = 3;
				}
				if(r==4) {
					power_type = 4;
				}
			}
		}
	}
	public void powerTester() {
		if(power_status) {
			Rectangle p = new Rectangle();
			Rectangle power = new Rectangle();
			if(p.overlaps(power)) {
				if(power_type == 1) {
					player.hp+=20;
				}
				if(power_type == 2) {
					Main.score+=200;
				}
				if(power_type == 3) {
					Main.bots.clear();
				}
				if(power_type == 4) {
			    	for(int i = 1 ; i<=20 ; i++) {
			    		Main.spawnbots();
			    	}
				}
				power_status = false;
			}
		}
	}
	public int powerType() {
		return power_type;
	}
	public void render(SpriteBatch bat) {
		bat.draw(text, x, y);
	}
}
