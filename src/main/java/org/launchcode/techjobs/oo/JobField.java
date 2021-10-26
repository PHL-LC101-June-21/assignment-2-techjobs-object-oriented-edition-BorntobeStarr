package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    // Fields in common: id, nextId, value
    private int id;
    private static int nextId = 1;
    private String value;

        public JobField (){
            id = nextId;
            nextId++;
        }


    public JobField (String value) {
        this();
        this.value=value;
    }

    @Override
    public String toString(){
            return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


                //getters and setters
                public String getValue(){
                    return value;
                }

                public int getId(){
                    return id;
                }

                public void setValue(String value){
                    this.value = value;
                }
}
