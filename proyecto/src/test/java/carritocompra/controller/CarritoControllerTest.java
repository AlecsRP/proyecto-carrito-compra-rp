package carritocompra.controller;

import carritocompra.models.Carrito;
import carritocompra.models.CarritoSelecc;
import carritocompra.models.Producto;
import carritocompra.service.CarritoServiceInterface;
import carritocompra.service.ProductoServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarritoControllerTest {

    @Mock
    private CarritoServiceInterface carritoService;

    @Mock
    private ProductoServiceInterface productoService;

    @Mock
    private Model model;

    @InjectMocks
    private CarritoController carritoController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerCarrito_devuelveVistaYAgregaCarritoAlModelo() {
        // Arrange
        Carrito carrito = new Carrito();
        when(carritoService.obtenerCarrito()).thenReturn(carrito);

        // Act
        String vista = carritoController.verCarrito(model);

        // Assert
        verify(model).addAttribute("carrito", carrito);
        assertEquals("carrito", vista);
    }

    @Test
    public void testAgregarProducto_agregaProductoYRedirige() {
        // Arrange
        Producto producto = new Producto();
        producto.setId(1L);
        when(productoService.obtenerProductoPorId(1L)).thenReturn(producto);

        // Act
        String resultado = carritoController.agregarProducto(1L);

        // Assert
        verify(carritoService, times(1)).agregarCarrito(any(CarritoSelecc.class));
        assertEquals("redirect:/carrito", resultado);
    }
}
