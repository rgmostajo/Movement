import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundPic;
	private URL resource = getClass().getResource("walk3.png");

	//circle's position
	public int x = 30;
	public int y = 30;

	//animation states
	public int state = 0;
	

	public Draw(){
		try{
			image = ImageIO.read(resource);
			backgroundPic = ImageIO.read(getClass().getResource("backgroundcem3.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		if(state == 0){
			resource = getClass().getResource("walk0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("walk1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("walk2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("walk3.png");
			state = 0;
		}
		else if(state == 4){
			resource = getClass().getResource("walk4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("walk5.png");
		}
		else if(state == 6){
			resource = getClass().getResource("walk6.png");
		}
		else if(state == 7){
			resource = getClass().getResource("walk7.png");
		}
		else if(state == 8){
			resource = getClass().getResource("walk8.png");
		}
		else if(state == 9){
			resource = getClass().getResource("walk9.png");
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("attack/attack0.png");
						}
						else{
							resource = getClass().getResource("attack/attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void deadAnimation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 12; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("dead/dead0.png");
						}
						else{
							resource = getClass().getResource("dead/dead"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
	}

	public void idleAnimation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 15; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("idle/idle0.png");
						}
						else{
							resource = getClass().getResource("idle/idle"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
	}

	public void idle(){
		idleAnimation();
	}

	public void dead(){
		deadAnimation();
	}


	public void attack(){
		attackAnimation();
	}

	public void moveRight(){
		x = x + 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveLeft(){
		x = x - 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveDown(){
		y = y + 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveUp(){
		y = y - 5;
		state++;
		repaint();
		reloadImage();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundPic, 0, 0, this);
		g.drawImage(image, x, y, this);
	}
}