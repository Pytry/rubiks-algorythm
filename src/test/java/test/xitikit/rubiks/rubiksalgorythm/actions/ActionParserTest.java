package test.xitikit.rubiks.rubiksalgorythm.actions;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.CubeScriptExecutor;

import static org.junit.Assert.*;
import static org.xitikit.rubiks.rubiksalgorythm.actions.ActionParser.read;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class ActionParserTest{

    @Test
    public void parseActionsTest() throws Exception{

        assertEquals("" +
                " *  *  *  R  R  R  *  *  * \n" +
                " *  *  *  R  R  R  *  *  * \n" +
                " *  *  *  R  R  R  *  *  * \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * ",
            CubeScriptExecutor.instance()
                .withNewCube()
                .getCubeText()
        );
    }

    @Test
    public void readActionScriptTest() throws Exception{

        String actions = read("src/test/resources/action.script");
        assertNotNull(actions);
        assertTrue(actions.trim().length() > 0);
    }
}