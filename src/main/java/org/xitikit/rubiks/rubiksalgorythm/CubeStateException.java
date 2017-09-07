package org.xitikit.rubiks.rubiksalgorythm;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class CubeStateException extends IllegalStateException{

    CubeStateException(){

    }

    public CubeStateException(final String s){

        super(s);
    }

    CubeStateException(final String message, final Throwable cause){

        super(message, cause);
    }

    public CubeStateException(final Throwable cause){

        super(cause);
    }
}
