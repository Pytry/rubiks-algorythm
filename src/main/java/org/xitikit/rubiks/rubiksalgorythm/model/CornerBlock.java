package org.xitikit.rubiks.rubiksalgorythm.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CornerBlock implements Block{

    List<Panel> panelList;

    public CornerBlock(
        @NonNull Panel one,
        @NonNull Panel two,
        @NonNull Panel three){

        SideValidator.validateColors(
            one.getColor(),
            two.getColor(),
            three.getColor());

        panelList = unmodifiableList(
            asList(
                new CornerPanel(one,two,three),
                new CornerPanel(two, three, one),
                new CornerPanel(three, one, two))
        );
    }

    public class CornerPanel extends Panel{

        private final Panel value;
        private final Panel left;
        private final Panel up;

        private CornerPanel(
            @NonNull final Panel value,
            @NonNull final Panel left,
            @NonNull final Panel up){

            super(value.getColor());
            this.value = value;
            this.left = left;
            this.up = up;
        }
    }
}
