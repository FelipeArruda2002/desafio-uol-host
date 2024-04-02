package com.arruda.uolhost.model;

import com.arruda.uolhost.enums.GroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String codiName;
    @Enumerated(EnumType.STRING)
    private GroupType groupType;
}
