package org.xitikit.rubiks.rubiksalgorythm.model;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public class ColorException extends IllegalStateException{

    private static final String defaultMessage = "All 'Color' enums must be unique for all 'Panel' objects in a CornerBlock.";

    public ColorException(){

        super(defaultMessage);
    }
}
