package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.SidePivotUtil.pivot;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Created by Keith on 9/4/2017.
 */
public final class BottomSideActions{

    /**
     * Pivots the Bottom side of the cube such that the current
     * front-bottom-right corner is moved to the front-bottom-back.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnBottomSideCounterClockwise(int turns, Cube cube){

        turnBottomSideClockwise(turns * -1, cube);
    }

    /**
     * Pivots the bottom side of the cube such that the current
     * front-bottom-right corner is moved to the front-bottom-left.
     *
     * @param turns Number of turns or iterations that this operation
     *              should be performed
     * @param cube  The cube
     */
    public static void turnBottomSideClockwise(int turns, Cube cube){

        turnBottomSide(
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
    private static void turnBottomSide(final int turns, final Cube cube){

        pivot(cube.bottom(), turns);
    }
}
