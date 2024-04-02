package com.arruda.uolhost.services.impl;

import com.arruda.uolhost.infra.CodinameHandler;
import com.arruda.uolhost.model.Player;
import com.arruda.uolhost.repositories.PlayerRepository;
import com.arruda.uolhost.rest.api.dtos.PlayerDto;
import com.arruda.uolhost.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final CodinameHandler codinameHandler;

    @Override
    public Player createPlayer(PlayerDto playerDto) {
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        player.setCodiName(codinameHandler.findCodiname(playerDto.groupType()));
        return this.playerRepository.save(player);
    }
}
