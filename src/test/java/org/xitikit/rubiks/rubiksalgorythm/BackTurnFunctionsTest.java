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
public class BackTurnFunctionsTest{

    @Test
    public void testBackTurn() throws Exception{

        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.BK, 1)
        ));
        assertTrue(cube.get(_002).getPosition() == _022);
        assertTrue(cube.get(_012).getPosition() == _122);
        assertTrue(cube.get(_022).getPosition() == _222);
        assertTrue(cube.get(_102).getPosition() == _012);
        assertTrue(cube.get(_112).getPosition() == _112);
        assertTrue(cube.get(_122).getPosition() == _212);
        assertTrue(cube.get(_202).getPosition() == _002);
        assertTrue(cube.get(_212).getPosition() == _102);
        assertTrue(cube.get(_222).getPosition() == _202);
    }

    @Test
    public void testBackCounterTurn() throws Exception{

        Cube cube = new Cube();
        CubeTurner turner = new CubeTurner(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.BKC, 1)
        ));

        assertTrue(cube.get(_002).getPosition() == _202);
        assertTrue(cube.get(_012).getPosition() == _102);
        assertTrue(cube.get(_022).getPosition() == _002);
        assertTrue(cube.get(_102).getPosition() == _212);
        assertTrue(cube.get(_112).getPosition() == _112);
        assertTrue(cube.get(_122).getPosition() == _012);
        assertTrue(cube.get(_202).getPosition() == _222);
        assertTrue(cube.get(_212).getPosition() == _122);
        assertTrue(cube.get(_222).getPosition() == _022);
    }
}