package model.GameObjects;

import model.framework.GraphicalObject;
import view.framework.DrawTool;

import java.awt.event.MouseEvent;

public class shopButton extends GraphicalObject {

    //Atribute
    private int width = 150;
    private int heigth = 150;

    private boolean klicked = false;
    private boolean visible = true;

    //Referenzen


    public shopButton(double x, double y) {
        this.x = x;
        this.y = y;

        createAndSetNewImage("assets/images/shopButton.png");

    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        if(visible)drawTool.drawImage(getMyImage(), x, y);
    }

    public void mouseReleased(MouseEvent e) {
        if (visible) {
            if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + heigth) {
                if (!klicked) {

                }

            }
        }
        klicked = !klicked;
    }
    public void setVisibility(boolean b){
        visible = b;
    }
}


