package gamePkg;

import java.awt.Color;
import java.awt.Graphics;

import mainPkg.Defines;
import utilsPkg.KeyHandler;

public class Block {
    public Tile[][] block;
    public Color color;
    private int rotation;
    private int type;

    public Block(){
        this.rotation = 0;
        this.type = (int)(Math.random()*(Defines.amount-1));
        this.color = Defines.colors[this.type];

        block = new Tile[Defines.size][];
        
        for (int i = 0; i < Defines.size; i++){
            block[i] = new Tile[Defines.size];

            for (int ii = 0; ii < Defines.size; ii++){
                block[i][ii] = new Tile(Defines.gridX/2-Defines.size/2+i, ii, this.color);

                block[i][ii].full = Defines.pieces[this.type][0][i][ii];
            }
        }
    }

    private void shiftDown(){
        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                this.block[i][ii].setII(this.block[i][ii].getII()+1);
            }
        }
    }

    private boolean isTouchingDown(Grid grid){
        Tile current;

        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                current = this.block[i][ii];

                if (!current.full){
                    continue;
                }

                if (current.getII() >= Defines.gridY-1 || grid.grid[current.getI()][current.getII()+1].full){
                    grid.printOnSelf(this);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean handleGameOver(Grid grid) {
        for (Tile[] row : this.block){
            for (Tile t : row){
                if (t.getI() < 0 || t.getI() > Defines.gridX-1){
                    continue;
                }

                if (t.full && grid.grid[t.getI()][t.getII()].full){ //means there is a collision between pieces
                    return true;
                }
            }
        }

        return false;
    }

    private boolean safeToRotate(Grid grid){
        int newRotation = this.rotation+1;
        if (newRotation >= 4){
            newRotation = 0;
        }

        boolean current;
        int starti = this.block[0][0].getI(), startii = this.block[0][0].getII();

        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                current = Defines.pieces[this.type][newRotation][i][ii];

                if (!current){
                    continue;
                }

                if (i+starti < 0 || i+starti > Defines.gridX-1){
                    return false;
                }

                if (grid.grid[i+starti][ii+startii].full){
                    return false;
                }
            }
        }

        return true;
    }

    private void handleRotation(KeyHandler kh, Grid grid){
        if (!kh.rotating){
            return;
        }

        if (!safeToRotate(grid)){
            return;
        }

        this.rotation += 1;
        if (this.rotation >= 4)
            this.rotation = 0;

        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                this.block[i][ii].full = false;

                if (Defines.pieces[this.type][this.rotation][i][ii]){
                    this.block[i][ii].full = true;
                }
            }
        }

        kh.rotating = false;
    }

    private void shift(int direction){
        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                this.block[i][ii].setI(this.block[i][ii].getI()+direction);
            }
        }
    }

    private boolean safeToMove(int direction, Grid grid){
        Tile current;

        for (int i = 0; i < Defines.size; i++){
            for (int ii = 0; ii < Defines.size; ii++){
                current = this.block[i][ii];

                if (!current.full){
                    continue;
                }

                if (current.getI()+direction < 0 || current.getI()+direction > Defines.gridX-1){
                    return false;
                }

                if (grid.grid[current.getI()+direction][current.getII()].full){
                    return false;
                }
            }
        }

        return true;
    }

    private void handleMovement(KeyHandler kh, Grid grid){
        if (safeToMove(kh.direction, grid)){
            this.shift(kh.direction);
            kh.direction = 0;
        }
    }

    public boolean unTimedUnMovableTick(Grid grid){
        if (this.isTouchingDown(grid)){
            return true;
        }

        this.shiftDown();
        return false;
    }

    public boolean tick(long timer, Grid grid, KeyHandler kh){
        this.handleRotation(kh, grid);
        this.handleMovement(kh, grid);
        
        if (timer % Defines.waiting == 0){
            if (this.isTouchingDown(grid)){
                return true;
            }
            this.shiftDown();
        }

        return false;
    }

    public void paintComponent(Graphics g){
        for (Tile[] row : this.block){
            for (Tile t : row){
                t.paintComponent(g);
            }
        }
    }
}
