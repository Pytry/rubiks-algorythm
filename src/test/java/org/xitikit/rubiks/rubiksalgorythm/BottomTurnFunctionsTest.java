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
public class BottomTurnFunctionsTest{


    @Test
    public void testBottomTurn() throws Exception
    {
        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.B, 1)
        ));
        assertTrue(cube.get(_200).getPosition() == _202);
        assertTrue(cube.get(_201).getPosition() == _212);
        assertTrue(cube.get(_202).getPosition() == _222);
        assertTrue(cube.get(_210).getPosition() == _201);
        assertTrue(cube.get(_211).getPosition() == _211);
        assertTrue(cube.get(_212).getPosition() == _221);
        assertTrue(cube.get(_220).getPosition() == _200);
        assertTrue(cube.get(_221).getPosition() == _210);
        assertTrue(cube.get(_222).getPosition() == _220);
    }

    @Test
    public void testBottomCounterTurn() throws Exception
    {
        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.BC, 1)
        ));

        assertTrue(cube.get(_222).getPosition() == _202);
        assertTrue(cube.get(_221).getPosition() == _212);
        assertTrue(cube.get(_220).getPosition() == _222);
        assertTrue(cube.get(_212).getPosition() == _201);
        assertTrue(cube.get(_211).getPosition() == _211);
        assertTrue(cube.get(_210).getPosition() == _221);
        assertTrue(cube.get(_200).getPosition() == _220);
        assertTrue(cube.get(_201).getPosition() == _210);
        assertTrue(cube.get(_202).getPosition() == _200);
    }
}