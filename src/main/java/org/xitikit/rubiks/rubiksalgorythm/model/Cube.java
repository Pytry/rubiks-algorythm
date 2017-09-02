package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@FieldDefaults(
    level = AccessLevel.PRIVATE,
    makeFinal = true)
public class Cube{

    private List<Block> map = Panel.PANELS
        .entrySet()
        .stream()
        .map(e ->
            new Block(
                e.getKey(),
                e.getValue()
            ))
        .collect(toList());

    /**
     * @return the current list blocks on the "top" of the cube.
     */
    public Top top(){

        return new Top(extractSideBlocks(e -> e.getPosition().x == 0));
    }

    /**
     * @return the current list blocks on the "bottom" of the cube.
     */
    public Bottom bottom(){

        return new Bottom(extractSideBlocks(e -> e.getPosition().x == 2));
    }

    /**
     * @return the current list blocks on the "left" of the cube.
     */
    public Left left(){

        return new Left(extractSideBlocks(e -> e.getPosition().y == 0));
    }

    /**
     * @return the current list blocks on the "right" of the cube.
     */
    public Right right(){

        return new Right(extractSideBlocks(e -> e.getPosition().y == 2));
    }

    /**
     * @return the current list blocks on the "front" of the cube.
     */
    public Front front(){

        return new Front(extractSideBlocks(e -> e.getPosition().z == 0));
    }

    /**
     * @return the current list blocks on the "back" of the cube.
     */
    public Back back(){

        return new Back(extractSideBlocks(e -> e.getPosition().z == 2));
    }

    /**
     * @return the current list blocks on the "top" of the cube.
     */
    private List<Block> extractSideBlocks(Predicate<Block> filter){

        return map.stream()
            .filter(filter)
            .collect(toList());
    }
}
