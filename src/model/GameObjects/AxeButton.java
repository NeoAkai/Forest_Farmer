package model.GameObjects;

import mapObjects.Grass;
import control.ProgramController;
import mapObjects.Tree;
import model.framework.GraphicalObject;
import view.framework.DrawTool;

import java.awt.event.MouseEvent;

public class AxeButton extends GraphicalObject {

    //Atribute
    private int width = 40;
    private int heigth = 40;
    private Grass[][] grasses;
    private boolean klicked = false;
    private boolean visible = true;
    private ProgramController pc;
    private boolean axing;

    //Referenzen


    public AxeButton(double x, double y, Grass[][] grasses, ProgramController pc) {
        this.x = x;
        this.y = y;
        this.pc = pc;
        this.grasses = grasses;
        createAndSetNewImage("assets/images/axeButton.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(getMyImage(), x, y);
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
                    x = x + 50;

                    createAndSetNewImage("assets/images/ix.png");
                    pc.removeButtons(false);
                    axing = true;
                }
            } else if (!visible) {

                if (e.getX() > x && e.getX() < x + 40 && e.getY() > y && e.getY() < y + 40) {
                    /*for (int i = 0; i < grasses.length; i++) {
                        for (int f = 0; f < grasses[0].length; f++) {
                            if (grasses[i][f] != null) {
                                grasses[i][f].real(false);
                            }
                        }
                    }*/
                    x = x - 50;

                    createAndSetNewImage("assets/images/axeButton.png");
                    pc.removeButtons(true);
                    axing = false;
                }else{
                    for (int i = 0; i < grasses.length; i++) {
                        for (int f = 0; f < grasses[0].length; f++) {
                            if(grasses[i][f] != null) {
                                if (grasses[i][f].getCoveringObject() != null) {
                                    if (grasses[i][f].getCoveringObject().getHitbox().contains(e.getPoint())) {
                                        if(!((Tree)grasses[i][f].getCoveringObject()).isParasiten()) pc.addWood((int) (Math.random() * 12 + 8));
                                        pc.removeTree((Tree) grasses[i][f].getCoveringObject());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        klicked = !klicked;
    }
    public void setVisibility(boolean b){
        visible = b;
    }
}

