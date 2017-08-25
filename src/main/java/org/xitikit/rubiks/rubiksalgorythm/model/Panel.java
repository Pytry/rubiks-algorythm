package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@FieldDefaults(
    makeFinal = true,
    level = AccessLevel.PRIVATE)
public class Panel{

    @NonNull Color color;

    public Panel(@NonNull Color color){

        this.color = color;
    }
}
