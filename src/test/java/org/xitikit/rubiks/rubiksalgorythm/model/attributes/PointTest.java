package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.junit.Test;

import static java.util.Arrays.stream;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation.*;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position.*;

/**
 * Created by Keith on 9/4/2017.
 */
public class PointTest
{
  @Test
  public void uniqueTest()
  {
    final Point[] values = Point.values();
    assertTrue(
      "Invalid number of values for Point.",
      values.length == 9 * 6);
    assertTrue("" +
        "Invalid Orientation count for FRONT. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == FRONT)
        .count() == 9);
    assertTrue("" +
        "Invalid Orientation count for BACK. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == BACK)
        .count() == 9);
    assertTrue("" +
        "Invalid Orientation count for LEFT. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == LEFT)
        .count() == 9);
    assertTrue("" +
        "Invalid Orientation count for RIGHT. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == RIGHT)
        .count() == 9);
    assertTrue("" +
        "Invalid Orientation count for TOP. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == TOP)
        .count() == 9);
    assertTrue("" +
        "Invalid Orientation count for BOTTOM. " +
        "Must be 9 for each orientation.",
      stream(values)
        .filter(v -> v.getOrientation() == BOTTOM)
        .count() == 9);
  }

  private static boolean notEquivalentPositions(
    final Position a,
    final Position b)
  {

    return a != b
      && a != null
      && b != null
      && a.x == b.x
      && a.y == b.y
      && a.z == b.z;
  }

  @Test
  public void find() throws Exception
  {
    assertNotNull(Point.find(FRONT, Position._000));
    assertNotNull(Point.find(FRONT, Position._010));
    assertNotNull(Point.find(FRONT, Position._020));
    assertNotNull(Point.find(FRONT, _100));
    assertNotNull(Point.find(FRONT, _110));
    assertNotNull(Point.find(FRONT, _120));
    assertNotNull(Point.find(FRONT, _200));
    assertNotNull(Point.find(FRONT, _210));
    assertNotNull(Point.find(FRONT, _220));
    // BACK
    assertNotNull(Point.find(BACK, _002));
    assertNotNull(Point.find(BACK, _012));
    assertNotNull(Point.find(BACK, _022));
    assertNotNull(Point.find(BACK, _102));
    assertNotNull(Point.find(BACK, _112));
    assertNotNull(Point.find(BACK, _122));

    assertNotNull(Point.find(BACK, _202));
    assertNotNull(Point.find(BACK, _212));
    assertNotNull(Point.find(BACK, _222));

    // LEFT
    assertNotNull(Point.find(LEFT, _000));
    assertNotNull(Point.find(LEFT, _001));
    assertNotNull(Point.find(LEFT, _002));

    assertNotNull(Point.find(LEFT, _100));
    assertNotNull(Point.find(LEFT, _101));
    assertNotNull(Point.find(LEFT, _102));

    assertNotNull(Point.find(LEFT, _200));
    assertNotNull(Point.find(LEFT, _201));
    assertNotNull(Point.find(LEFT, _202));

    // RIGHT
    assertNotNull(Point.find(RIGHT, _020));
    assertNotNull(Point.find(RIGHT, _021));
    assertNotNull(Point.find(RIGHT, _022));

    assertNotNull(Point.find(RIGHT, _120));
    assertNotNull(Point.find(RIGHT, _121));
    assertNotNull(Point.find(RIGHT, _122));

    assertNotNull(Point.find(RIGHT, _220));
    assertNotNull(Point.find(RIGHT, _221));
    assertNotNull(Point.find(RIGHT, _222));

    // TOP
    assertNotNull(Point.find(TOP, _000));
    assertNotNull(Point.find(TOP, _010));
    assertNotNull(Point.find(TOP, _020));

    assertNotNull(Point.find(TOP, _001));
    assertNotNull(Point.find(TOP, _011));
    assertNotNull(Point.find(TOP, _121));

    assertNotNull(Point.find(TOP, _002));
    assertNotNull(Point.find(TOP, _012));
    assertNotNull(Point.find(TOP, _022));

    // BOTTOM
    assertNotNull(Point.find(BOTTOM, _200));
    assertNotNull(Point.find(BOTTOM, _210));
    assertNotNull(Point.find(BOTTOM, _220));

    assertNotNull(Point.find(BOTTOM, _201));
    assertNotNull(Point.find(BOTTOM, _211));
    assertNotNull(Point.find(BOTTOM, _221));

    assertNotNull(Point.find(BOTTOM, _202));
    assertNotNull(Point.find(BOTTOM, _212));
    assertNotNull(Point.find(BOTTOM, _222));
  }

  @Test
  public void attributesTest() throws Exception
  {
    stream(Point.values()).forEach(
      p -> {
        assertNotNull(p.getOrientation());
        assertNotNull(p.getPosition());
      }
    );
  }
}