package control;

import model.GameObjects.*;
import model.MapBuildingObject.*;
import mapObjects.*;
import control.framework.UIController;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    // Attribute

    // Referenzen
    private UIController uiController;  // diese Referenz soll auf ein Objekt der Klasse uiController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private MapBuilder mapBuilder;
    private Grass[][] grass;
    private Tree[][] tree;
    private Cat cat;
    private UserInterface userInterface;
    private AxeButton axeButton;
    private inventoryButton invButton;
    private shopButton shpButton;
    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse UIController. Diese wird als Parameter übergeben.
     * @param uiController das UIController-Objekt des Programms
     */
    public ProgramController(UIController uiController){
        this.uiController = uiController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     */


    public void startProgram(){
        startGame();
    }

    public void startGame(){
        new SQLCreator();
        userInterface = new UserInterface(0,0);
        uiController.drawObject(userInterface);
        grass = new Grass[13][28];
        tree = new Tree[13][28];
        mapBuilder = new MapBuilder(grass,tree,uiController,this);
        cat = new Cat(200,500);
        uiController.drawObject(cat);
        axeButton = new AxeButton(1220,540,grass,this);
        uiController.drawObject(axeButton);
        invButton = new inventoryButton(1060,540);
        uiController.drawObject(invButton);
        shpButton = new shopButton(900,540);
        uiController.drawObject(shpButton);
    }


    public void addWood(int amount){
        userInterface.addWood(amount);
    }
    public void addCash(int amount){
        userInterface.addCash(amount);
    }
    public void removeButtons(boolean b){
        invButton.setVisibility(b);
        shpButton.setVisibility(b);
        axeButton.setVisibility(b);
    }


    /**
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){
        // Hier passiert noch nichts, das Programm läuft friedlich vor sich hin
    }

    public void removeTree(Tree t){
        boolean treeRemoved = false;
        for(int i = 0; i < grass.length && !treeRemoved; i++){
            for(int j = 0; j < grass[i].length && !treeRemoved; j++){
                if(grass[i][j].getCoveringObject() == t){
                    treeRemoved = true;
                    grass[i][j].setCoveringObject(null);
                    uiController.removeObject(t);
                }
            }
        }
    }



}
