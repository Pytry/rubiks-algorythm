package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.model.Block;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
final class BlockPivotUtil{

    static void pivot(
        @NonNull final Block block,
        @NonNull final Integer turns,
        @NonNull final Orientation orientation){

        block.setPosition(
            PositionPivotUtil.pivot(
                block.getPosition(),
                orientation,
                turns
            ));

        block.getPanelList()
            .forEach(
                panel -> panel.setPoint(
                    PointPivotUtil.pivot(
                        panel.getPoint(),
                        orientation,
                        turns,
                        block.getPosition()
                    )
                )
            );
    }
}
