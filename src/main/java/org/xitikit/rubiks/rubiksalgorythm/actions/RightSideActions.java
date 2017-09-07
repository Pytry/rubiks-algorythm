package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.SidePivotUtil.pivot;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Created by Keith on 9/4/2017.
 */
public final class RightSideActions{

    /**
     * Pivots the right side of the cube such that the current
     * front-top-right corner is moved to the front-bottom-right.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnRightSideCounterClockwise(int turns, Cube cube){

        turnRightSideClockwise(turns * -1, cube);
    }

    /**
     * Pivots the right side of the cube such that the current
     * front-top-right corner is moved to the back-top-right.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnRightSideClockwise(int turns, Cube cube){

        turnRightSide(
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
    private static void turnRightSide(final int turns, final Cube cube){

        pivot(cube.right(), turns);
    }
}
