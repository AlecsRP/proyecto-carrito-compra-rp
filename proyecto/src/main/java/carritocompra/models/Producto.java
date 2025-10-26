   package carritocompra.models;

   import jakarta.persistence.*;

   //aca quedo la anotacion entity para ser reconocido por mi BD
   @Entity
   @Table(name = "productos")//hace referencia al path
   public class Producto {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String nombre;
      private double precio;
      private String imagen;
      @Column(length = 500)//este es para poder hacer una descripcion breve
      private String descripcion;

      public Producto() {}

      public Producto(Long id, String nombre, double precio, String imagen, String descripcion) {
         this.id = id;
         this.nombre = nombre;
         this.precio = precio;
         this.imagen = imagen;
         this.descripcion = descripcion;
      }

      // getters y setters manuales ya que lombok por alguna extraña razon no funciono
      public Long getId() { return id; }
      public void setId(Long id) { this.id = id; }

      public String getNombre() { return nombre; }
      public void setNombre(String nombre) { this.nombre = nombre; }

      public double getPrecio() { return precio; }
      public void setPrecio(double precio) { this.precio = precio; }

      public String getImagen() { return imagen; }
      public void setImagen(String imagen) { this.imagen = imagen; }

      public String getDescripcion() { return descripcion; }
      public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
   }