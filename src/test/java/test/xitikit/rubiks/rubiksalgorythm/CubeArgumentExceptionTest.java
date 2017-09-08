package test.xitikit.rubiks.rubiksalgorythm;

import org.junit.Test;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeArgumentExceptionTest{

    @Test(expected = CubeArgumentException.class)
    public void empty(){

        throw new CubeArgumentException();
    }

    @Test(expected = CubeArgumentException.class)
    public void message(){

        throw new CubeArgumentException("test");
    }

    @Test(expected = CubeArgumentException.class)
    public void exception(){

        throw new CubeArgumentException(new Exception());
    }

    @Test(expected = CubeArgumentException.class)
    public void both(){

        throw new CubeArgumentException("test", new Exception());
    }
}