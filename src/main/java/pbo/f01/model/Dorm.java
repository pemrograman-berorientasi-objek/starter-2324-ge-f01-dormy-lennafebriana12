package pbo.f01.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Dorm")
public class Dorm {
    @Id
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "capacity", nullable = false, length = 255)
    private int capacity;
    
    @Column(name = "gender", nullable = false, length = 255)
    private String gender;

    @OneToMany(mappedBy = "dorm")
    private List<Student> students = new ArrayList<>();

    public Dorm() {}

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name + "|" + gender + "|" + capacity + "|" + (students != null ? students.size() : 0);
    }
}
