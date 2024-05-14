package pbo.f01.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 12S22008 - Rahel Simanjuntak
 * 12S22017 - Lenna Febriana
 */

@Entity
@Table(name = "Dorm")
public class Dorm {
 @Id
 @column (name = "name", nullable = false, length = 255)
 private String name;
 @column (name = "capacity", nullable = false, length = 255)
 private int capacity;
 @column (name = "gender", nullable = false, length = 255)
private String gender;

public Dorm(){
    //empty
}

public Dorm(String name, int capacity, String gender) {
    this.name = name;
    this.capacity = capacity;
    this.gender = gender;
}

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getGender() {
        return gender;
    }
}