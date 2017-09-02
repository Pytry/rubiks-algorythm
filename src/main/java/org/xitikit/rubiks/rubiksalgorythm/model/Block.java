package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Point;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(
    level = AccessLevel.PRIVATE,
    makeFinal = true)
public class Block{

    Position id;

    List<Panel> panelList;

    Map<Point,Panel> panelMap;

    @NonFinal @NonNull
    Position position;

    Block(
        @NonNull final Position id,
        @NonNull final List<Panel> panelList){

        if(panelList.size() < 4){
            throw new CubeArgumentException("A Block cannot have more than 3 panels.");
        }

        this.id = id;
        this.position = id;

        List<Panel> tmpList = new ArrayList<>(3);
        Map<Point,Panel> tmpMap = new HashMap<>(3);

        for(Panel panel : panelList){
            if(panel == null){
                throw new CubeArgumentException("Panel cannot be null.");
            }
            if(tmpMap.containsKey(panel.getId()) || tmpList.contains(panel)){
                throw new CubeArgumentException("Panel must be unique in Block.");
            }
            tmpList.add(panel);
            tmpMap.put(panel.getId(), panel);
        }

        this.panelList = Collections.unmodifiableList(tmpList);
        this.panelMap = Collections.unmodifiableMap(tmpMap);
    }
}
