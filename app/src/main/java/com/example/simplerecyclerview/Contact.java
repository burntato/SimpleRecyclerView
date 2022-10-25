package com.example.simplerecyclerview;

// RecyclerView items
public class Contact {

    // variables declaration
    private String name, phone, imageUrl;

    // constructor MANDATORY!!
    public Contact(String name, String phone, String imageUrl) {
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    // getter only returns the value

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // setter only sets the value

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
