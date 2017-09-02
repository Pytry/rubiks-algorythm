package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

import java.util.List;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Data
@FieldDefaults(
    level = AccessLevel.PRIVATE,
    makeFinal = true)
public class Right extends Side{

    Right(@NonNull final List<Block> blocks){

        super(blocks, Orientation.RIGHT);
    }
}
