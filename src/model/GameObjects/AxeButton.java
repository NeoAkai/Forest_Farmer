package model.GameObjects;

import mapObjects.Tree;
import control.ProgramController;
import model.framework.GraphicalObject;
import view.framework.DrawTool;

import java.awt.event.MouseEvent;

public class AxeButton extends GraphicalObject {

    //Atribute
    private int width = 150;
    private int heigth = 150;
    private Tree[][] trees;
    private boolean klicked = false;
    private boolean visible = true;
    private ProgramController pc;

    //Referenzen


    public AxeButton(double x, double y, Tree[][] trees, ProgramController pc) {
        this.x = x;
        this.y = y;
        this.pc = pc;
        this.trees = trees;
        createAndSetNewImage("assets/images/axeButton.png");

    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(getMyImage(), x, y);
    }

    public void mouseReleased(MouseEvent e) {
        if (visible) {
            if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + heigth) {
                if (!klicked) {
                    for (int i = 0; i < trees.length; i++) {
                        for (int f = 0; f < trees[0].length; f++) {
                            if (trees[i][f] != null) {
                                trees[i][f].setAxeable(true);
                            }
                        }
                    }
                    x = x - 150;
                    y = y +50;
                    createAndSetNewImage("assets/images/ix.png");
                    pc.removeButtons(false);

                }
            }
        }else if(!visible){

            if (e.getX() > x && e.getX() < x + 75 && e.getY() > y && e.getY() < y + 75) {
                if (!klicked) {
                    for (int i = 0; i < trees.length; i++) {
                        for (int f = 0; f < trees[0].length; f++) {
                            if (trees[i][f] != null) {
                                trees[i][f].real(false);
                            }
                        }
                    }
                    x = x + 150;
                    y = y - 50;
                    createAndSetNewImage("assets/images/axeButton.png");
                    pc.removeButtons(true);
                }
            }
        }
        klicked = !klicked;
    }
    public void setVisibility(boolean b){
        visible = b;
    }
}

