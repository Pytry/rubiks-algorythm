package org.xitikit.rubiks.rubiksalgorythm;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeArgumentException extends IllegalArgumentException{

    CubeArgumentException(){

    }

    public CubeArgumentException(final String s){

        super(s);
    }

    CubeArgumentException(final String message, final Throwable cause){

        super(message, cause);
    }

    public CubeArgumentException(final Throwable cause){

        super(cause);
    }
}
