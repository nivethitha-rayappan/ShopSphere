package com.shopsphere.product;

public class DigitalProduct extends Product {
    private double downloadSize;
    private String fileFormat;

    public DigitalProduct(Long id, String name, double price, int quantity, double downloadSize, String fileFormat) {
        super(id, name, price, quantity);
        this.downloadSize = downloadSize;
        this.fileFormat = fileFormat;
    }

    public double getDownloadSize() {
        return downloadSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    @Override
    public String getProductType() {
        return "Digital Product";
    }
}
