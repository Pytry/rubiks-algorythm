package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

import java.util.List;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@EqualsAndHashCode
@FieldDefaults(
  level = AccessLevel.PRIVATE,
  makeFinal = true)
public abstract class Side
{

  List<Block> blocks;

  Orientation orientation;

  Side(
    @NonNull final List<Block> blocks,
    @NonNull final Orientation orientation)
  {
    if (blocks.size() != 9)
    {
      throw new CubeArgumentException("Invalid collection of blocks. A side must have nine blocks.");
    }
    this.blocks = blocks;
    this.orientation = orientation;
  }

  public List<Block> getBlocks()
  {
    return blocks;
  }

  public Orientation getOrientation()
  {
    return orientation;
  }
}
