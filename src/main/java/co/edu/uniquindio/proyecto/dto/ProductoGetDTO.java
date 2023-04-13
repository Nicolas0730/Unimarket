package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.model.Categoria;
import co.edu.uniquindio.proyecto.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

//Tiene mas información y se usa para recuperar de la BD
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoGetDTO {

    private int codigo;

    private String nombre;

    private String descripcion;

    private int unidades;

    private double precio;

    private int codigoVendedor;




    private LocalDateTime fechaLimite;


    private Estado estado;

    private Categoria categoria;
//creo que ahi se arreglo lo del comentario de abajo

    // private Estado activo; ------ Faltan organizar estas 3, porque el estado activo
    // y las otras dos menos jejeje :3
//    private List<String> imagenes;
//     private  List<Categoria> categorias;



}
