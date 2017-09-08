package test.xitikit.rubiks.rubiksalgorythm;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.CubeManipulator;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position.*;

/**
 * Created by Keith on 9/4/2017.
 */
public class TopTurnFunctionsTest{

    @Test
    public void testTopTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.T, 1)
        ));
        assertTrue(cube.get(_000).getPosition() == _002);
        assertTrue(cube.get(_001).getPosition() == _012);
        assertTrue(cube.get(_002).getPosition() == _022);
        assertTrue(cube.get(_010).getPosition() == _001);
        assertTrue(cube.get(_011).getPosition() == _011);
        assertTrue(cube.get(_012).getPosition() == _021);
        assertTrue(cube.get(_020).getPosition() == _000);
        assertTrue(cube.get(_021).getPosition() == _010);
        assertTrue(cube.get(_022).getPosition() == _020);
    }

    @Test
    public void testTopCounterTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.TC, 1)
        ));

        assertTrue(cube.get(_000).getPosition() == _020);
        assertTrue(cube.get(_001).getPosition() == _010);
        assertTrue(cube.get(_002).getPosition() == _000);
        assertTrue(cube.get(_010).getPosition() == _021);
        assertTrue(cube.get(_011).getPosition() == _011);
        assertTrue(cube.get(_012).getPosition() == _001);
        assertTrue(cube.get(_020).getPosition() == _022);
        assertTrue(cube.get(_021).getPosition() == _012);
        assertTrue(cube.get(_022).getPosition() == _002);
    }
}