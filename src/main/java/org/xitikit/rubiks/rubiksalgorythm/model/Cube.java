package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Cube{

    Block[] sides = new Side[]{

    };
     redSide;

    YellowSide yellowSide;

    BlueSide blueSide;

    WhiteSide whiteSide;

    OrangeSide orangeSide;

    GreenSide greenSide;
}
