package menuPkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import mainPkg.Defines;
import utilsPkg.Button;
import utilsPkg.Mouse;

public class Buttons {
    public Button[] btns;
    public int somethingClicked;

    public Buttons(){
        btns = new Button[Defines.buttonNum];
        this.somethingClicked = -1;

        for (int i = 0; i < Defines.buttonNum; i++){
            btns[i] = new Button(Defines.width/2-Defines.buttonWidth/2, (Defines.height/Defines.buttonNum)*i+(Defines.height/Defines.buttonNum/2),
                                Defines.buttonWidth, Defines.buttonHeight, Defines.rosePurple,
                                Color.white, Defines.buttonText[i]);
        }
    }

    public void tick(Mouse mouse){
        for (int i = 0; i < Defines.buttonNum; i++){
            this.btns[i].tick(mouse.clicked, new Point(mouse.x, mouse.y));

            if (this.btns[i].active){
                somethingClicked = i;
                this.btns[i].active = false;
                return;
            }
        }
    }

    public void paintComponent(Graphics g){
        for (Button b : btns){
            b.paintComponent((Graphics2D) g);
        }
    }
}
