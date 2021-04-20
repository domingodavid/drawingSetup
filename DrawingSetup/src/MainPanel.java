import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener, KeyListener{
	//handles drawing animation
	Timer animationTimer; 
	Ball b;
	
	public void paint(Graphics g) {
		//calling this line ensures the frame is redrawn
		super.paintComponent(g);
		
		//call paint methods of objects or through g.drawRect etc
		b.paint(g);
		
	}
	
	/* constructor for MainPain class */
	public MainPanel() {
		
		//Create a JFrame Object with a title bar text
		JFrame f = new JFrame("Example Drawing");
		
		//Set the size of the window
		f.setSize(800,600); //width and height
		
		//set default action for x button
		//without this, your code will run behind the scenes until
		//you force exit
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add this panel to the JFrame
		//allows connection with "drawing"
		f.add(this);
		f.addKeyListener(this);
		
		
		
		//setup animation timer
		animationTimer = new Timer(16, this);
		
		//do not forget to start the timer
		animationTimer.start();
		
		//instantiate the rest of the instance variables
		b = new Ball();
		
		
		f.setVisible(true);
	}

	/* this method is invoked/called by the titmer */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//call the frame to refresh
		//recall that actitonPerformed is called by the
		//timer object every 16ms
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		
		switch(arg0.getKeyCode()) {
		//if keycode is 'd' key
		case 68:
			b.moveRight();
			break;
			
		case 65:
			System.out.println("stuff for left key using a");
			break;
			
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		b.stop();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
