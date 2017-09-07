package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.SidePivotUtil.pivot;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Created by Keith on 9/4/2017.
 */
public final class TopSideActions{

    /**
     * Pivots the right side of the cube such that the current
     * front-top-right corner is moved to the front-top-back.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnTopSideCounterClockwise(int turns, Cube cube){

        turnTopSideClockwise(turns * -1, cube);
    }

    /**
     * Pivots the top side of the cube such that the current
     * front-top-right corner is moved to the front-top-left.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnTopSideClockwise(int turns, Cube cube){

        turnTopSide(
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
    private static void turnTopSide(final int turns, final Cube cube){

        pivot(cube.top(), turns);
    }
}
