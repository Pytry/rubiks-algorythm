package org.xitikit.rubiks.rubiksalgorythm.model;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import static junit.framework.TestCase.assertTrue;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class PositionTest{

    @Test
    public void uniqueTest(){

        Position[] values = Position.values();
        assertTrue(
            "Invalid number of values for Position.",
            values.length == 27);

        for(Position a : values){
            for(Position b : values){
                assertTrue("The 'Position' enum was not implemented correctly. " +
                        "Duplicate block coordinates found for '" + a + "' and '" + b + "'.",
                    blocksAreNotEquivalent(a, b));
            }
        }
    }

    private static boolean blocksAreNotEquivalent(
        final Position a,
        final Position b){

        return a != b
            && a != null
            && b != null
            && a.x == b.x
            && a.y == b.y
            && a.z == b.z;
    }
}
