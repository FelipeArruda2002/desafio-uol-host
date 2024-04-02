package com.arruda.uolhost.rest.api;

import com.arruda.uolhost.model.Player;
import com.arruda.uolhost.rest.api.dtos.PlayerDto;
import com.arruda.uolhost.services.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody @Valid PlayerDto playerDto) {
        return this.playerService.createPlayer(playerDto);
    }
}
