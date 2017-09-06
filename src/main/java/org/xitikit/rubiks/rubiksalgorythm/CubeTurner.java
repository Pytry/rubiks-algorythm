package org.xitikit.rubiks.rubiksalgorythm;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.actions.Action;
import org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import java.util.List;

import static org.xitikit.rubiks.rubiksalgorythm.actions.back.BackSideActions.turnBackSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.bottom.BottomSideActions.turnBottomSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.bottom.BottomSideActions.turnBottomSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.front.FrontSideActions.turnFrontSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.front.FrontSideActions.turnFrontSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.left.LeftSideActions.turnLeftSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.left.LeftSideActions.turnLeftSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.right.RightSideActions.turnRightSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.right.RightSideActions.turnRightSideCounterClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.top.TopSideActions.turnTopSideClockwise;
import static org.xitikit.rubiks.rubiksalgorythm.actions.top.TopSideActions.turnTopSideCounterClockwise;

/**
 * Copyright ${year}
 * <p>
 * Offers simple methods for turning sides of a cube.
 * The "top-left" of the cube when facing the front is
 * the point of reference (i.e., it is 0,0,0).
 *
 * @author J. Keith Hoopes
 */
public final class CubeTurner{

    private final Cube cube;

    public CubeTurner(@NonNull Cube cube){

        this.cube = cube;
    }

    /**
     * Determines which action to perform according to the passed in ActionCode.
     *
     * @param actionList List&lt;Action&gt;
     *
     * @see ActionCode
     */
    public void process(@NonNull final List<Action> actionList){

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
    public void process(@NonNull final ActionCode code, final int turns){

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
                turnBackSideClockwise(turns, cube);
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
