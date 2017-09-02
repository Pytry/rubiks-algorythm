package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;

import static java.util.Arrays.stream;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public enum Position{

    _000(0, 0, 0), _001(0, 0, 1), _002(0, 0, 2),
    _010(0, 1, 0), _011(0, 1, 1), _012(0, 1, 2),
    _020(0, 2, 0), _021(0, 2, 1), _022(0, 2, 2),
    _100(1, 0, 0), _101(1, 0, 1), _102(1, 0, 2),
    _110(1, 1, 0), _111(1, 1, 1), _112(1, 1, 2),
    _120(1, 2, 0), _121(1, 2, 1), _122(1, 2, 2),
    _200(2, 0, 0), _201(2, 0, 1), _202(2, 0, 2),
    _210(2, 1, 0), _211(2, 1, 1), _212(2, 1, 2),
    _220(2, 2, 0), _221(2, 2, 1), _222(2, 2, 2);

    public final int
        x, y, z;

    public final String
        x_pivot_key,
        y_pivot_key,
        z_pivot_key;

    Position(int a, int b, int c){

        assert a == 0 || a == 1 || a == 2;
        assert b == 0 || b == 1 || b == 2;
        assert c == 0 || c == 1 || c == 2;

        x = a;
        y = b;
        z = c;

        x_pivot_key = y + "" + z;
        y_pivot_key = y + "" + z;
        z_pivot_key = y + "" + z;


    }

    public static Position get(int a, int b, int c){

        return stream(Position.values())
            .filter(p -> p.x == a
                && p.y == b
                && p.z == c)
            .findFirst()
            .orElseThrow(() ->
                new CubeArgumentException(
                    "Invalid values for " +
                        "'x:" + a + "', " +
                        "'y:" + b + "', " +
                        "'z:" + c + "'."));
    }
}