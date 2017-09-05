package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import lombok.experimental.NonFinal;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;
import org.xitikit.rubiks.rubiksalgorythm.model.Block;
import org.xitikit.rubiks.rubiksalgorythm.model.Side;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Point;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public final class PivotFunctions{

    private static final Function<Integer,Integer>
        NO_PIVOT = axis -> axis,
        LATERAL_TO_HORIZONTAL_PIVOT = axis -> (axis + 2) % 2,
        HORIZONTAL_TO_LATERAL_PIVOT = axis -> (axis + 2) % 3;

    public static void pivotSide(
        @NonNull final Side side,
        @NonNull final Integer turns){

        side
            .getBlocks()
            .parallelStream()
            .forEach(
                block -> pivotBlock(
                    block,
                    turns,
                    side.getOrientation())
            );
    }

    public static void pivotBlock(
        @NonNull final Block block,
        @NonNull final Integer turns,
        @NonNull final Orientation orientation){

        block.setPosition(
            pivotPosition(
                block.getPosition(),
                turns,
                pivotsForOrientation(orientation)
            ));

        block
            .getPanelList()
            .forEach(
                panel -> {
                    Point point = panel.getPoint();
                    Orientation pointOrientation = point.getOrientation();

                    if(pointOrientation != orientation){
                        switch(pointOrientation){
                            case LEFT:
                                panel.setPoint(Point.find(Orientation.TOP, point.getPosition()));
                        }
                    }
                }
            );
    }

    @SuppressWarnings("unchecked")
    private static Function<Integer,Integer>[] pivotsForOrientation(
        @NonNull final Orientation orientation){

        switch(orientation){
            case FRONT:
            case BACK:
                return (Function<Integer,Integer>[])
                    asList(
                        LATERAL_TO_HORIZONTAL_PIVOT,
                        HORIZONTAL_TO_LATERAL_PIVOT,
                        NO_PIVOT).toArray();
            case LEFT:
            case RIGHT:
                return (Function<Integer,Integer>[])
                    asList(
                        LATERAL_TO_HORIZONTAL_PIVOT,
                        NO_PIVOT,
                        HORIZONTAL_TO_LATERAL_PIVOT
                    ).toArray();
            case TOP:
            case BOTTOM:
                return (Function<Integer,Integer>[])
                    asList(
                        NO_PIVOT,
                        LATERAL_TO_HORIZONTAL_PIVOT,
                        HORIZONTAL_TO_LATERAL_PIVOT
                    ).toArray();
        }
        throw new CubeStateException("Invalid Orientation Found: " + orientation);
    }

    private static Position pivotPosition(
        @NonNull @NonFinal Position position,
        @NonNull final Integer turns,
        @NonNull final Function<Integer,Integer>[] pivots){

        if(position != null){

            int t = normalize(turns == null ? 0 : turns);
            for(; t > 0; t--){
                position = Position.get(
                    pivots[0].apply(position.x),
                    pivots[1].apply(position.y),
                    pivots[2].apply(position.z)
                );
            }
            return position;
        }
        throw new CubeArgumentException("Position cannot be null when pivoting.");
    }
}
