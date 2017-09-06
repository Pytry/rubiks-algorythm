package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;

import static java.util.Arrays.stream;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation.*;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public enum Point{

    // FRONT
    F_000_(FRONT, _000),
    F_010_(FRONT, _010),
    F_020_(FRONT, _020),
    F_100_(FRONT, _100),
    F_110_(FRONT, _110),
    F_120_(FRONT, _120),
    F_200_(FRONT, _200),
    F_210_(FRONT, _210),
    F_220_(FRONT, _220),
    // BACK
    BK_000_(BACK, _002),
    BK_010_(BACK, _012),
    BK_020_(BACK, _022),
    BK_100_(BACK, _102),
    BK_110_(BACK, _112),
    BK_120_(BACK, _122),
    BK_200_(BACK, _202),
    BK_210_(BACK, _212),
    BK_220_(BACK, _222),
    // LEFT
    L_000_(LEFT, _000),
    L_001_(LEFT, _001),
    L_002_(LEFT, _002),
    L_100_(LEFT, _100),
    L_101_(LEFT, _101),
    L_102_(LEFT, _102),
    L_200_(LEFT, _200),
    L_201_(LEFT, _201),
    L_202_(LEFT, _202),
    // RIGHT
    R_020_(RIGHT, _020),
    R_021_(RIGHT, _021),
    R_022_(RIGHT, _022),
    R_120_(RIGHT, _120),
    R_121_(RIGHT, _121),
    R_122_(RIGHT, _122),
    R_220_(RIGHT, _220),
    R_221_(RIGHT, _221),
    R_222_(RIGHT, _222),
    // TOP
    T_000_(TOP, _000),
    T_001_(TOP, _001),
    T_002_(TOP, _002),
    T_010_(TOP, _010),
    T_011_(TOP, _011),
    T_012_(TOP, _012),
    T_020_(TOP, _020),
    T_021_(TOP, _021),
    T_022_(TOP, _022),
    // BOTTOM
    B_200_(BOTTOM, _200),
    B_201_(BOTTOM, _201),
    B_202_(BOTTOM, _202),
    B_210_(BOTTOM, _210),
    B_211_(BOTTOM, _211),
    B_212_(BOTTOM, _212),
    B_220_(BOTTOM, _220),
    B_221_(BOTTOM, _221),
    B_222_(BOTTOM, _222);

    private final Orientation orientation;

    private final Position position;

    Point(
        @NonNull final Orientation orientation,
        @NonNull final Position position){

        this.orientation = orientation;
        this.position = position;
    }

    public static final Point find(
        @NonNull final Orientation orientation,
        @NonNull final Position position){

        return stream(Point.values())
            .filter(p ->
                p.getOrientation() == orientation
                    && p.getPosition() == position)
            .findFirst()
            .orElseThrow(
                () -> new CubeStateException("Point could not be found for " +
                    "'" + orientation + "' and " +
                    "'" + position + "'."));
    }

    public Orientation getOrientation(){

        return orientation;
    }

    public Position getPosition(){

        return position;
    }
}
