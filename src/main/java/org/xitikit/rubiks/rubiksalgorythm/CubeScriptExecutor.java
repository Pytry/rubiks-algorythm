package org.xitikit.rubiks.rubiksalgorythm;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.CubePrinter;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.List;

import static org.xitikit.rubiks.rubiksalgorythm.actions.ActionParser.readAndParseActionScript;

/**
 * Copyright ${year}
 * <p>
 * Offers simple methods for turning sides of a cube.
 * The "top-left" of the cube when facing the front is
 * the point of reference (i.e., it is 0,0,0).
 *
 * @author J. Keith Hoopes
 */
@SuppressWarnings("WeakerAccess")
public final class CubeScriptExecutor{

    private List<Action> actionList;

    private Cube cube;

    private CubeScriptExecutor(){

    }

    public static CubeScriptExecutor instance(){

        return new CubeScriptExecutor();
    }

    public CubeScriptExecutor withNewCube(){

        return withCube(new Cube());
    }

    public CubeScriptExecutor withCube(@NonNull final Cube cube){

        this.cube = cube;
        return this;
    }

    public CubeScriptExecutor withScript(final String scriptPath){

        if(scriptPath == null || "".equals(scriptPath.trim())){
            throw new CubeArgumentException("Invalid path.");
        }
        this.actionList = readAndParseActionScript(scriptPath);
        return this;
    }

    public Cube execute(){

        CubeManipulator turner = new CubeManipulator(cube);
        turner.process(actionList);
        return cube;
    }

    public String getCubeText(){

        return CubePrinter.cubeString(cube);
    }

    public CubeScriptExecutor printCube(){

        System.out.print(getCubeText());

        return this;
    }
}
