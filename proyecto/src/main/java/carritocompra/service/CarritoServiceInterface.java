package carritocompra.service;

import carritocompra.models.Carrito;
import carritocompra.models.CarritoSelecc;

public interface CarritoServiceInterface {

    void agregarCarrito(CarritoSelecc producto);

    Carrito obtenerCarrito();
    void vaciarCarrito();
    void eliminarProducto(Long productoId);
}
