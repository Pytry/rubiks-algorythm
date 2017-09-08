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
public class RightTurnFunctionsTest{

    @Test
    public void testRightTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.R, 1)
        ));
        assertTrue(cube.get(_020).getPosition() == _022);
        assertTrue(cube.get(_021).getPosition() == _122);
        assertTrue(cube.get(_022).getPosition() == _222);
        assertTrue(cube.get(_120).getPosition() == _021);
        assertTrue(cube.get(_121).getPosition() == _121);
        assertTrue(cube.get(_122).getPosition() == _221);
        assertTrue(cube.get(_220).getPosition() == _020);
        assertTrue(cube.get(_221).getPosition() == _120);
        assertTrue(cube.get(_222).getPosition() == _220);
    }

    @Test
    public void testRightCounterTurn() throws Exception{

        Cube cube = new Cube();
        CubeManipulator turner = new CubeManipulator(cube);

        turner.process(Collections.singletonList(
            new Action(ActionCode.RC, 1)
        ));
        assertTrue(cube.get(_020).getPosition() == _220);
        assertTrue(cube.get(_120).getPosition() == _221);
        assertTrue(cube.get(_220).getPosition() == _222);
        assertTrue(cube.get(_021).getPosition() == _120);
        assertTrue(cube.get(_121).getPosition() == _121);
        assertTrue(cube.get(_221).getPosition() == _122);
        assertTrue(cube.get(_022).getPosition() == _020);
        assertTrue(cube.get(_122).getPosition() == _021);
        assertTrue(cube.get(_222).getPosition() == _022);
    }
}