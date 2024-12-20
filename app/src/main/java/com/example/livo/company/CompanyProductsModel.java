package com.example.livo.company;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CompanyProductsModel implements Parcelable {
    private String name;
    private String description;
    private String quantity;
    private String price;
    private String imageUrl;
    private String modelUrl;
    private String companyID;
    private String status;  // New field for product status
    private String productID;  // Add productID field

    // Empty constructor for Firebase
    public CompanyProductsModel() {
    }

    // Constructor with all fields, including productID
    public CompanyProductsModel(String name, String description, String quantity, String price,
                                String imageUrl, String modelUrl, String companyID, String status, String productID) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
        this.modelUrl = modelUrl;
        this.companyID = companyID;
        this.status = status;  // Initialize the status
        this.productID = productID;  // Initialize the productID
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    // Constructor to recreate the object from a Parcel
    protected CompanyProductsModel(Parcel in) {
        name = in.readString();
        description = in.readString();
        quantity = in.readString();
        price = in.readString();
        imageUrl = in.readString();
        modelUrl = in.readString();
        companyID = in.readString();
        status = in.readString();  // Read the status from the parcel
        productID = in.readString();  // Read the productID from the parcel
    }

    public static final Creator<CompanyProductsModel> CREATOR = new Creator<CompanyProductsModel>() {
        @Override
        public CompanyProductsModel createFromParcel(Parcel in) {
            return new CompanyProductsModel(in);
        }

        @Override
        public CompanyProductsModel[] newArray(int size) {
            return new CompanyProductsModel[size];
        }
    };

    // Getters and setters for all fields including productID
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
        updateStatus();  // Update the status when quantity changes
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // New getter and setter for productID
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    // Update status based on quantity
    public void updateStatus() {
        int qty = Integer.parseInt(quantity);
        if (qty >= 1) {
            this.status = "instock";
        } else {
            this.status = "out of stock";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(quantity);
        parcel.writeString(price);
        parcel.writeString(imageUrl);
        parcel.writeString(modelUrl);
        parcel.writeString(companyID);
        parcel.writeString(status);  // Write the status to the parcel
        parcel.writeString(productID);  // Write the productID to the parcel
    }


}
