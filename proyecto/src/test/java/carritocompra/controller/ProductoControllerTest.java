package carritocompra.controller;

import carritocompra.models.Producto;
import carritocompra.service.ProductoServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductoControllerTest {

    @Mock
    private ProductoServiceInterface productoService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductoController productoController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarProductos_devuelveVistaYAgregaProductos() {
        // Arrange
        List<Producto> productos = Arrays.asList(new Producto(), new Producto());
        when(productoService.listarProductos()).thenReturn(productos);

        // Act
        String vista = productoController.listarProductos(model);

        // Assert
        verify(model).addAttribute("productos", productos);
        assertEquals("productos", vista);
    }

    @Test
    public void testVerDetalleProducto_productoNoExiste_redirigeALista() {
        // Arrange
        when(productoService.obtenerProductoPorId(1L)).thenReturn(null);

        // Act
        String vista = productoController.verDetalleProducto(1L, model);

        // Assert
        assertEquals("redirect:/productos", vista);
        verify(model, never()).addAttribute(eq("producto"), any());
    }
}
