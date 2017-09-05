package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.PivotFunctions.pivotSide;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Created by Keith on 9/4/2017.
 */
public final class BackSideActions{

    /**
     * Pivots the front side of the cube such that the current
     * back-top-left corner is moved to the back-bottom-left.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnBackSideCounterClockwise(int turns, Cube cube){

        turnBackSideClockwise(turns * -1, cube);
    }

    /**
     * Pivots the back side of the cube such that the current
     * back-top-left corner is moved to the back-top-right.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnBackSideClockwise(int turns, Cube cube){

        turnBackSide(
            normalize(turns),
            cube);
    }

    /**
     * Generic method which assumes clockwise movement.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    private static void turnBackSide(final int turns, final Cube cube){

        pivotSide(cube.back(), turns);
    }
}
