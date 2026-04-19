package com.engine.pixeria;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;


public class Gui {
	Texture[] playButton;
	Texture[] diffButton;
	Texture[] easyButton,hardButton,midButton;
	ImageButton playBtn , diffBtn , easyBtn , midBtn , hardBtn;
	ImageButtonStyle playStyle , diffStyle , easyStyle , midStyle , hardStyle;
	Stage stage;
	Texture game_over_img;
	boolean diff_gui = false;
	public Gui() {
	playButton = new Texture[3];
	
	diffButton = new Texture[3];
	
	easyButton = new Texture[3];
	midButton = new Texture[3];
	hardButton = new Texture[3];
	game_over_img = new Texture("ui/gameover.png");
	stage = new Stage();
	Gdx.input.setInputProcessor(stage);
	loadImages();
	
	createImages();
	
	mouseHandle();
	
	stage.addActor(playBtn);
	stage.addActor(diffBtn);
	stage.addActor(easyBtn);
	stage.addActor(midBtn);
	stage.addActor(hardBtn);
	}
	public void mainMenu() {
		ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
		playBtn.setPosition(263, 100);
	}
	public void gameOver(SpriteBatch bat) {
		bat.draw(game_over_img, 100 , 300);
	}
	
	public void render(SpriteBatch bat) {
		stage.act(Gdx.graphics.getDeltaTime());
		if(Main.mainMenu) {
			mainMenu();
	        stage.draw();
		}
		else if(Main.gameOver){
			gameOver(bat);
		}

	}
	public void mouseHandle() {
		playBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event , float x , float y) {
				Main.mainMenu = false;
				Main.game_running = true;
			}
		});
		diffBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event , float x , float y) {
				diff_gui = true;
			}
		});
		easyBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event , float x , float y) {
				Main.spawn_time = 1;
			}
		});
		midBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event , float x , float y) {
				Main.spawn_time = 0.65f;
			}
		});
		hardBtn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event , float x , float y) {
				Main.spawn_time = 0.4f;
			}
		});
	}
	public void createImages() {
		playStyle = new ImageButtonStyle();
		playStyle.up = new TextureRegionDrawable(new TextureRegion(playButton[0]));
		playStyle.over = new TextureRegionDrawable(new TextureRegion(playButton[1]));
		playStyle.down = new TextureRegionDrawable(new TextureRegion(playButton[2]));
		playBtn = new ImageButton(playStyle); 
		
		diffStyle = new ImageButtonStyle();
		diffStyle.up = new TextureRegionDrawable(new TextureRegion(diffButton[0]));
		diffStyle.over = new TextureRegionDrawable(new TextureRegion(diffButton[1]));
		diffStyle.down = new TextureRegionDrawable(new TextureRegion(diffButton[2]));
		diffBtn = new ImageButton(diffStyle); 
		
		easyStyle = new ImageButtonStyle();
		easyStyle.up = new TextureRegionDrawable(new TextureRegion(easyButton[0]));
		easyStyle.over = new TextureRegionDrawable(new TextureRegion(easyButton[1]));
		easyStyle.down = new TextureRegionDrawable(new TextureRegion(easyButton[2]));
		easyBtn = new ImageButton(easyStyle); 
		
		midStyle = new ImageButtonStyle();
		midStyle.up = new TextureRegionDrawable(new TextureRegion(midButton[0]));
		midStyle.over = new TextureRegionDrawable(new TextureRegion(midButton[1]));
		midStyle.down = new TextureRegionDrawable(new TextureRegion(midButton[2]));
		midBtn = new ImageButton(midStyle); 
		
		hardStyle = new ImageButtonStyle();
		hardStyle.up = new TextureRegionDrawable(new TextureRegion(hardButton[0]));
		hardStyle.over = new TextureRegionDrawable(new TextureRegion(hardButton[1]));
		hardStyle.down = new TextureRegionDrawable(new TextureRegion(hardButton[2]));
		hardBtn = new ImageButton(hardStyle); 
	}
	public void loadImages() {
		playButton[0] = new Texture(Gdx.files.internal("ui/PlayButton/PlayStatic.png"));
		playButton[1] = new Texture(Gdx.files.internal("ui/PlayButton/PlayHover.png"));
		playButton[2] = new Texture(Gdx.files.internal("ui/PlayButton/PlayClicked.png"));
		
		diffButton[0] = new Texture(Gdx.files.internal("ui/DifficultyButton/DifficultyStatic.png"));
		diffButton[1] = new Texture(Gdx.files.internal("ui/DifficultyButton/DifficultyHover.png"));
		diffButton[2] = new Texture(Gdx.files.internal("ui/DifficultyButton/DifficultyClicked.png"));
		
		easyButton[0] = new Texture(Gdx.files.internal("ui/DifficultyButton/Easy/EasyStatic.png"));
		easyButton[1] = new Texture(Gdx.files.internal("ui/DifficultyButton/Easy/EasyHover.png"));
		easyButton[2] = new Texture(Gdx.files.internal("ui/DifficultyButton/Easy/EasyClicked.png"));
		
		midButton[0] = new Texture(Gdx.files.internal("ui/DifficultyButton/Mid/MidStatic.png"));
		midButton[1] = new Texture(Gdx.files.internal("ui/DifficultyButton/Mid/MidHover.png"));
		midButton[2] = new Texture(Gdx.files.internal("ui/DifficultyButton/Mid/MidClicked.png"));
		
		hardButton[0] = new Texture(Gdx.files.internal("ui/DifficultyButton/Hard/HardStatic.png"));
		hardButton[1] = new Texture(Gdx.files.internal("ui/DifficultyButton/Hard/HardHover.png"));
		hardButton[2] = new Texture(Gdx.files.internal("ui/DifficultyButton/Hard/HardClicked.png"));
	}
	public void dispose() {
		for(int i =0; i<3;i++) {
			playButton[i].dispose();
			diffButton[i].dispose();
			easyButton[i].dispose();
			midButton[i].dispose();
			hardButton[i].dispose();
		}
        stage.dispose();
	}
}
