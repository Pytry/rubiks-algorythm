package org.xitikit.rubiks.rubiksalgorythm;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RubiksAlgorythmApplication
{

  public static void main(String... args)
  {

    Cube cube = new Cube();
  }
}
