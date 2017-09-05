package org.xitikit.rubiks.rubiksalgorythm.actions;

import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static org.xitikit.rubiks.rubiksalgorythm.actions.PivotFunctions.pivotSide;
import static org.xitikit.rubiks.rubiksalgorythm.actions.TurnNormalizer.normalize;

/**
 * Created by Keith on 9/4/2017.
 */
public final class FrontSideActions
{
  ///////////
  // FRONT //
  ///////////

  /**
   * Pivots the FRONT side of the cube such that the current
   * front-top-left corner is moved to the front-top-right.
   *
   * @param turns Number of turns or iterations that this operation
   *              should be performed
   * @param cube  The cube
   */
  public static void turnFrontSideClockwise(int turns, Cube cube)
  {
    turnFrontSide(
      normalize(turns),
      cube);
  }

  /**
   * Pivots the front side of the cube such that the current
   * front-top-left corner is moved to the front-botton-left.
   *
   * @param turns Number of turns or iterations that this operation
   *              should be performed
   * @param cube  The cube
   */
  public static void turnFrontSideCounterClockwise(int turns, Cube cube)
  {

    turnFrontSideClockwise(turns * -1, cube);
  }

  /**
   * Generic method which assumes clockwise movement.
   *
   * @param turns Number of turns or iterations that this operation
   *              should be performed
   * @param cube  The cube
   */
  private static void turnFrontSide(final int turns, final Cube cube)
  {
    pivotSide(cube.front(), turns);
  }
}
