package com.filadacreche.demo.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class TeacherCreateDto {

//    Por algum motivo nao é possível ter um dto com apenas um atributo porque da problema no
//    no parse do json da requisião http, entao vai ficar com esse outro parametro que nao serve
//    para nada
    String name;
    UUID useless;

}
