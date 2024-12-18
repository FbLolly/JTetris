package mainPkg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

import gamePkg.Game;
import menuPkg.Menu;
import utilsPkg.KeyHandler;
import utilsPkg.Mouse;

public class JTetris extends JPanel implements Runnable{
	private double drawInterval;
	private double nextDrawTime;
	private double remainingTime;
	private long timer;
	
	private Thread thread;
	private KeyHandler keyHandler;

	private Game game;

	private Menu menu;
	private Mouse mouse;

	private String osName;
	
	public JTetris() {
		this.keyHandler = new KeyHandler();
		
		this.game = new Game();

		this.menu = new Menu();
		this.mouse = new Mouse();

		this.timer = 0;
		
		try {
    		InputStream is = this.getClass().getResourceAsStream("fonts/CaskaydiaCove-Bold.ttf"); //im forced to put it in the same pkg
    		Font f = Font.createFont(Font.TRUETYPE_FONT, is);
    		Font sizedFont = f.deriveFont(30f);
    		this.setFont(sizedFont);
    	}catch (IOException | FontFormatException e) {
    		this.setFont(new Font("serif", Font.BOLD, 30));
    	}

		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(Defines.width, Defines.height));
		this.setSize(new Dimension(Defines.width, Defines.height));
		this.addMouseListener(mouse);
		this.setFocusable(true);
		this.setVisible(true);

		this.osName = System.getProperty("os.name");
		
		this.startGame();
	}
	
	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}
	
	public long getNewTimeAndSleep() {
    	drawInterval = 1000000000/Defines.FPS; //recalculate drawInterval in case the fps changes
		
    	try {
			remainingTime = nextDrawTime - System.nanoTime();
			remainingTime /= 1000000;
    	
			if (remainingTime < 0)
				remainingTime = 0;
			
			Thread.sleep((long)remainingTime);
			nextDrawTime += drawInterval;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	return (long)remainingTime;
    }
	
	@Override
	public void run() {
		drawInterval = 1000000000/Defines.FPS;
    	nextDrawTime = System.nanoTime() + drawInterval;
    	remainingTime = 0;
    	timer = 0;
    	
    	while (thread != null) {
        	getNewTimeAndSleep();
        	
        	update();
    		repaint();
    		
			if (!(this.osName.length() > 7 && this.osName.substring(0, 7).equals("windows"))){
				Toolkit.getDefaultToolkit().sync();
			}
			
    		timer += 1;
    	}
	}
	
	public void update() {
		if (menu.choice == -1){
			mouse.updateMousePos(this);
			menu.tick(mouse);
		}else if (menu.choice == 1){
			System.exit(0);
		}else{
			this.keyHandler.handleKeys(this);

			if (game.tick(this.timer, this.keyHandler)){
				this.menu = new Menu();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		//paint background
		g.setColor(Color.black);
		g.fillRect(0, 0, Defines.width, Defines.height);
		//-

		if (menu.choice == -1){
			this.menu.paintComponent(g);
		}else if (menu.choice != 1) {
			this.game.paintComponent(g);
		}
	}
}
















