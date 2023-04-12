package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.model.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;

    public CompraServicioImpl(CompraRepo compraRepo) {
        this.compraRepo = compraRepo;
    }


    @Override
    public Compra obtenerCompra(Integer idCompra)throws Exception{
        Optional<Compra> compra=compraRepo.findById(idCompra);

        if (!compra.isPresent()) throw new Exception("la compra no existe");
        return compra.get();
    }
//
    @Override
    public int crearCompra(CompraDTO compraDTO) {
        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }
}