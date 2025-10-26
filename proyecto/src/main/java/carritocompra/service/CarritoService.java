    package carritocompra.service;

    import carritocompra.models.Carrito;
    import carritocompra.models.CarritoSelecc;
    import carritocompra.service.CarritoServiceInterface;
    import org.springframework.stereotype.Service;
    import java.util.Iterator;

    @Service
    public class CarritoService implements CarritoServiceInterface {

        private Carrito carrito;

        public CarritoService() {
            this.carrito = new Carrito();
        }

        @Override
        public void agregarCarrito(CarritoSelecc producto) {
            carrito.agregarProducto(producto);
        }

        @Override
        public Carrito obtenerCarrito() {
            return carrito;
        }

        @Override
        public void vaciarCarrito() {
            this.carrito = new Carrito();
        }

        @Override
        public void eliminarProducto(Long productoId) {
            Iterator<CarritoSelecc> iterator = carrito.select.iterator();

            while (iterator.hasNext()) {
                CarritoSelecc item = iterator.next();
                if (item.getProducto() != null &&
                        item.getProducto().getId().equals(productoId)) {
                    iterator.remove();
                    break; // Eliminar solo la primera coincidencia
                }
            }
        }
    }