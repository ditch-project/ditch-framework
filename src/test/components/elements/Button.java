package test.components.elements;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* THERE WILL BE TWO MOUSE TRACKING VARIABLES, ONE FOR CHECKING IF THE MOUSE MOVED AT ALL, AND A SECOND ONE TRACKING
* CLICKS.  THIS IS DUE TO THAT CLICKING DOES NOT ACTIVATE THE MOUSE MOVED VARIABLE, SO THERE NEEDS TO BE A SECOND
* COPY BEING TRACKED DUE TO INCONSISTENCIES.
*
*
* */

public class Button extends MouseAdapter {
    //GENERAL BUTTON SPECIFICATIONS
    private int x;
    private int y;
    private int width;
    private int height;

    //GLOBAL MOUSE VARIABLES

    public Button(){

    }

    //explanation: have two methods, check if mouse is over, and check if mouse is pressed
    //if the mouse is pressed, it will check where ever the mouse has been pressed, and if it is over

    public void mousePressed(MouseEvent e) {
        //mouse position
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx, my, 210, 150, 200, 64)) {
            //do something that will affect something at some point lol
        }
    }

    public void mouseReleased(MouseEvent e) {}

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height)
                return true;
            return false;
        }
        return false;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", 1, 50);
        g.setColor(Color.white);
        g.setFont(fnt);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 270, 190);
    }
}