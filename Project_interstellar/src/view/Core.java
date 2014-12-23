package view;

import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;



public class Core {
	
	private Texture texture;
	private Texture texture1;
	private Texture texture2;
	private Texture texture3;
	private Texture texture5;
	private Texture texture6;
	private Texture menuBackground;
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

	
	public void loadResources() {
		if (texture1 == null)
			try {
				texture = TextureIO.newTexture(new File("particlesmoke.tga"), false);
				texture1 = TextureIO.newTexture(new File("rocket.png"), false);
				texture2 = TextureIO.newTexture(new File("rocketleft.png"), false);
				texture3 = TextureIO.newTexture(new File("rocketright.png"), false);
				menuBackground = TextureIO.newTexture(new File("menuBackground.png"), false);
				startButton = TextureIO.newTexture(new File("newgame.png"), false);
				startButtonHover = TextureIO.newTexture(new File("newgame_hover.png"), false);
				quitButton = TextureIO.newTexture(new File("quitgame.png"), false);
				quitButtonHover = TextureIO.newTexture(new File("quitgame_hover.png"), false);
				continueButton = TextureIO.newTexture(new File("continue.png"), false);
				continueButtonHover = TextureIO.newTexture(new File("continue_hover.png"), false);
				countdown9 = TextureIO.newTexture(new File("9.png"), false);
				countdown8 = TextureIO.newTexture(new File("8.png"), false);
				countdown7 = TextureIO.newTexture(new File("7.png"), false);
				countdown6 = TextureIO.newTexture(new File("6.png"), false);
				countdown5 = TextureIO.newTexture(new File("5.png"), false);
				countdown4 = TextureIO.newTexture(new File("4.png"), false);
				countdown3 = TextureIO.newTexture(new File("3.png"), false);
				countdown2 = TextureIO.newTexture(new File("2.png"), false);
				countdown1 = TextureIO.newTexture(new File("1.png"), false);
				countdown0 = TextureIO.newTexture(new File("0.png"), false);
				gameInfo = TextureIO.newTexture(new File("game_info.png"), false);
				infoButton = TextureIO.newTexture(new File("info.png"), false);
				earthStart = TextureIO.newTexture(new File("earth.png"), false);
				mars = TextureIO.newTexture(new File("mars.png"), false);
				jupiter = TextureIO.newTexture(new File("jupiter.png"), false);
				texture5 = TextureIO.newTexture(new File("star.png"), false);
				texture6 = TextureIO.newTexture(new File("meteor.png"), false);
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
	
	public void drawMeteor(GLAutoDrawable drawable, float x, float y, float w, float h, float rot) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL_MODELVIEW);
		gl.glPushMatrix();
		gl.glTranslatef(x, y, 0.0f);
		gl.glRotatef(rot, 0f, 0f, 1.0f);
		gl.glTranslatef(-x, -y, -0.0f);
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
		texture1.enable(gl);
		texture1.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			texture1.disable(gl);	
	}
	
	public void drawRocketLeft(GLAutoDrawable drawable, float x, float y, float w, float h, float[] color) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture2.enable(gl);
		texture2.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			texture2.disable(gl);	
	}
	
	public void drawRocketRight(GLAutoDrawable drawable, float x, float y, float w, float h, float[] color) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture3.enable(gl);
		texture3.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor4f(color[0], color[1], color[2], color[3]);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
			texture3.disable(gl);	
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
}