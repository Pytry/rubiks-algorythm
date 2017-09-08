package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.CubeStateException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllBytes;
import static java.util.stream.Collectors.toList;

/**
 * Created by Keith on 9/4/2017.
 */
public class ActionParser{

    public static List<Action> parse(@NonNull final String actionScript){

        return convertToActionClass(actionScript.replace("\r\n", "\n").split("\n"));
    }

    private static List<Action> convertToActionClass(String... actions){

        return Arrays.stream(actions)
            .map(
                s -> {
                    String[] tmp = s.split(" ");

                    if(tmp.length != 2){
                        throw new CubeArgumentException("Script must conatain a single command followed by an integer on each line, and there must be at least one line");
                    }
                    return convert(tmp[0], tmp[1]);
                }
            )
            .collect(toList());
    }

    private static Action convert(String code, String turns){

        if(code == null
            || "".equals(code.trim())
            || turns == null
            || "".equals(turns.trim())){
            throw new CubeArgumentException("Invalid input " +
                "for code '" + code + "' " +
                "and turns '" + turns + "'.");
        }
        return new Action(convert(code), convertToInteger(turns));
    }

    private static int convertToInteger(String turns){

        try{
            return Integer.valueOf(turns);
        }
        catch(NumberFormatException e){

            throw new CubeArgumentException("Invalid integer found for turns '" + turns + "'");
        }
    }

    private static ActionCode convert(String code){

        try{
            return ActionCode.valueOf(code);
        }
        catch(Exception e){
            throw new CubeStateException("Unknown value found for ActionCode");
        }
    }

    /**
     * Reads the file indicated by the path and converts it into a String.
     *
     * @param path String
     *
     * @return String
     */
    public static String read(@NonNull final String path){

        try{
            return new String(
                readAllBytes(
                    Paths.get(path)
                )
            );
        }
        catch(IOException e){
            throw new CubeArgumentException(e);
        }
    }

    public static List<Action> readAndParseActionScript(@NonNull final String path){

        return parse(read(path));
    }
}
