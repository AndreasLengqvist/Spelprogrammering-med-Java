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

	
	public void loadResources() {
		if (texture == null)
			try {
				texture = TextureIO.newTexture(new File("redbox.png"), false);
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

	
	public void drawSquare(GLAutoDrawable drawable, float x, float y, float w, float h, int r, int g, int b) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glBegin(GL2.GL_QUADS);
			gl.glColor3f(r, g, b);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2f(x,      y);
			gl.glTexCoord2f(1, 1);
			gl.glVertex2f(x + w, y);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2f(x + w, y + h);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2f(x,      y + h);
		gl.glEnd();		
	}

	public void drawPlayer(GLAutoDrawable drawable, float x, float y, float w, float h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBindTexture(texture.getTarget(), texture.getTextureObject());

			gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(0, 1);
				gl.glVertex2f(x,      y);
				gl.glTexCoord2f(1, 1);
				gl.glVertex2f(x + w, y);
				gl.glTexCoord2f(1, 0);
				gl.glVertex2f(x + w, y + h);
				gl.glTexCoord2f(0, 0);
				gl.glVertex2f(x,      y + h);
			gl.glEnd();
		
		gl.glDisable(GL.GL_TEXTURE_2D);		
	}

}
