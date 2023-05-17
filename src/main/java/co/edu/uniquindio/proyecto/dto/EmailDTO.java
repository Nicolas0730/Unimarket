package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class EmailDTO {

    private String asunto;

    private String cuerpo;

    private String destinatario;


}
