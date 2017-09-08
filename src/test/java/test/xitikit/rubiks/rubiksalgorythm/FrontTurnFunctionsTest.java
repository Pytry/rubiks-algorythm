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
public class FrontTurnFunctionsTest{

    @Test
    public void testFrontTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.F, 1)
        ));
        assertTrue(cube.get(_000).getPosition() == _020);
        assertTrue(cube.get(_010).getPosition() == _120);
        assertTrue(cube.get(_020).getPosition() == _220);
        assertTrue(cube.get(_120).getPosition() == _210);
        assertTrue(cube.get(_220).getPosition() == _200);
        assertTrue(cube.get(_210).getPosition() == _100);
        assertTrue(cube.get(_200).getPosition() == _000);
        assertTrue(cube.get(_100).getPosition() == _010);
    }

    @Test
    public void testFrontCounterTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.FC, 1)
        ));
        assertTrue(cube.get(_000).getPosition() == _200);
        assertTrue(cube.get(_100).getPosition() == _210);
        assertTrue(cube.get(_200).getPosition() == _220);
        assertTrue(cube.get(_210).getPosition() == _120);
        assertTrue(cube.get(_220).getPosition() == _020);
        assertTrue(cube.get(_120).getPosition() == _010);
        assertTrue(cube.get(_020).getPosition() == _000);
        assertTrue(cube.get(_010).getPosition() == _100);
    }
}