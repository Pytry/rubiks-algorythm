package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Point;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
final class PointPivotUtil{

    private static final Map<String,Orientation> POINT_PIVOT_ORIENTATIONS = createPointPivots(new HashMap<>());

    /**
     * @param point    The original point that needs to be pivoted to a target point
     * @param axis     The orientation of the side that was turned.
     * @param position The new target position of the point.
     *
     * @return The point corresponding to the new orientation and target position.
     */
    static Point pivot(
        @NonNull final Point point,
        @NonNull final Orientation axis,
        final Integer turns,
        @NonNull final Position position){

        return Point.find(
            pivotOrientation(point, axis, turns),
            position);
    }

    private static Orientation pivotOrientation(
        @NonNull final Point point,
        @NonNull final Orientation axis,
        final int turns){

        Orientation answer = point.getOrientation();
        for(int i = 0; i < turns; i++){
            answer = pivotOrientation(axis,answer);
        }
        return answer;
    }

    private static Orientation pivotOrientation(
        @NonNull final Orientation axis,
        @NonNull final Orientation origin){

        return POINT_PIVOT_ORIENTATIONS.get(
            pivotKey(axis, origin)
        );
    }

    private static String pivotKey(
        @NonNull final Orientation axis,
        @NonNull final Orientation origin){

        return axis.name() + origin.name();
    }

    private static Map<String,Orientation> createPointPivots(
        @NonNull final Map<String,Orientation> tmp){
        // FRONT
        tmp.put(FRONT.name() + FRONT.name(), FRONT);
        tmp.put(FRONT.name() + BACK.name(), BACK);
        tmp.put(FRONT.name() + LEFT.name(), TOP);
        tmp.put(FRONT.name() + RIGHT.name(), BOTTOM);
        tmp.put(FRONT.name() + TOP.name(), RIGHT);
        tmp.put(FRONT.name() + BOTTOM.name(), LEFT);
        // BACK
        tmp.put(BACK.name() + BACK.name(), BACK);
        tmp.put(BACK.name() + FRONT.name(), FRONT);
        tmp.put(BACK.name() + LEFT.name(), TOP);
        tmp.put(BACK.name() + RIGHT.name(), BOTTOM);
        tmp.put(BACK.name() + TOP.name(), RIGHT);
        tmp.put(BACK.name() + BOTTOM.name(), LEFT);
        // LEFT
        tmp.put(LEFT.name() + LEFT.name(), LEFT);
        tmp.put(LEFT.name() + RIGHT.name(), RIGHT);
        tmp.put(LEFT.name() + FRONT.name(), TOP);
        tmp.put(LEFT.name() + BACK.name(), BOTTOM);
        tmp.put(LEFT.name() + TOP.name(), BACK);
        tmp.put(LEFT.name() + BOTTOM.name(), FRONT);
        // RIGHT
        tmp.put(RIGHT.name() + RIGHT.name(), RIGHT);
        tmp.put(RIGHT.name() + LEFT.name(), LEFT);
        tmp.put(RIGHT.name() + FRONT.name(), TOP);
        tmp.put(RIGHT.name() + BACK.name(), BOTTOM);
        tmp.put(RIGHT.name() + TOP.name(), BACK);
        tmp.put(RIGHT.name() + BOTTOM.name(), FRONT);
        // TOP
        tmp.put(TOP.name() + TOP.name(), TOP);
        tmp.put(TOP.name() + BOTTOM.name(), BOTTOM);
        tmp.put(TOP.name() + FRONT.name(), LEFT);
        tmp.put(TOP.name() + BACK.name(), RIGHT);
        tmp.put(TOP.name() + LEFT.name(), BACK);
        tmp.put(TOP.name() + RIGHT.name(), FRONT);
        // BOTTOM
        tmp.put(BOTTOM.name() + BOTTOM.name(), BOTTOM);
        tmp.put(BOTTOM.name() + TOP.name(), TOP);
        tmp.put(BOTTOM.name() + FRONT.name(), LEFT);
        tmp.put(BOTTOM.name() + BACK.name(), RIGHT);
        tmp.put(BOTTOM.name() + LEFT.name(), BACK);
        tmp.put(BOTTOM.name() + RIGHT.name(), FRONT);

        return unmodifiableMap(tmp);
    }
}
