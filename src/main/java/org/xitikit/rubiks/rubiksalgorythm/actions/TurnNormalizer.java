package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public final class TurnNormalizer{

    public static int normalize(int turns){

        if(turns < 0){
            return reverse(
                reduce(
                    turns * -1
                )
            );
        }
        return reduce(
            turns
        );
    }

    public static int reverse(int quarterTurns){

        switch(quarterTurns){
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 1;
        }
        throw new CubeStateException("Invalid quarter turns entered.");
    }

    public static int reduce(int quarterTurns){

        return quarterTurns % 4;
    }
}
