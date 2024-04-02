package com.arruda.uolhost.services;

import com.arruda.uolhost.model.Player;
import com.arruda.uolhost.rest.api.dtos.PlayerDto;

public interface PlayerService {

    Player createPlayer(PlayerDto playerDto);
}
