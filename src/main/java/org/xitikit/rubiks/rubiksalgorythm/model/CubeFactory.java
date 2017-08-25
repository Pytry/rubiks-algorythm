package org.xitikit.rubiks.rubiksalgorythm.model;

import static org.xitikit.rubiks.rubiksalgorythm.model.Color.*;
import static org.xitikit.rubiks.rubiksalgorythm.model.Color.BLUE;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeFactory{

    public static Block[][][] createCube(){

        return fillCube(new Block[3][3][3]());
    }
    private Block[][][] fillCube(Block[][][] cube){

        cube[0][0][0] = new CornerBlock(new Panel(RED), new Panel(BLUE),new Panel(YELLOW));
        cube[1][0][0] = new SideBlock(new Panel(RED), new Panel(BLUE));
        cube[2][0][0] = new CornerBlock(new Panel(RED), new Panel(WHITE),new Panel(BLUE));
        cube[0][1][0] = new SideBlock(new Panel(RED), new Panel(YELLOW));
        cube[1][1][0] = new MiddleBlock(new Panel(RED));
        cube[2][1][0] = new SideBlock(new Panel(RED), new Panel(WHITE));
        cube[0][2][0] = ;
        cube[1][2][0] = ;
        cube[2][2][0] = ;
        cube[0][0][1] = ;
        cube[1][0][1] = ;
        cube[2][0][1] = ;
        cube[0][1][1] = ;
        cube[1][1][1] = ;
        cube[2][1][1] = ;
        cube[0][2][1] = ;
        cube[1][2][1] = ;
        cube[2][2][1] = ;
        cube[0][0][2] = ;
        cube[1][0][2] = ;
        cube[2][0][2] = ;
        cube[0][1][2] = ;
        cube[1][1][2] = ;
        cube[2][1][2] = ;
        cube[0][2][2] = ;
        cube[1][2][2] = ;
        cube[2][2][2] = ;
    }
}
