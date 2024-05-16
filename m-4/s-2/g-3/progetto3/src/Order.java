import java.time.LocalDate;
import java.util.List;

public class Order {

    Long id ;
    String status;
    LocalDate OrderDate;
    LocalDate deliveryDate;
    List<Products> products ;
    Customer customer ;

    public Order(Customer customer, LocalDate deliveryDate, Long id, LocalDate orderDate, List<Products> products, String status) {
        this.customer = customer;
        this.deliveryDate = deliveryDate;
        this.id = id;
        this.OrderDate = orderDate;
        this.products = products;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
