package org.example;

import org.example.data_objects.BaseDataObject;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class DataObjectManager<T extends BaseDataObject> {
    protected int idCounter = 0;

    protected ArrayList<T> objects = new ArrayList<>();

    public void addNewObject(T newObject){
        boolean idExists = objects.stream()
                .anyMatch(o -> o.getId() == newObject.getId());

        if (idExists){
            throw new IllegalArgumentException("An object with that ID already exists in this data object manager");
        }
        setNewId(newObject);

        objects.add(newObject);
    }

    private void setNewId(T newObject) {
        if(newObject.getId() == 0){
            int newId = generateNewId();
            newObject.setId(newId);
        } else if(newObject.getId() > idCounter){
            idCounter = newObject.getId();
        }
    }

    private int generateNewId() {
        idCounter ++;
        return idCounter;
    }
    public ArrayList<T> getAllObjects(){
        return objects;
    }

    public T getObjectById(int objectId) throws NoSuchElementException {

            return objects.stream()
                    .filter(o -> o.getId() == objectId)
                    .toList()
                    .get(0); // would use gitFirst if v j21
    }


}
