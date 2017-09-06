package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode.B;

/**
 * Created by Keith on 9/4/2017.
 */
public class ActionTest{

    @Test
    public void test(){

        Action action = new Action(B, 1);
        assertTrue(action.getCode() == B);
        assertTrue(action.getTurns() == 1);
    }
}