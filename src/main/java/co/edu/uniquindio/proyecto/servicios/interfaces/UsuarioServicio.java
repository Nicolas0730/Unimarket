package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.model.Usuario;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO user) throws Exception; //El tipo de retorno es int porque se va a retornar el codigo con que el usuario se almacena o 0 si no se creo

    int actualizarUsuario( int codigoUsuario, UsuarioDTO userDTO) throws Exception; //el codigo del usuario que voy a modificar y el nuevo usuario con los nuevos datos

    int eliminarUsuario(int codigoUsuario) throws Exception; //Retorna 1 si lo borró, 0 de lo contrario


    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;


    //Dado un codigo,   retorna la lista de los favoritos. O dado un codigo, retorna sus productos. O dado un codigo retorna sus compras

    public Usuario obtener(int codigoUsuario) throws Exception;








}
