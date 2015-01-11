package view;

import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;



public class Core {
	
	private Texture texture;
	private Texture ball;
	private Texture rocket;
	private Texture rocketleftwing;
	private Texture rocketrightwing;
	private Texture nextlevel;
	private Texture intoinfinity;
	private Texture texture5;
	private Texture texture6;
	private Texture menuBackground;
	private Texture gameoverBackground;
	private Texture startButton;
	private Texture startButtonHover;
	private Texture quitButton;
	private Texture quitButtonHover;
	private Texture gameInfo;
	private Texture continueButton;
	private Texture continueButtonHover;
	private Texture countdown9;
	private Texture countdown8;
	private Texture countdown7;
	private Texture countdown6;
	private Texture countdown5;
	private Texture countdown4;
	private Texture countdown3;
	private Texture countdown2;
	private Texture countdown1;
	private Texture countdown0;
	private Texture earthStart;
	private Texture infoButton;
	private Texture mars;
	private Texture jupiter;
	private Texture saturnus;
	private Texture uranus;
	private Texture neptunus;
	private Texture pluto;
	private Texture explosion;
	private Texture spark;
	private Texture gameover;
	private Texture redgameover;
	private Texture restartButton;
	private Texture restartButtonHover;
	private Texture repairkit;

	/*
	 * To much to comment.
	 * Basically just methods for draw each object in the game. Also handles the sound effects.
	 */
	public void loadResources() {
		if (rocket == null)
			try {
				ball = TextureIO.newTexture(this.getClass().getResourceAsStream("/ball.png"), false, "png");
				texture = TextureIO.newTexture(this.getClass().getResourceAsStream("/particlesmoke.tga"), false, "tga");
				rocket = TextureIO.newTexture(this.getClass().getResourceAsStream("/rocket.png"), false, "png");
				rocketleftwing = TextureIO.newTexture(this.getClass().getResourceAsStream("/rocketleftwing.png"), false, "png");
				rocketrightwing = TextureIO.newTexture(this.getClass().getResourceAsStream("/rocketrightwing.png"), false, "png");
				nextlevel = TextureIO.newTexture(this.getClass().getResourceAsStream("/nextlevel.png"), false, "png");
				intoinfinity = TextureIO.newTexture(this.getClass().getResourceAsStream("/intoinfinity.png"), false, "png");
				menuBackground = TextureIO.newTexture(this.getClass().getResourceAsStream("/menuBackground.png"), false, "png");
				gameoverBackground = TextureIO.newTexture(this.getClass().getResourceAsStream("/gameoverBackground.png"), false, "png");
				startButton = TextureIO.newTexture(this.getClass().getResourceAsStream("/startgame.png"), false, "png");
				restartButton = TextureIO.newTexture(this.getClass().getResourceAsStream("/restart.png"), false, "png");
				startButtonHover = TextureIO.newTexture(this.getClass().getResourceAsStream("/startgame_hover.png"), false, "png");
				restartButtonHover = TextureIO.newTexture(this.getClass().getResourceAsStream("/restart_hover.png"), false, "png");
				quitButton = TextureIO.newTexture(this.getClass().getResourceAsStream("/quitgame.png"), false, "png");
				quitButtonHover = TextureIO.newTexture(this.getClass().getResourceAsStream("/quitgame_hover.png"), false, "png");
				continueButton = TextureIO.newTexture(this.getClass().getResourceAsStream("/continue.png"), false, "png");
				continueButtonHover = TextureIO.newTexture(this.getClass().getResourceAsStream("/continue_hover.png"), false, "png");
				countdown9 = TextureIO.newTexture(this.getClass().getResourceAsStream("/9.png"), false, "png");
				countdown8 = TextureIO.newTexture(this.getClass().getResourceAsStream("/8.png"), false, "png");
				countdown7 = TextureIO.newTexture(this.getClass().getResourceAsStream("/7.png"), false, "png");
				countdown6 = TextureIO.newTexture(this.getClass().getResourceAsStream("/6.png"), false, "png");
				countdown5 = TextureIO.newTexture(this.getClass().getResourceAsStream("/5.png"), false, "png");
				countdown4 = TextureIO.newTexture(this.getClass().getResourceAsStream("/4.png"), false, "png");
				countdown3 = TextureIO.newTexture(this.getClass().getResourceAsStream("/3.png"), false, "png");
				countdown2 = TextureIO.newTexture(this.getClass().getResourceAsStream("/2.png"), false, "png");
				countdown1 = TextureIO.newTexture(this.getClass().getResourceAsStream("/1.png"), false, "png");
				countdown0 = TextureIO.newTexture(this.getClass().getResourceAsStream("/0.png"), false, "png");
				gameInfo = TextureIO.newTexture(this.getClass().getResourceAsStream("/game_info.png"), false, "png");
				infoButton = TextureIO.newTexture(this.getClass().getResourceAsStream("/info.png"), false, "png");
				earthStart = TextureIO.newTexture(this.getClass().getResourceAsStream("/earth.png"), false, "png");
				mars = TextureIO.newTexture(this.getClass().getResourceAsStream("/mars.png"), false, "png");
				jupiter = TextureIO.newTexture(this.getClass().getResourceAsStream("/jupiter.png"), false, "png");
				saturnus = TextureIO.newTexture(this.getClass().getResourceAsStream("/saturnus.png"), false, "png");
				uranus = TextureIO.newTexture(this.getClass().getResourceAsStream("/uranus.png"), false, "png");
				neptunus = TextureIO.newTexture(this.getClass().getResourceAsStream("/neptunus.png"), false, "png");
				pluto = TextureIO.newTexture(this.getClass().getResourceAsStream("/pluto.png"), false, "png");
				texture5 = TextureIO.newTexture(this.getClass().getResourceAsStream("/star.png"), false, "png");
				texture6 = TextureIO.newTexture(this.getClass().getResourceAsStream("/meteor.png"), false, "png");
				explosion = TextureIO.newTexture(this.getClass().getResourceAsStream("/explosion.png"), false, "png");
				spark = TextureIO.newTexture(this.getClass().getResourceAsStream("/spark.png"), false, "png");
				gameover = TextureIO.newTexture(this.getClass().getResourceAsStream("/gameover.png"), false, "png");
				redgameover = TextureIO.newTexture(this.getClass().getResourceAsStream("/gameover_red.png"), false, "png");
				repairkit = TextureIO.newTexture(this.getClass().getResourceAsStream("/repairkit.png"), false, "png");
			} catch (GLException | IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
	}
	
	public void clearScreen(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glClearColor(0, 0, 0, 0);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
   	 	GL2 gl = drawable.getGL().getGL2();
        
   	 	GLU glu = GLU.createGLU(gl);

        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();      
        glu.gluOrtho2D (0.0, w, h, 0);

        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity();
        		
	}
	
	public void drawBall(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		ball.enable(gl);
		ball.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			ball.disable(gl);	
	}
	
	public void drawMenuBackground(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		menuBackground.enable(gl);
		menuBackground.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			menuBackground.disable(gl);	
	}
	
	public void drawGameOverBackground(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		gameoverBackground.enable(gl);
		gameoverBackground.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			gameoverBackground.disable(gl);	
	}
	
	public void drawStartButton(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		startButton.enable(gl);
		startButton.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			startButton.disable(gl);	
	}
	
	public void drawStartButtonHover(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		startButtonHover.enable(gl);
		startButtonHover.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			startButtonHover.disable(gl);	
	}
	
	public void drawQuitButton(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		quitButton.enable(gl);
		quitButton.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			quitButton.disable(gl);	
	}
	
	public void drawReStartButton(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		restartButton.enable(gl);
		restartButton.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			restartButton.disable(gl);	
	}
	
	public void drawReStartButtonHover(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		restartButtonHover.enable(gl);
		restartButtonHover.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			restartButtonHover.disable(gl);	
	}
	
	public void drawQuitButtonHover(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		quitButtonHover.enable(gl);
		quitButtonHover.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			quitButtonHover.disable(gl);	
	}
	
	public void drawContinueButton(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		continueButton.enable(gl);
		continueButton.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			continueButton.disable(gl);	
	}
	
	public void drawContinueButtonHover(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		continueButtonHover.enable(gl);
		continueButtonHover.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			continueButtonHover.disable(gl);	
	}
	
	public void drawInfoButton(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		infoButton.enable(gl);
		infoButton.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			infoButton.disable(gl);	
	}
	
	
	public void drawGameInfo(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		gameInfo.enable(gl);
		gameInfo.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			gameInfo.disable(gl);	
	}
	
	
	public void drawCountDown9(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown9.enable(gl);
		countdown9.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown9.disable(gl);	
	}
	
	
	public void drawCountDown8(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown8.enable(gl);
		countdown8.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown8.disable(gl);	
	}
	
	
	public void drawCountDown7(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown7.enable(gl);
		countdown7.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown7.disable(gl);	
	}
	
	
	public void drawCountDown6(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown6.enable(gl);
		countdown6.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown6.disable(gl);	
	}
	
	
	public void drawCountDown5(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown5.enable(gl);
		countdown5.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown5.disable(gl);	
	}
	
	
	public void drawCountDown4(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown4.enable(gl);
		countdown4.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown4.disable(gl);	
	}
	
	public void drawCountDown3(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown3.enable(gl);
		countdown3.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown3.disable(gl);	
	}
	
	public void drawCountDown2(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown2.enable(gl);
		countdown2.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown1.disable(gl);	
	}
	
	public void drawCountDown1(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown1.enable(gl);
		countdown1.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown1.disable(gl);	
	}
	
	public void drawCountDown0(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		countdown0.enable(gl);
		countdown0.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			countdown0.disable(gl);	
	}
	
	public void drawStar(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture5.enable(gl);
		texture5.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			texture5.disable(gl);	
	}
	
	public void drawMeteor(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
//		gl.glMatrixMode(GL_MODELVIEW);
//		gl.glPushMatrix();
//		gl.glTranslatef(x, y, 0.0f);
//		gl.glRotatef(rot, 0f, 0f, 1.0f);
//		gl.glTranslatef(-x, -y, -0.0f);
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture6.enable(gl);
		texture6.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			texture6.disable(gl);
		gl.glPopMatrix();
	}
	
	public void drawRocket(GLAutoDrawable drawable, float x, float y, float w, float h, float[] color) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		rocket.enable(gl);
		rocket.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			rocket.disable(gl);	
	}
	
	public void drawRocketRightWing(GLAutoDrawable drawable, float x, float y, float w, float h, float[] color) {
		GL2 gl = drawable.getGL().getGL2();

		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		rocketrightwing.enable(gl);
		rocketrightwing.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			rocketrightwing.disable(gl);	
	}
	
	public void drawRocketLeftWing(GLAutoDrawable drawable, float x, float y, float w, float h, float[] color) {
		GL2 gl = drawable.getGL().getGL2();

		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		rocketleftwing.enable(gl);
		rocketleftwing.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			rocketleftwing.disable(gl);	
	}
	
	public void drawSmoke(GLAutoDrawable drawable, float x, float y, float w, float h, float color[]) {
		GL2 gl = drawable.getGL().getGL2();
		

		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture.enable(gl);
		texture.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			gl.glPopMatrix(); // Pop the old matrix without the transformations.
		texture.disable(gl);	
	}
	
	
	public void drawEarth(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		earthStart.enable(gl);
		earthStart.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			earthStart.disable(gl);	
	}
		
	public void drawMars(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		mars.enable(gl);
		mars.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			mars.disable(gl);	
	}
	
	public void drawJupiter(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		jupiter.enable(gl);
		jupiter.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			jupiter.disable(gl);	
	}
	
	public void drawSaturnus(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		saturnus.enable(gl);
		saturnus.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			saturnus.disable(gl);	
	}
	
	public void drawUranus(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		uranus.enable(gl);
		uranus.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			uranus.disable(gl);	
	}
	
	public void drawNeptunus(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		neptunus.enable(gl);
		neptunus.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			neptunus.disable(gl);	
	}
	
	public void drawPluto(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		pluto.enable(gl);
		pluto.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			pluto.disable(gl);	
	}
	
	public void drawExplosion(GLAutoDrawable drawable, float x, float y, float w, float h, int frame) {
		GL2 gl = drawable.getGL().getGL2();
		
		float col = frame % 4;
		float row = frame / 4;
		
		row = row / 8;
		row = 1 - row;
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		explosion.enable(gl);
		explosion.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(col/4, row);						gl.glVertex3f(x, y, 0.0f);
			gl.glTexCoord2f((1+col)/4, row);					gl.glVertex3f(x + w, y, 0.0f);
			gl.glTexCoord2f((1+col)/4, 0.125f+row);				gl.glVertex3f(x + w, y + h, 0.0f);
			gl.glTexCoord2f(col/4, 0.125f+row);					gl.glVertex3f(x, y + h, 0.0f);
			gl.glEnd();
			explosion.disable(gl);	
	}
	
	public void drawSpark(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		spark.enable(gl);
		spark.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
		spark.disable(gl);	
	}
	
	public void drawGameOver(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gameover.enable(gl);
		gameover.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
		gameover.disable(gl);	
	}
	
	public void drawNextLevel(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		nextlevel.enable(gl);
		nextlevel.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			nextlevel.disable(gl);	
	}
	
	public void drawIntoInfinity(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		intoinfinity.enable(gl);
		intoinfinity.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			intoinfinity.disable(gl);	
	}
	
	public void drawRedGameOver(GLAutoDrawable drawable, float x, float y, float w, float h, float fade) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		redgameover.enable(gl);
		redgameover.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(1.0f, 1.0f, 1.0f, fade);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
		redgameover.disable(gl);	
	}
	
	public void drawRepairKit(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		repairkit.enable(gl);
		repairkit.bind(gl);
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
		repairkit.disable(gl);	
	}
	
	public void playRocketDestroyed(){
		try {
		    InputStream is = this.getClass().getResourceAsStream("/explode.wav");  
		 
		    AudioStream audioStream = new AudioStream(is);
		 
		    AudioPlayer.player.start(audioStream);
		} catch (GLException | IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void playWingDestroyed(){
		try {
		    InputStream is = this.getClass().getResourceAsStream("/winggone.wav");  
		 
		    AudioStream audioStream = new AudioStream(is);
		 
		    AudioPlayer.player.start(audioStream);
		} catch (GLException | IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void playRepair(){
		try {
		    InputStream is = this.getClass().getResourceAsStream("/repair.wav");  

		    AudioStream audioStream = new AudioStream(is);
		    AudioPlayer.player.start(audioStream);
		} catch (GLException | IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}