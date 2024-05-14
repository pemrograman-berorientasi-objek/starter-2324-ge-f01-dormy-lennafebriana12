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
@Table(name = "Student")
public class Student {
 @Id
 @column (name = "id", nullable = false, length = 255)
 private String id;
 @column (name = "name", nullable = false, length = 255)
 private String name;
 @column (name = "entranceYear", nullable = false, length = 255)
 private int entranceYear;
 @column (name = "gender", nullable = false, length = 255)
private String gender;

public Student(){
    //empty
}

public Student(String id, String name, int entranceYear, String gender) {
    this.id = id;
    this.name = name;
    this.entranceYear = entranceYear;
    this.gender = gender;
}

public String getId() {
    return id;
}

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getGender() {
        return gender;
    }
}
