package com.example.uniamerica.pizzaria.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends AbstractEntityDTO {

    @Length(max = 40, message = "No máximo 40 caracteres!")
    private String logradouro;

    private Integer numero;

    @Length(max = 50, message = "No máximo 50 caracteres!")
    private String complemento;

    @NotNull(message = "Insira um bairro!")
    @NotEmpty(message = "Insira um bairro!")
    private String bairro;

    @NotNull(message = "Insira um CEP!")
    @NotEmpty(message = "Insira um CEP!")
    private String cep;
}
