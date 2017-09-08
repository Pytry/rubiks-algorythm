package test.xitikit.rubiks.rubiksalgorythm.actions;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.actions.CubePrinter;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubePrinterTest{

    @Test
    public void front() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.front(cube).length == 3);
        stream(CubePrinter.front(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void back() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.back(cube).length == 3);
        stream(CubePrinter.back(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void left() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.left(cube).length == 3);
        stream(CubePrinter.left(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void right() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.right(cube).length == 3);
        stream(CubePrinter.right(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void top() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.top(cube).length == 3);
        stream(CubePrinter.top(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void bottom() throws Exception{

        Cube cube = new Cube();
        assertTrue(CubePrinter.bottom(cube).length == 3);
        stream(CubePrinter.bottom(cube))
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void blank() throws Exception{

        assertTrue(CubePrinter.blank().length == 3);
        stream(CubePrinter.blank())
            .forEach(p ->
                assertTrue(p.length == 3)
            );
    }

    @Test
    public void toStringArray() throws Exception{

        assertTrue(CubePrinter.toStringArray(new Cube()).length == 12);
    }

    @Test
    public void cubeString() throws Exception{

        assertEquals("" +
                " *  *  *  R  R  R  *  *  * \n" +
                " *  *  *  R  R  R  *  *  * \n" +
                " *  *  *  R  R  R  *  *  * \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " B  B  B  W  W  W  G  G  G \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  O  O  O  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * \n" +
                " *  *  *  Y  Y  Y  *  *  * ",
            CubePrinter
                .cubeString(
                    CubePrinter
                        .toStringArray(
                            new Cube()
                        )
                )
        );
    }
}