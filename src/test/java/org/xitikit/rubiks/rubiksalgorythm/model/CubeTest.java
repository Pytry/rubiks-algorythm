package org.xitikit.rubiks.rubiksalgorythm.model;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeTest{

    @Test
    public void top() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.top().getBlocks().stream().filter(
            b -> b.getPosition().x == 0
        ).count() == 9);
    }

    @Test
    public void bottom() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.bottom().getBlocks().stream().filter(
            b -> b.getPosition().x == 2
        ).count() == 9);
    }

    @Test
    public void left() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.left().getBlocks().stream().filter(
            b -> b.getPosition().y == 0
        ).count() == 9);
    }

    @Test
    public void right() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.right().getBlocks().stream().filter(
            b -> b.getPosition().y == 2
        ).count() == 9);
    }

    @Test
    public void front() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.front().getBlocks().stream().filter(
            b -> b.getPosition().z == 0
        ).count() == 9);
    }

    @Test
    public void back() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.back().getBlocks().stream().filter(
            b -> b.getPosition().z == 2
        ).count() == 9);
    }

    @Test
    public void all() throws Exception{

        Cube cube = new Cube();
        assertTrue(cube.all().size() == 27);
    }

    @Test
    public void get() throws Exception{

        Cube cube = new Cube();
        Arrays.stream(Position.values())
            .forEach(
                p -> assertNotNull("Block for position '" + p + "' could not be found.",
                    cube.get(p))
            );
    }
}