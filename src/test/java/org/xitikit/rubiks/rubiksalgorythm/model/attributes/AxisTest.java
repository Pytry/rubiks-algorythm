package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Keith on 9/4/2017.
 */
public class AxisTest
{
  @Test
  public void test(){
    assertTrue(Axis.values().length ==3);
    assertNotNull(Axis.valueOf("X"));
    assertNotNull(Axis.valueOf("Y"));
    assertNotNull(Axis.valueOf("Z"));
  }
}