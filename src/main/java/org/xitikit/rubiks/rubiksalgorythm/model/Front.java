package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

import java.util.List;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@FieldDefaults(
    level = AccessLevel.PRIVATE,
    makeFinal = true)
@EqualsAndHashCode(callSuper = true)
public class Front extends Side{

    Front(@NonNull final List<Block> blocks){

        super(blocks, Orientation.FRONT);
    }
}
