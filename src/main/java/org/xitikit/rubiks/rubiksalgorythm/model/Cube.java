package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Point;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableSet;
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

    private final Set<Block> blocks;

    private final Map<Position,Block> blockMap;

    public Cube(){

        blocks = unmodifiableSet(Block.createBlocks());
        blockMap = blocks
            .stream()
            .collect(
                toMap(
                    Block::getId,
                    b -> b
                )
            );
    }

    /**
     * @return the current list blocks on the "top" of the cube.
     */
    public Top top(){

        return new Top(extractSideBlocks(e -> e.getPosition().x == 0));
    }

    /**
     * @return the current list blocks on the "top" of the cube.
     */
    private List<Block> extractSideBlocks(Predicate<Block> filter){

        return blocks.stream()
            .filter(filter)
            .collect(toList());
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

    public List<Block> all(){

        return new ArrayList<>(blocks);
    }

    public Block get(Position id){

        return blockMap.get(id);
    }

    public Panel get(Point point){

        return get(point.getPosition())
            .getPanelList()
            .stream()
            .filter(
                p -> p.getPoint() == point)
            .findFirst()
            .orElseThrow(
                () -> new CubeStateException("Point '" + point + "' not mapped to panel.")
            );
    }
}
