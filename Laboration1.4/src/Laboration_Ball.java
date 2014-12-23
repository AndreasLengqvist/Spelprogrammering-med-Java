

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL2;
import static javax.media.opengl.GL2.*;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import view.View;

import model.BallSimulation;


import com.jogamp.opengl.util.FPSAnimator;

import controller.Controller;


public class Laboration_Ball implements GLEventListener  {
	private BallSimulation ballsimulation;
	private View view;
	private Controller controller;
	private long previousTime;
	
	static int width = 400;
	static int height = 800;

    
    public Laboration_Ball(GLCanvas c) throws Exception {
    	ballsimulation = new BallSimulation();
    	view = new View(ballsimulation, width, height);
    	
    	controller = new Controller(ballsimulation, view);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    	long currentTime = System.currentTimeMillis();
    	controller.update((float)((currentTime - previousTime) / 1000.0f), drawable);
        
        
        previousTime = currentTime;
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    	reshape(drawable, 0, 0 , width, height);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    	view.reshape(drawable, x, y, w, h);
    	previousTime = System.currentTimeMillis();
    }
    
    public static void main(String[] args) throws Exception {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);
        
        Frame frame = new Frame("Laboration 1.4");
        frame.setSize(Laboration_Ball.width, Laboration_Ball.height);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new Laboration_Ball(canvas));

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
}
