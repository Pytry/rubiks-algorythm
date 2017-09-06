package org.xitikit.rubiks.rubiksalgorythm.actions;

import lombok.NonNull;
import org.xitikit.rubiks.rubiksalgorythm.CubeArgumentException;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Orientation;
import org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static org.xitikit.rubiks.rubiksalgorythm.actions.ActionCode.*;
import static org.xitikit.rubiks.rubiksalgorythm.model.attributes.Position.*;

/**
 * Copyright ${year}
 *
 * @author J. Keith Hoopes
 */
final class PositionPivotUtil{

    private final static Map<String,Position> POSITION_PIVOTS = createPositionPivots();

    /**
     * @param position The current position that needs to be pivoted.
     * @param axis     The Orientation being used as the pivot reference.
     * @param turns    The number of tim,es to pivot.
     *
     * @return the Position resulting from pivoting the input position about the axis.
     */
    static Position pivot(
        @NonNull final Position position,
        @NonNull final Orientation axis,
        @NonNull final Integer turns){

        Position answer = position;
        for(int i = 0; i < turns; i++){
            switch(axis){
                case FRONT:
                    answer = POSITION_PIVOTS.get(
                        F.name() + answer.name()
                    );
                    break;
                case BACK:
                    answer = POSITION_PIVOTS.get(
                        BK.name() + answer.name()
                    );
                    break;
                case LEFT:
                    answer = POSITION_PIVOTS.get(
                        L.name() + answer.name()
                    );
                    break;
                case RIGHT:
                    answer = POSITION_PIVOTS.get(
                        R.name() + answer.name()
                    );
                    break;
                case TOP:
                    answer = POSITION_PIVOTS.get(
                        T.name() + answer.name()
                    );
                    break;
                case BOTTOM:
                    answer = POSITION_PIVOTS.get(
                        B.name() + answer.name()
                    );
                    break;
                default:
                    throw new CubeArgumentException("Orientation not found.");
            }
        }
        return answer;
    }

    final static Map<String,Position> createPositionPivots(){

        Map<String,Position> tmp = new HashMap<>();
        // FRONT
        tmp.put(F.name() + _000.name(), _020);
        tmp.put(F.name() + _010.name(), _120);
        tmp.put(F.name() + _020.name(), _220);
        tmp.put(F.name() + _120.name(), _210);
        tmp.put(F.name() + _220.name(), _200);
        tmp.put(F.name() + _210.name(), _100);
        tmp.put(F.name() + _200.name(), _000);
        tmp.put(F.name() + _100.name(), _010);
        // FRONT COUNTER
        tmp.put(FC.name() + _000.name(), _200);
        tmp.put(FC.name() + _100.name(), _210);
        tmp.put(FC.name() + _200.name(), _220);
        tmp.put(FC.name() + _210.name(), _120);
        tmp.put(FC.name() + _220.name(), _020);
        tmp.put(FC.name() + _120.name(), _010);
        tmp.put(FC.name() + _020.name(), _000);
        tmp.put(FC.name() + _010.name(), _100);
        // BACK
        tmp.put(BK.name() + _002, _022);
        tmp.put(BK.name() + _012, _122);
        tmp.put(BK.name() + _022, _222);
        tmp.put(BK.name() + _102, _012);
        tmp.put(BK.name() + _112, _112);
        tmp.put(BK.name() + _122, _212);
        tmp.put(BK.name() + _202, _002);
        tmp.put(BK.name() + _212, _102);
        tmp.put(BK.name() + _222, _202);
        // BACK COUNTER
        tmp.put(BKC.name() + _002, _202);
        tmp.put(BKC.name() + _012, _102);
        tmp.put(BKC.name() + _022, _002);
        tmp.put(BKC.name() + _102, _212);
        tmp.put(BKC.name() + _112, _112);
        tmp.put(BKC.name() + _122, _012);
        tmp.put(BKC.name() + _202, _222);
        tmp.put(BKC.name() + _212, _122);
        tmp.put(BKC.name() + _222, _022);
        // LEFT
        tmp.put(L.name() + _000, _002);
        tmp.put(L.name() + _001, _102);
        tmp.put(L.name() + _002, _202);
        tmp.put(L.name() + _100, _001);
        tmp.put(L.name() + _101, _101);
        tmp.put(L.name() + _102, _201);
        tmp.put(L.name() + _200, _000);
        tmp.put(L.name() + _201, _100);
        tmp.put(L.name() + _202, _200);
        // LEFT COUNTER
        tmp.put(LC.name() + _000, _200);
        tmp.put(LC.name() + _100, _201);
        tmp.put(LC.name() + _200, _202);
        tmp.put(LC.name() + _001, _100);
        tmp.put(LC.name() + _101, _101);
        tmp.put(LC.name() + _201, _102);
        tmp.put(LC.name() + _002, _000);
        tmp.put(LC.name() + _102, _001);
        tmp.put(LC.name() + _202, _002);
        // RIGHT
        tmp.put(R.name() + _020, _022);
        tmp.put(R.name() + _021, _122);
        tmp.put(R.name() + _022, _222);
        tmp.put(R.name() + _120, _021);
        tmp.put(R.name() + _121, _121);
        tmp.put(R.name() + _122, _221);
        tmp.put(R.name() + _220, _020);
        tmp.put(R.name() + _221, _120);
        tmp.put(R.name() + _222, _220);
        // RIGHT COUNTER
        tmp.put(RC.name() + _020, _220);
        tmp.put(RC.name() + _120, _221);
        tmp.put(RC.name() + _220, _222);
        tmp.put(RC.name() + _021, _120);
        tmp.put(RC.name() + _121, _121);
        tmp.put(RC.name() + _221, _122);
        tmp.put(RC.name() + _022, _020);
        tmp.put(RC.name() + _122, _021);
        tmp.put(RC.name() + _222, _022);
        // TOP
        tmp.put(T.name() + _000, _002);
        tmp.put(T.name() + _001, _012);
        tmp.put(T.name() + _002, _022);
        tmp.put(T.name() + _010, _001);
        tmp.put(T.name() + _011, _011);
        tmp.put(T.name() + _012, _021);
        tmp.put(T.name() + _020, _000);
        tmp.put(T.name() + _021, _010);
        tmp.put(T.name() + _022, _020);
        // TOP COUNTER
        tmp.put(TC.name() + _022, _002);
        tmp.put(TC.name() + _021, _012);
        tmp.put(TC.name() + _020, _022);
        tmp.put(TC.name() + _012, _001);
        tmp.put(TC.name() + _011, _011);
        tmp.put(TC.name() + _010, _021);
        tmp.put(TC.name() + _000, _020);
        tmp.put(TC.name() + _001, _010);
        tmp.put(TC.name() + _002, _000);
        // BOTTOM
        tmp.put(B.name() + _200, _202);
        tmp.put(B.name() + _201, _212);
        tmp.put(B.name() + _202, _222);
        tmp.put(B.name() + _210, _201);
        tmp.put(B.name() + _211, _211);
        tmp.put(B.name() + _212, _221);
        tmp.put(B.name() + _220, _200);
        tmp.put(B.name() + _221, _210);
        tmp.put(B.name() + _222, _220);
        // BOTTOM COUNTER
        tmp.put(BC.name() + _222, _202);
        tmp.put(BC.name() + _221, _212);
        tmp.put(BC.name() + _220, _222);
        tmp.put(BC.name() + _212, _201);
        tmp.put(BC.name() + _211, _211);
        tmp.put(BC.name() + _210, _221);
        tmp.put(BC.name() + _200, _220);
        tmp.put(BC.name() + _201, _210);
        tmp.put(BC.name() + _202, _200);

        return unmodifiableMap(tmp);
    }
}
