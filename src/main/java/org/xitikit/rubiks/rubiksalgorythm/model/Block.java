package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.List;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel.PANELS;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@Setter
@EqualsAndHashCode
public class Block
{

  private final Position id;

  private final List<Panel> panelList;

  @NonNull
  private Position position;

  public static Set<Block> createBlocks()
  {
    return stream(Position.values())
      .map(p -> new Block(p,
          PANELS
            .stream()
            .filter(
              panel -> panel
                .getPoint()
                .getPosition() == p
            )
            .collect(
              toList()
            )
        )
      )
      .collect(
        toSet()
      );
  }

  private Block(
    @NonNull final Position id,
    @NonNull final List<Panel> panelList)
  {

    if (panelList.size() > 3)
    {
      throw new CubeArgumentException("A Block cannot have more than 3 panels.");
    }

    this.id = id;
    this.position = id;
    this.panelList = unmodifiableList(panelList);
  }
}
