package org.xitikit.rubiks.rubiksalgorythm.model.attributes;

import org.junit.Test;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertTrue;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Panel.PANELS;

/**
 * Created by Keith on 9/4/2017.
 */
public class PanelTest{

    @Test
    public void size(){

        assertTrue(PANELS.size() == 9 * 6);

        stream(Orientation.values()).forEach(
            o -> assertTrue(PANELS
                .stream()
                .filter(p ->
                    p.getPoint().getOrientation() == o)
                .count() == 9)
        );

        stream(Color.values()).forEach(
            o -> assertTrue(PANELS
                .stream()
                .filter(
                    p -> p.getColor() == o)
                .count() == 9)
        );

        assertTrue(PANELS.stream()
            .map(Panel::getId)
            .distinct()
            .count() == PANELS.size());
    }

    @Test(expected = Exception.class)
    public void listsUnmodifiable(){

        PANELS.add(PANELS.get(0));
    }
}