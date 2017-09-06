package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;
import org.xitikit.rubiks.rubiksalgorythm.model.Side;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public final class SidePivotUtil{

    /**
     * Pivots the given side.
     *
     * @param side  Target pivot side.
     * @param turns The number of times to pivot.
     */
    public static void pivot(
        @NonNull final Side side,
        @NonNull final int turns){

        side.getBlocks()
            .forEach(
                block -> {
                    if(block == null){
                        throw new CubeStateException("Found null block");
                    }
                    Orientation orientation = side.getOrientation();
                    if(orientation == null){
                        throw new CubeStateException("Found null Orientation.");
                    }
                    try{

                        BlockPivotUtil.pivot(
                            block,
                            turns,
                            orientation);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        throw new CubeStateException(e);
                    }
                }
            );
    }
}
