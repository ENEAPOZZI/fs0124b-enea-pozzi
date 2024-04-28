public class Products {

    Long id;
    String name;
    String category;
    Double price;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Products(String category, Long id, String name, Double price) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
