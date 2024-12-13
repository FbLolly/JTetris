package gamePkg;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import mainPkg.Defines;
import utilsPkg.KeyHandler;

public class Game {
    private Block block;
    private Grid grid;
    private int score;

    private int textX;

    public Game(){
        this.block = new Block();
        this.grid = new Grid();

        this.score = 0;
    }

    public boolean tick(long timer, KeyHandler keyHandler){ //im passing menu to reset it on gameover
        if (this.block.tick(timer, grid, keyHandler)){
            this.block = new Block();
            this.score += 1;
        }

        if (this.block.handleGameOver(grid) || keyHandler.pressedEscape){
            grid = new Grid();
            block = new Block();
            this.score = 0;
            keyHandler.pressedEscape = false;

            return true;
        }

        this.score += this.grid.tick(timer);
        return false;
    }

    public void paintComponent(Graphics g){
        this.grid.paintComponent(g);
		this.block.paintComponent(g);

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        
        String text = ""+this.score;

		FontMetrics metrics = g.getFontMetrics(g.getFont());
		int textWidth = metrics.stringWidth(text);
		this.textX = Defines.width/2 - textWidth/2;

        g.setColor(Color.LIGHT_GRAY);
        g.drawString(text, this.textX, 40);
    }
}
