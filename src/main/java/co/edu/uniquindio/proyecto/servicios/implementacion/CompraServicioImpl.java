package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;



    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setFechaCompra(compra.getFechaCompra());
        compra.setTotalCompra(compra.getTotalCompra());
        compra.setMedioPago(compra.getMedioPago());
        compra.setUsuario(usuarioServicio.obtener(compra.getCodigo()));
        compra.setDetalleCompras(compra.getDetalleCompras());

        return compraRepo.save( compra ).getCodigo();
    }

    @Override
    public List<CompraGetDTO> listarComprasUsuario(int codigoUsuario) throws Exception {

        List<Compra> listaCompra = compraRepo.listarComprasUsuario(codigoUsuario);
        List<CompraGetDTO> respuesta = new ArrayList<>();

        for (Compra c : listaCompra){
            respuesta.add(convertir(c));
        }

        return respuesta;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception {
        return convertir(obtener(codigoCompra));                   //convertir( obtener (codigoCompra) );
    }



    @Override
    public Compra obtener(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        if(compra.isEmpty() )
        {

            throw new Exception("El código "+codigoCompra+" no está asociado a ninguna compra");
        }

        return compra.get();
    }


    private CompraGetDTO convertir (Compra compra){

        CompraGetDTO compraDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFechaCompra(),
                compra.getTotalCompra(),
                compra.getUsuario().getCodigo(),
                compra.getMedioPago(),
                compra.getDetalleCompras()
        );
        return compraDTO;
    }

    private Compra convertir (CompraDTO compraDTO) throws Exception{

        Compra compra = new Compra();

        compra.setUsuario(usuarioServicio.obtener(compraDTO.getCodigoUsuario()));
        compra.setMedioPago(compraDTO.getMetodoPago());
        compra.setMedioPago(compraDTO.getMetodoPago());


        return compra;

    }
}
