package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.*;
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
public class Panel{

    @NonFinal Point point;

    /**
     * The original point the panel had at the start of process.
     */
    Point id;

    /**
     * The color of the panel.
     */
    Color color;

    private Panel(
        final Point id,
        final Color color){

        assert id != null;
        assert color != null;

        this.id = id;
        this.point = id;
        this.color = color;
    }

    public static final Map<Position,List<Panel>> PANELS = unmodifiableMap(
        stream(Point.values())
            .collect(groupingBy(
                point -> point.getPosition(),
                () -> new HashMap<>(27),
                mapping(
                    Panel::buildPanel,
                    toCollection(
                        () -> new ArrayList<>(3)
                    ))))
            .entrySet()
            .stream()
            .collect(
                toMap(
                    Map.Entry::getKey,
                    e -> unmodifiableList(
                        e.getValue()
                    ))));

    private static Panel buildPanel(Point point){

        switch(point.getOrientation()){
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
