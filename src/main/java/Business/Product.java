package Business;

import java.util.Objects;

public class Product implements Comparable<Product>{
    /*
    productCode varchar(15) NOT NULL,
                          productName varchar(70) NOT NULL,
                          productLine varchar(50) NOT NULL,
                          productScale varchar(10) NOT NULL,
                          productVendor varchar(50) NOT NULL,
                          productDescription text NOT NULL,
                          quantityInStock smallint(6) NOT NULL,
                          buyPrice double NOT NULL,
                          MSRP double NOT NULL,
                          PRIMARY KEY  (productCode),
                          FOREIGN KEY (productLine) REFERENCES productlines(productLine)
     */
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private double buyPrice;
    private double MSRP;

    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, short quantityInStock, double buyPrice, double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getMSRP() {
        return MSRP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getProductCode(), product.getProductCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductCode());
    }


    //Returns Compare in desc
    @Override
    public int compareTo(Product o) {
        if (this.productCode.compareTo(o.getProductCode()) > 0){
            return -1;
        }else if(this.productCode.compareTo(o.getProductCode()) < 0){
            return +1;
        }else{
            return 0;
        }
    }
}