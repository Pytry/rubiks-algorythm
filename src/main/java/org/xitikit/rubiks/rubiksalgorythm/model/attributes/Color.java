package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public enum Color{

    RED("R"),
    YELLOW("Y"),
    ORANGE("O"),
    WHITE("W"),
    GREEN("G"),
    BLUE("B");

    public final String code;

    Color(String code){

        this.code = code;
    }
}
