package carritocompra.service;

import carritocompra.models.Producto;

import java.util.List;

public interface ProductoServiceInterface {
    List<Producto> listarProductos();

    Producto obtenerProductoPorId(Long id);

    Producto guardar(Producto producto);

    void eliminar(Long id);
}
