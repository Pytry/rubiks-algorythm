package org.xitikit.rubiks.rubiksalgorythm;

import org.junit.Ignore;
import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode;
import org.xitikit.rubiks.rubiksalgorythm.actions.CubePrinter;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class RubiksAlgorythmApplicationTest{

    @Test
    @Ignore
    public void main() throws Exception{

        final Cube
            aCube = new Cube(),
            bCube = new Cube();
        final CubeManipulator c = new CubeManipulator(bCube);
        final List<Action> actionCycle = Arrays.asList(
            new Action(ActionCode.R, 1),
            new Action(ActionCode.BKC, 1),
            new Action(ActionCode.LC, 1),
            new Action(ActionCode.F, 1)
        );
        final List<Action> reverseCycle = Arrays.asList(
            new Action(ActionCode.FC, 1),
            new Action(ActionCode.L, 1),
            new Action(ActionCode.BK, 1),
            new Action(ActionCode.RC, 1)
        );
        int count = 0;
        do{
            c.process(actionCycle);
            //            bCubeString = CubePrinter.cubeString(bCube);
            count++;
        }
        while(count < 1259);

        assert !Objects.equals(
            CubePrinter.cubeString(aCube),
            CubePrinter.cubeString(bCube));

        count = 0;
        do{
            c.process(reverseCycle);
            count++;
        }
        while(count < 1259);

        assert Objects.equals(
            CubePrinter.cubeString(aCube),
            CubePrinter.cubeString(bCube));

        System.out.print("Count == " + (count * 4));
    }
}