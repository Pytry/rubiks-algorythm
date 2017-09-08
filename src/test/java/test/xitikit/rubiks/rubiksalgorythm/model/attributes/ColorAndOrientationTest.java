package test.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Color;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Keith on 9/4/2017.
 */
public class ColorAndOrientationTest{

    @Test
    public void test(){

        assertTrue(Color.values().length == 6);
        assertTrue(Color.values().length == Orientation.values().length);
    }
}