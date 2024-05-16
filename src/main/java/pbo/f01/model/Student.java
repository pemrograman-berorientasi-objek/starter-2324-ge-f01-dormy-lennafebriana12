package pbo.f01.model;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "entranceYear", nullable = false)
    private int entranceYear;
    
    @Column(name = "gender", nullable = false, length = 255)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "dorm_id")
    private Dorm dorm;

    public Student() {}

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

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + entranceYear ;
    }
}
