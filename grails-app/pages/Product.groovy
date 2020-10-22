public class Product implements Serializable {
    private String productName;
    private String varientName;
    private String varientSku;


    public Product(String productName, String varientName, String varientSku ) {
        this.productName = productName;
        this.varientName = varientName;
        this.varientSku = varientSku;
    }


    /*
     * Getters and setters for private fields
     */

    String getProductName() {
        return productName
    }

    void setProductName(String productName) {
        this.productName = productName
    }

    String getVarientName() {
        return varientName
    }

    void setVarientName(String varientName) {
        this.varientName = varientName
    }

    String getVarientSku() {
        return varientSku
    }

    void setVarientSku(String varientSku) {
        this.varientSku = varientSku
    }
}