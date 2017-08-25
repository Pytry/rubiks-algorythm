package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static java.util.Arrays.stream;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@SuppressWarnings("WeakerAccess")
@FieldDefaults(makeFinal = true)
public final class SideValidator{

    public static boolean isValidSide(Side side){

        return side != null
            && isValidBlockTable(side.getTable());
    }

    public static boolean isValidBlockTable(Block[][] table){

        return table != null
            && table.length == 3
            && isValidSideRow(table[0])
            && isValidMiddleRow(table[0])
            && isValidSideRow(table[2]);
    }

    public static boolean isValidMiddleRow(Block[] row){

        return row != null
            && row.length == 3
            && isValidSideBlock(row[0])
            && isValidMiddleBlock(row[1])
            && isValidSideBlock(row[2]);
    }

    public static boolean isValidSideRow(Block[] row){

        return row != null
            && row.length == 3
            && isValidCornerBlock(row[0])
            && isValidSideBlock(row[1])
            && isValidCornerBlock(row[2]);
    }

    public static boolean isValidMiddleBlock(Block block){

        return block != null && block instanceof MiddleBlock;
    }

    public static boolean isValidSideBlock(final Block block){

        return block != null && block instanceof SideBlock;
    }

    public static boolean isValidCornerBlock(final Block block){

        return block != null && block instanceof CornerBlock;
    }

    public static void validateColors(Color one){

        if(anyColorIsNull(one)){

            throw new ColorException();
        }
    }

    public static void validateColors(Color one, Color two){

        if(anyColorIsNull(one, two)
            || one == two){

            throw new ColorException();
        }
    }

    public static void validateColors(Color one, Color two, Color three){

        if(anyColorIsNull(one, two, three)
            || one == two
            || two == three
            || three == one){

            throw new ColorException();
        }
    }

    public static boolean anyColorIsNull(Color... colors){

        return colors == null
            || colors.length < 1
            || stream(colors)
            .anyMatch(
                Objects::isNull
            );
    }

    private static
}
