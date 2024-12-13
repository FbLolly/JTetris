package gamePkg;

import java.awt.Color;
import java.awt.Graphics;

import mainPkg.Defines;

public class Tile {
    private int x, y;
    
    private int i, ii; //they are private couse i need custom getters and setters for these
    public Color color;

    public boolean full;

    public Tile(){}
    public Tile(int i, int ii, Color color){
        
        this.i = i;
        this.ii = ii;

        this.x = this.i * Defines.tileSize;
        this.y = this.ii * Defines.tileSize;


        this.color = color;
        this.full = false;
    }

    public void paintComponent(Graphics g){
        if (this.full){
            g.setColor(color);

            g.fillRect(this.x, this.y, Defines.tileSize, Defines.tileSize);
        }
    }

    public void paintComponent(Graphics g, Color c){
        g.setColor(c);
        g.fillRect(this.x, this.y, Defines.tileSize, Defines.tileSize);
    }

    public void setI(int i){
        this.i = i;
        this.x = i * Defines.tileSize;
    }

    public int getI(){
        return this.i;
    }

    public void setII(int ii){
        this.ii = ii;
        this.y = ii * Defines.tileSize;
    }

    public int getII(){
        return this.ii;
    }
}
