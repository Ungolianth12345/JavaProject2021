package Pharmacy;

public class Drug {
    private String brandName;
    private String dosage;
    private double price;
    private String category;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        /*return "Brand name: " + getBrandName() + "\tDosage: " + getDosage() + "\tPrice: " + getPrice() +
                "\tCategory: " + getCategory();*/
        return getBrandName() + "\t" + getDosage() + "\t" + getPrice() + "\t" + getCategory();
    }

    public Drug(String brandName, String dosage, double price, String category) {
        setBrandName(brandName);
        setDosage(dosage);
        setPrice(price);
        setCategory(category);
    }
}
