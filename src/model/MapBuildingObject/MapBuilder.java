package model.MapBuildingObject;

import control.*;
import mapObjects.*;
import control.ProgramController;
import control.framework.UIController;

import java.io.*;

public class MapBuilder {

    //Attribute

    //Referenzen
    private Grass[][] grass;
    private Tree[][] tree;
    private UIController ui;
    private ProgramController pc;


    public MapBuilder(Grass[][] grass, Tree[][] tree, UIController ui, ProgramController pc) {
        this.grass = grass;
        this.tree = tree;
        this.pc = pc;
        this.ui = ui;
        load();
    }

    public void load() {


        BufferedReader reader;

        try {


            reader = new BufferedReader(new FileReader(new File("src/model/MapBuildingObject/Map.txt")));
            String line = reader.readLine();


            int amount = 20;  //Anzahl der Einstellungen + Leerzeilen +  Beschreibungen

            String[] lines = new String[amount];
            double tempX = 0;
            double tempY = 50;
            String currentLetter;
            for(int i = 0; i < lines.length; i++) {

                lines[i] = reader.readLine();

                if (lines[i] != null) {
                    char[] c = lines[i].toCharArray();
                    tempX = 0;
                    for (int a = 0; a < c.length; a++) {
                        currentLetter = "" + c[a];

                        if (currentLetter.equals("G")) {
                            grass[i][a] = new Grass(tempX, tempY);
                            ui.drawObject(grass[i][a]);
                        }

                        if (currentLetter.equals("T")||currentLetter.equals("B")) {
                            grass[i][a] = new Grass(tempX, tempY);
                            ui.drawObject(grass[i][a]);
                            grass[i][a].setCoveringObject(new Tree(tempX, tempY, currentLetter, pc));
                            ui.drawObject(grass[i][a].getCoveringObject());
                        }
                        tempX = tempX + 50;
                    }
                    tempY = tempY + 50;

                }
            }

        } catch (IOException e) {
            //System.err.println("Nope");
            e.printStackTrace();
        }
    }
}