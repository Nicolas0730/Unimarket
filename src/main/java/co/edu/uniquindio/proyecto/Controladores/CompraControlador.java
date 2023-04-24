package co.edu.uniquindio.proyecto.Controladores;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

        @Autowired
        private final CompraServicio.compraServicio;

        @GetMapping("/obtener")
        Compra obtenerCompra(Integer idCompra)throws Exception;

        @PutMapping("/crear")
        int crearCompra(CompraDTO compraDTO);
        //se debe guardar, además del cliente y el producto (o los productos), la fecha, el total de la compra y el método de pago.

        @GetMapping("/lsita")
        List<CompraGetDTO> listarCompras(int codigoUsuario); //listar compras dado el codigo del usuario

        @GetMapping("/obtener")
        CompraGetDTO obtenerCompra(int codigoCompra);

        //preguntar cual obtener compra dejar
        String emailCompra(String emailUsuarioVendedor, String emailUsuarioComprador, int codigoProducto);


}
