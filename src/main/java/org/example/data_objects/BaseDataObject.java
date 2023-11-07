package org.example.data_objects;

public class BaseDataObject {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0){
            throw new IllegalArgumentException("Data object ID cannot be negative");
        }
        this.id = id;
    }
}
