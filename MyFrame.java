import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener{

	static Draw drawing = new Draw();

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveDown();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_A){
			drawing.attack();
			System.out.println("attack");
		}

		else if(e.getKeyCode() == KeyEvent.VK_D){
			drawing.dead();
			System.out.println("dead");
		}

		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.idle();
			System.out.println("idle");
		}
    }


    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }
	
	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(1160,772);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(drawing);
		gameFrame.addKeyListener(gameFrame);
	}
}