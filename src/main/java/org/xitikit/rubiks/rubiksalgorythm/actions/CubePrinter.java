package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.model.Cube;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Point;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
public final class CubePrinter{

    public static String[][] front(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.F_000_).getColor().code + " ",
                " " + cube.get(Point.F_010_).getColor().code + " ",
                " " + cube.get(Point.F_020_).getColor().code + " "
            },
            new String[]{
                " " + cube.get(Point.F_100_).getColor().code + " ",
                " " + cube.get(Point.F_110_).getColor().code + " ",
                " " + cube.get(Point.F_120_).getColor().code + " "
            },
            new String[]{
                " " + cube.get(Point.F_200_).getColor().code + " ",
                " " + cube.get(Point.F_210_).getColor().code + " ",
                " " + cube.get(Point.F_220_).getColor().code + " "
            }
        };
    }

    public static String[][] back(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.BK_202_).getColor().code + " ",
                " " + cube.get(Point.BK_212_).getColor().code + " ",
                " " + cube.get(Point.BK_222_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.BK_102_).getColor().code + " ",
                " " + cube.get(Point.BK_112_).getColor().code + " ",
                " " + cube.get(Point.BK_122_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.BK_002_).getColor().code + " ",
                " " + cube.get(Point.BK_012_).getColor().code + " ",
                " " + cube.get(Point.BK_022_).getColor().code + " "}
        };
    }

    public static String[][] left(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.L_002_).getColor().code + " ",
                " " + cube.get(Point.L_001_).getColor().code + " ",
                " " + cube.get(Point.L_000_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.L_102_).getColor().code + " ",
                " " + cube.get(Point.L_101_).getColor().code + " ",
                " " + cube.get(Point.L_100_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.L_202_).getColor().code + " ",
                " " + cube.get(Point.L_201_).getColor().code + " ",
                " " + cube.get(Point.L_200_).getColor().code + " "}
        };
    }

    public static String[][] right(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.R_020_).getColor().code + " ",
                " " + cube.get(Point.R_021_).getColor().code + " ",
                " " + cube.get(Point.R_022_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.R_120_).getColor().code + " ",
                " " + cube.get(Point.R_121_).getColor().code + " ",
                " " + cube.get(Point.R_122_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.R_220_).getColor().code + " ",
                " " + cube.get(Point.R_221_).getColor().code + " ",
                " " + cube.get(Point.R_222_).getColor().code + " "}
        };
    }

    public static String[][] top(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.T_002_).getColor().code + " ",
                " " + cube.get(Point.T_012_).getColor().code + " ",
                " " + cube.get(Point.T_022_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.T_001_).getColor().code + " ",
                " " + cube.get(Point.T_011_).getColor().code + " ",
                " " + cube.get(Point.T_021_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.T_000_).getColor().code + " ",
                " " + cube.get(Point.T_010_).getColor().code + " ",
                " " + cube.get(Point.T_020_).getColor().code + " "}
        };
    }

    public static String[][] bottom(Cube cube){

        return new String[][]{
            new String[]{
                " " + cube.get(Point.B_202_).getColor().code + " ",
                " " + cube.get(Point.B_212_).getColor().code + " ",
                " " + cube.get(Point.B_222_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.B_201_).getColor().code + " ",
                " " + cube.get(Point.B_211_).getColor().code + " ",
                " " + cube.get(Point.B_221_).getColor().code + " "},
            new String[]{
                " " + cube.get(Point.B_200_).getColor().code + " ",
                " " + cube.get(Point.B_210_).getColor().code + " ",
                " " + cube.get(Point.B_220_).getColor().code + " "}
        };
    }

    public static String[][] blank(){

        return new String[][]{
            new String[]{
                " * ", " * ", " * "
            },
            new String[]{
                " * ", " * ", " * "
            },
            new String[]{
                " * ", " * ", " * "
            }
        };
    }

    public static String[][][] toStringArray(@NonNull final Cube cube){

        return new String[][][]{
            blank(), top(cube), blank(),
            left(cube), front(cube), right(cube),
            blank(), bottom(cube), blank(),
            blank(), back(cube), blank()
        };
    }

    public static String cubeString(@NonNull final Cube cube){

        return cubeString(toStringArray(cube));
    }

    public static String cubeString(@NonNull final String[][][] cube){

        StringBuilder builder = new StringBuilder();
        int x = 0, y = 0, z = 0;
        while(x < 3 && y < 3 && z < 12){
            builder.append(cube[z][x][y]);
            if(y >= 2){
                if(z < 11){
                    if(z % 3 == 2){
                        builder.append("\n");
                    }
                }
                else{
                    break;
                }
                if(x >= 2){

                    x = 0;
                }
                else{
                    x++;
                }
                y = 0;
            }
            else{
                y++;
            }
        }
        return builder.toString();
    }
}