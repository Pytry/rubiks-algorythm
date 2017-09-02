package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.PivotFunctions.PIVOT_ON_Y;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public final class CubeTurner{

    public static void turnRightSideToBack(int quarterTurns, Cube cube){

        turnRightSide(
            normalize(quarterTurns),
            cube);
    }

    public static void turnRightSideToFront(int quarterTurns, Cube cube){

        turnRightSideToBack(quarterTurns * -1, cube);
    }

    private static void turnRightSide(final int quarterTurns, final Cube cube){

        cube.rightSide()
            .forEach(block -> {
                block.setPosition(
                    PIVOT_ON_Y.apply(
                        block.getPosition(),
                        normalize(quarterTurns)
                    )
                );
            }
        );
    }

}
