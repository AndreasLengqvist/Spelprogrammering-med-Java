import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import view.Input;
import view.View;
import controller.Controller;



public class Init implements GLEventListener {

	private View view;
	private Input input;
	private Controller controller;
	private long previousTime;
	private static int width = 800;
	private static int height = 600;
	
	
	public Init(GLCanvas c) throws Exception{
    	input = new Input();
    	view = new View(width, height, input);
    	controller = new Controller(view);
		
		
    	c.addMouseListener(input);
    	c.addMouseMotionListener(input);
    	c.addKeyListener(input);
	}
	
	
    public static void main(String[] args) throws Exception {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);
        
        Frame frame = new Frame("Project Interstellar");
        frame.setSize(Init.width, Init.height);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(new Init(canvas));

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
	
	
/*
 * Functions from the implemented interface GlEventListener (.
 */
	
	// Display is called each time the canvas needs to be redraw/repainted/redisplayed.
	@Override
    public void display(GLAutoDrawable drawable) {
    	 long currentTime = System.currentTimeMillis();
    	 controller.update((float)((currentTime - previousTime) / 1000.0f), drawable);
         previousTime = currentTime;
	}

	// Called when user exit the program.
	@Override
	public void dispose(GLAutoDrawable drawable) {}

	// Function which JOGL will call ONCE when setting up the graphics information when the program starts up.	 
	@Override
	public void init(GLAutoDrawable drawable) {
		reshape(drawable, 0, 0, width, height);
	}

	// When resizing the window this function is called. Mainly sets the new viewport to the new size.
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    	view.reshape(drawable, x, y, w, h);
    	previousTime = System.currentTimeMillis();
	}
}
