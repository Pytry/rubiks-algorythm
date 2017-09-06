package org.xitikit.rubiks.rubiksalgorythm;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position.*;

/**
 * Created by Keith on 9/4/2017.
 */
public class LeftTurnFunctionsTest{

    @Test
    public void testLeftTurn() throws Exception{

        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.L, 1)
        ));
        assertTrue(cube.get(_000).getPosition() == _002);
        assertTrue(cube.get(_001).getPosition() == _102);
        assertTrue(cube.get(_002).getPosition() == _202);
        assertTrue(cube.get(_100).getPosition() == _001);
        assertTrue(cube.get(_101).getPosition() == _101);
        assertTrue(cube.get(_102).getPosition() == _201);
        assertTrue(cube.get(_200).getPosition() == _000);
        assertTrue(cube.get(_201).getPosition() == _100);
        assertTrue(cube.get(_202).getPosition() == _200);
    }

    @Test
    public void testLeftCounterTurn() throws Exception{

        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.LC, 1)
        ));
        assertTrue(cube.get(_000).getPosition() == _200);
        assertTrue(cube.get(_100).getPosition() == _201);
        assertTrue(cube.get(_200).getPosition() == _202);
        assertTrue(cube.get(_001).getPosition() == _100);
        assertTrue(cube.get(_101).getPosition() == _101);
        assertTrue(cube.get(_201).getPosition() == _102);
        assertTrue(cube.get(_002).getPosition() == _000);
        assertTrue(cube.get(_102).getPosition() == _001);
        assertTrue(cube.get(_202).getPosition() == _002);
    }
}