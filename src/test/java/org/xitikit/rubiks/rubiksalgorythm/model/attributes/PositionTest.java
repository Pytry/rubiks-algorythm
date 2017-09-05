package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Keith on 9/4/2017.
 */
public class PositionTest
{

  @Test
  public void uniqueTest()
  {

    Position[] values = Position.values();
    assertTrue(
      "Invalid number of values for Position.",
      values.length == 9 * 3);

    for (Position a : values)
    {
      for (Position b : values)
      {
        assertTrue("The 'Position' enum was not implemented correctly. " +
            "Duplicate block coordinates found for '" + a + "' and '" + b + "'.",
          notEquivalent(a, b));
      }
    }
  }

  private static boolean notEquivalent(
    final Position a,
    final Position b)
  {
    return a == b //only the exact enum will be the same
      || a.x != b.x
      || a.y != b.y
      || a.z != b.z;
  }
}