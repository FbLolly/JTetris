package gamePkg;

import java.awt.Color;
import java.awt.Graphics;

import mainPkg.Defines;

public class Grid {
    public Tile[][] grid;

    public Grid(){
        this.grid = new Tile[Defines.gridX][];

        for (int i = 0; i < Defines.gridX; i++){
            this.grid[i] = new Tile[Defines.gridY];

            for (int ii = 0; ii < Defines.gridY; ii++){
                this.grid[i][ii] = new Tile(i, ii, Color.black);
            }
        }
    }

    private void shiftDown(int row_deleate){
        //to fix

        for (int ii = row_deleate; ii > 0; ii--){
            for (int i = 0; i < Defines.gridX; i++){
                this.grid[i][ii].full = this.grid[i][ii-1].full;
                this.grid[i][ii].color = this.grid[i][ii-1].color;
            }
        }
    }

    public int tick(long timer){
        if (timer % Defines.waiting != 0)
            return 0;

        boolean rowFilled = true;
        int ret = 0;

        for (int ii = 0; ii < Defines.gridY; ii++){
            rowFilled = true;

            for (int i = 0; i < Defines.gridX && rowFilled; i++){
                if (!this.grid[i][ii].full){
                    rowFilled = false;
                }
            }

            if (rowFilled){
                ret += 20;
                shiftDown(ii);
            }
        }

        ret *= (ret/20);

        return ret;
    }

    public void printOnSelf(Block block){
        Tile current;
        
        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                current = block.block[i][ii];

                if (current.getI() < 0 || current.getI() >= Defines.gridX
                   || current.getII() < 0 || current.getII() >= Defines.gridY){
                    continue;
                }

                if (!current.full)
                    continue;
                this.grid[current.getI()][current.getII()].full = true;
                this.grid[current.getI()][current.getII()].color = current.color;
            }
        }
    }

    public void paintComponent(Graphics g){
        for (Tile[] row : grid){
            for (Tile t : row){
                t.paintComponent(g);
            }
        }
    }
}
