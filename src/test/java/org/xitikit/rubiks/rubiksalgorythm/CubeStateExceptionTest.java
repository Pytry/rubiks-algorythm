package org.xitikit.rubiks.rubiksalgorythm;

import org.junit.Test;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeStateExceptionTest{

    @Test(expected = CubeStateException.class)
    public void empty(){

        throw new CubeStateException();
    }

    @Test(expected = CubeStateException.class)
    public void message(){

        throw new CubeStateException("test");
    }

    @Test(expected = CubeStateException.class)
    public void exception(){

        throw new CubeStateException(new Exception());
    }

    @Test(expected = CubeStateException.class)
    public void both(){

        throw new CubeStateException("test", new Exception());
    }
}