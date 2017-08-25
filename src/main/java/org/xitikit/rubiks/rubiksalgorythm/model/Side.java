package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static java.util.Arrays.stream;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Side{

    @NonNull Block[][] table;

    public boolean isValid(){

        return table != null
            &&
    }

    private boolean validateTable(Block[][] table){

        return table != null
    }
}
