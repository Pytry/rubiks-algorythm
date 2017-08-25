package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BlueSide extends Side{

    public BlueSide(){

        super(new Color[][]{
            new Color[]{Color.RED,Color.RED,Color.RED},
            new Color[]{Color.RED,Color.RED,Color.RED},
            new Color[]{Color.RED,Color.RED,Color.RED}
        });
    }
}
