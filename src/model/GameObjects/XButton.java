package model.GameObjects;

import mapObjects.Grass;
import control.ProgramController;
import mapObjects.Tree;
import model.framework.GraphicalObject;
import view.framework.DrawTool;

import java.awt.event.MouseEvent;

public class XButton extends GraphicalObject {

    //Atribute
    private int width = 40;
    private int heigth = 40;
    private boolean klicked = false;
    private boolean visible = false;
    private ProgramController pc;


    //Referenzen


    public XButton(double x, double y, ProgramController pc) {
        this.x = x;
        this.y = y;
        this.pc = pc;
        createAndSetNewImage("assets/images/ix.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        if(visible)drawTool.drawImage(getMyImage(), x, y);
    }

    public void mouseReleased(MouseEvent e) {
        if(klicked) {
            if (visible) {
                if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + heigth) {
                    /*for (int i = 0; i < grasses.length; i++) {
                        for (int f = 0; f < grasses[0].length; f++) {
                            if (grasses[i][f] != null) {
                                grasses[i][f].setAxeable(true);
                            }
                        }
                    }*/


                    pc.removeButtons(true);
                    pc.setShop(false);

                }
            }
        }
        klicked = !klicked;
    }
    public void setVisibility(boolean b){
        visible = b;
    }
}

