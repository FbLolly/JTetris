package menuPkg;

import java.awt.Graphics;

import utilsPkg.Mouse;

public class Menu {
    public Buttons buttons;
    public int choice;

    public Menu(){
        this.choice = -1;

        buttons = new Buttons();
    }

    public void tick(Mouse mouse){
        buttons.tick(mouse);

        this.choice = buttons.somethingClicked;
    }

    public void paintComponent(Graphics g){
        buttons.paintComponent(g);
    }
}
