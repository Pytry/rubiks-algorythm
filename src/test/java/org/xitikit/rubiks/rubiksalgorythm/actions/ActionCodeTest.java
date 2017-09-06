package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Keith on 9/4/2017.
 */
public class ActionCodeTest{

    @Test
    public void test(){

        assertTrue(ActionCode.values().length == Orientation.values().length * 2);
    }
}