package com.arruda.uolhost.infra;

import com.arruda.uolhost.enums.GroupType;
import com.arruda.uolhost.services.impl.CodinameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodinameHandler {

    private final CodinameServiceImpl codinameService;

    public String findCodiname(GroupType groupType) {
        if (GroupType.VINGADORES.equals(groupType)) {
            String findFirst = codinameService.getAvengersList().stream().findFirst().orElseThrow();
            codinameService.getAvengersList().remove(findFirst);
            return findFirst;
        }else {
            String findFirst = codinameService.getJusticeLeagueList().stream().findFirst().orElseThrow();
            codinameService.getJusticeLeagueList().remove(findFirst);
            return findFirst;
        }
    }

}
