package org.xitikit.rubiks.rubiksalgorythm;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.List;

import static org.xitikit.rubiks.rubiksalgorythm.actions.BackSideActions.turnBackSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.BackSideActions.turnBackSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.BottomSideActions.turnBottomSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.BottomSideActions.turnBottomSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.FrontSideActions.turnFrontSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.FrontSideActions.turnFrontSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.LeftSideActions.turnLeftSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.LeftSideActions.turnLeftSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.RightSideActions.turnRightSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.RightSideActions.turnRightSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TopSideActions.turnTopSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TopSideActions.turnTopSideCounterClockwise;

/**
 * Copyright ${year}
 * <p>
 * Offers simple methods for turning sides of a cube.
 * The "top-left" of the cube when facing the front is
 * the point of reference (i.e., it is 0,0,0).
 *
 * @author J. Keith Hoopes
 */
final class CubeTurner{

    private final Cube cube;

    CubeTurner(@NonNull Cube cube){

        this.cube = cube;
    }

    /**
     * Determines which action to perform according to the passed in ActionCode.
     *
     * @param actionList List&lt;Action&gt;
     *
     * @see ActionCode
     */
    void process(@NonNull final List<Action> actionList){

        actionList.forEach(
            a -> process(
                a.getCode(),
                a.getTurns()));
    }

    /**
     * Determines which action to perform according to the passed in ActionCode.
     *
     * @param code ActionCode
     *
     * @see ActionCode
     */
    private void process(@NonNull final ActionCode code, final int turns){

        switch(code){
            case F:{
                turnFrontSideClockwise(turns, cube);
                break;
            }
            case FC:{
                turnFrontSideCounterClockwise(turns, cube);
                break;
            }
            case BK:{
                turnBackSideClockwise(turns, cube);
                break;
            }
            case BKC:{
                turnBackSideCounterClockwise(turns, cube);
                break;
            }
            case L:{
                turnLeftSideClockwise(turns, cube);
                break;
            }
            case LC:{
                turnLeftSideCounterClockwise(turns, cube);
                break;
            }
            case R:{
                turnRightSideClockwise(turns, cube);
                break;
            }
            case RC:{
                turnRightSideCounterClockwise(turns, cube);
                break;
            }
            case T:{
                turnTopSideClockwise(turns, cube);
                break;
            }
            case TC:{
                turnTopSideCounterClockwise(turns, cube);
                break;
            }
            case B:{
                turnBottomSideClockwise(turns, cube);
                break;
            }
            case BC:{
                turnBottomSideCounterClockwise(turns, cube);
                break;
            }
            default:
                throw new CubeStateException("Invalid ActionCode enum found.");
        }
    }
}
