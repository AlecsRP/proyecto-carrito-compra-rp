package carritocompra.models;

public class CarritoSelecc {
    private Producto producto;
    private int cantidad;

    // Constructores
    public CarritoSelecc() {}
    public CarritoSelecc(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    //Lo mismo con mis getters and setters todos manuales ya que no funcionaba lombok
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getSubtotal() {
        if (producto == null) {
            return 0;
        }
        return producto.getPrecio() * cantidad;  //aca me deberia realizar mi funcion
    }
}