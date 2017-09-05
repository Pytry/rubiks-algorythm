package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Color.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(
  level = AccessLevel.PRIVATE,
  makeFinal = true)
public class Panel
{

  @NonFinal
  Point point;

  /**
   * The original point the panel had at the start of process.
   */
  Point id;

  /**
   * The color of the panel.
   */
  Color color;

  public static final List<Panel> PANELS = unmodifiableList(
    stream(Point.values())
      .map(Panel::buildPanel)
      .collect(toList())
  );

  private Panel(
    final Point id,
    final Color color)
  {

    assert id != null;
    assert color != null;

    this.id = id;
    this.point = id;
    this.color = color;
  }

  private static Panel buildPanel(Point point)
  {
    switch (point.getOrientation())
    {
      case FRONT:
        return new Panel(point, WHITE);
      case BACK:
        return new Panel(point, YELLOW);
      case LEFT:
        return new Panel(point, BLUE);
      case RIGHT:
        return new Panel(point, GREEN);
      case TOP:
        return new Panel(point, RED);
      case BOTTOM:
        return new Panel(point, ORANGE);
      default:
        throw new CubeStateException("Invalid Point");
    }
  }
}
