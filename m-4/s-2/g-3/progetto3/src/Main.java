public class Main {
    public static void main(String[] args) {


        Products product1 = new Products("libri", 1L, "Product1", 10.99);
        Products product2 = new Products("info", 2L, "Product2", 20.99);
        Products product3 = new Products("sport", 3L, "Product3", 30.99);
        Products product4 = new Products("libri", 4L, "Product4", 40.99);
        Products product5 = new Products("info", 5L, "Product5", 50.99);
        Products product10 = new Products("libri", 6L, "Product10", 100.99);

        // istanze dei castomer

        Customer customer1 = new Customer(1L, "Customer1", 1);
        Customer customer2 = new Customer(2L, "Customer2", 2);
        Customer customer3 = new Customer(3L, "Customer3", 3);
        Customer customer4 = new Customer(4L, "Customer4", 1);
        Customer customer5 = new Customer(5L, "Customer5", 2);


    }
}