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
	
	private float i = 0;
	private Texture texture;
	private int cole;

	
	public void loadResources() {
		if (texture == null)
			try {
				texture = TextureIO.newTexture(new File("explosion.png"), false);
			} catch (GLException | IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
	}

	
	public void clearScreen(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
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

	
	public void drawBox(GLAutoDrawable drawable, float x, float y, float w, float h, int r, int g, int b) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(0.211f, 0.215f, 0.18f);
			gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
			gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
			gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
			gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
		gl.glEnd();	
	}

	public void drawSpark(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture.enable(gl);
		texture.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(1, 1, 1);
				gl.glTexCoord2f(0, 1);	gl.glVertex2f(x, y);
				gl.glTexCoord2f(1, 1);	gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);	gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);	gl.glVertex2f(x, y + h);
			gl.glEnd();
		texture.disable(gl);	
	}
	
	public void drawSmoke(GLAutoDrawable drawable, float x, float y, float w, float h, int frame) {
		GL2 gl = drawable.getGL().getGL2();
		
		
//		gl.glTexCoord2f(0.0f, 1.0f);	gl.glVertex3f(x, y, 0.0f);
//		gl.glTexCoord2f(0.25f, 1.0f);	gl.glVertex3f(x + w, y, 0.0f);
//		gl.glTexCoord2f(0.25f, 0.833f);	gl.glVertex3f(x + w, y + h, 0.0f);
//		gl.glTexCoord2f(0.0f, 0.8333f);	gl.glVertex3f(x, y + h, 0.0f);
		
		float col = frame % 4;
		float row = frame / 4;
		
		//System.out.println("COOOOOL     -   "+(col));
		//System.out.println("ROOOOOW     -   "+row/8);
		
		row = row / 8;
		row = 1 - row;
		
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		texture.enable(gl);
		texture.bind(gl);
        gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE); 
			gl.glBegin(GL2.GL_QUADS);
			gl.glTexCoord2f(col/4, row);						gl.glVertex3f(x, y, 0.0f);
			gl.glTexCoord2f((1+col)/4, row);					gl.glVertex3f(x + w, y, 0.0f);
			gl.glTexCoord2f((1+col)/4, 0.125f+row);				gl.glVertex3f(x + w, y + h, 0.0f);
			gl.glTexCoord2f(col/4, 0.125f+row);					gl.glVertex3f(x, y + h, 0.0f);
			gl.glEnd();
		texture.disable(gl);	
	}
}