package computer_graphics_6;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class ControlListener implements KeyListener, MouseMotionListener, MouseListener{
	private Vector3 pos;
	private int x, y, xl, yl;
	JFrame frame;
	public ControlListener(Vector3 pos, JFrame frame) {
		this.pos = pos;
		this.frame = frame;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 's')
		{
			Main.pos = Main.pos.add(Vector3.forward());
		}else
		if(e.getKeyChar() == 'w')
		{
			Main.pos = Main.pos.add(Vector3.forward().multi(-1));
		}else
		if(e.getKeyChar() == 'd')
		{
			Main.pos = Main.pos.add(Vector3.right());
		}else
		if(e.getKeyChar() == 'a')
		{
			Main.pos = Main.pos.add(Vector3.right().multi(-1));
			
		}else if(e.getKeyCode() == 37)//left
		{
			//Main.view = Main.view.HorizonRotate(-(float)Math.PI/60);
			//Main.view = Main.view.setRotation((float) angle[0] - (float)Math.PI/60f, angle[1]);
			Main.view = Main.view.Rotate((float) (-Math.PI/60), 0);
		}
		else 
		if(e.getKeyCode() == 38)//up
		{
			//Main.view = Main.view.add(Vector3.up().multi(0.3f)).normalize();
			//Main.view = Main.view.setRotation(angle[0], angle[1] + (float)Math.PI/60f);
			Main.view = Main.view.Rotate(0, (float) (Math.PI/60));
		}
		else
		if(e.getKeyCode() == 39)//right
		{
			//Main.view = Main.view.HorizonRotate((float)Math.PI/60);
			//Main.view = Main.view.setRotation(angle[0] + (float)Math.PI/60f, angle[1]);
			Main.view = Main.view.Rotate((float) (Math.PI/60), 0);
		}else
		if(e.getKeyCode() == 40)//down
		{
			//Main.view = Main.view.add(Vector3.up().multi(-0.3f)).normalize();
			//Main.view = Main.view.setRotation(angle[0], angle[1] - (float)Math.PI/60f);
			Main.view = Main.view.Rotate(0, (float) (-Math.PI/60));
		}else
		if(e.getKeyChar() == 'r')//above
		{
			Main.pos = Main.pos.add(Vector3.up());
		}else
		if(e.getKeyChar() == 'f')//below
		{
			Main.pos = Main.pos.add(Vector3.up().multi(-1f));
		}else
		{return;}
		
		frame.repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		int offsetX = x - xl;
		int offsetY = y - yl;
//		System.out.println(offsetX+" "+offsetY);
		Main.view = Main.view.Rotate(offsetX*(float)Math.PI/90, -offsetY*(float)Math.PI/90);
		xl = x;
		yl = y;
		frame.repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		xl = e.getX();
		yl = e.getY();
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
