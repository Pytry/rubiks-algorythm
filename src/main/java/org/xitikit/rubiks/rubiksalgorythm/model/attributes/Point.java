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
    F_T_L_(FRONT, _000), F_T_(FRONT, _010), F_T_R_(FRONT, _020),
    F_L_(FRONT, _100), F_(FRONT, _110), F_R_(FRONT, _120),
    F_B_L_(FRONT, _200), F_B(FRONT, _210), F_B_R_(FRONT, _220),
    // BACK
    BK_T_L_(BACK, _002), BK_T(BACK, _012), K_T_R_(BACK, _022),
    BK_L_(BACK, _102), BK_(BACK, _112), BK_R_(BACK, _122),
    BK_BL_(BACK, _202), BK_B_(BACK, _212), BK_BR_(BACK, _222),
    // LEFT
    L_T_F_(LEFT, _000), L_T_(LEFT, _001), L_T_BK_(LEFT, _002),
    L_F_(LEFT, _100), L_(LEFT, _101), L_BK_(LEFT, _102),
    L_F_B_(LEFT, _200), L_B_(LEFT, _201), L_B_BK_(LEFT, _202),
    // RIGHT
    R_T_F_(RIGHT, _020), R_T_(RIGHT, _021), R_T_BK_(RIGHT, _022),
    R_F_(RIGHT, _120), R_(RIGHT, _121), R_BK_(RIGHT, _122),
    R_F_B_(RIGHT, _220), R_B_(RIGHT, _221), R_B_BK_(RIGHT, _222),
    // TOP
    T_F_L_(TOP, _000), T_F_(TOP, _010), T_F_R_(TOP, _020),
    T_L_(TOP, _001), T_(TOP, _011), T_R_(TOP, _121),
    T_BK_L_(TOP, _002), T_BK_(TOP, _012), T_BK_R_(TOP, _022),
    // BOTTOM
    B_F_L_(BOTTOM, _200), B_F_(BOTTOM, _210), B_F_R_(BOTTOM, _220),
    B_L_(BOTTOM, _201), B_(BOTTOM, _211), B_R_(BOTTOM, _221),
    B_BK_L_(BOTTOM, _202), B_BK_(BOTTOM, _212), B_BK_R_(BOTTOM, _222);

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
