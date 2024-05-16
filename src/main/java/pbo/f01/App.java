package pbo.f01;

import pbo.f01.model.Dorm;
import pbo.f01.model.Student;

import javax.persistence.*;
import java.util.*;

public class App {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dormy_pu");
        EntityManager em = emf.createEntityManager();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] parts = input.split("#");
            String command = parts[0];

            em.getTransaction().begin();

            try {
                switch (command) {
                    case "student-add":
                        String studentId = parts[1];
                        Student existingStudent = em.find(Student.class, studentId);
                        if (existingStudent == null) {
                            Student student = new Student(studentId, parts[2], Integer.parseInt(parts[3]), parts[4]);
                            em.persist(student);
                        } else {
                            // Uncomment for debugging purposes
                            // System.out.println("Student with ID " + studentId + " already exists.");
                        }
                        break;

                    case "dorm-add":
                        String dormName = parts[1];
                        Dorm existingDorm = em.find(Dorm.class, dormName);
                        if (existingDorm == null) {
                            Dorm dorm = new Dorm(dormName, Integer.parseInt(parts[2]), parts[3]);
                            em.persist(dorm);
                        } else {
                            // Uncomment for debugging purposes
                            // System.out.println("Dorm with name " + dormName + " already exists.");
                        }
                        break;

                    case "display-all":
                        List<Dorm> dorms = em.createQuery("SELECT d FROM Dorm d ORDER BY d.name", Dorm.class).getResultList();
                        for (Dorm d : dorms) {
                            System.out.println(d);
                            List<Student> students = new ArrayList<>(d.getStudents());
                            students.sort(Comparator.comparing(Student::getName));
                            for (Student s : students) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case "assign":
                        String studentIdToAssign = parts[1];
                        String dormNameToAssign = parts[2];
                        Student studentToAssign = em.find(Student.class, studentIdToAssign);
                        Dorm dormToAssign = em.find(Dorm.class, dormNameToAssign);
                        if (studentToAssign != null && dormToAssign != null) {
                            if (dormToAssign.getStudents().size() < dormToAssign.getCapacity() && studentToAssign.getGender().equals(dormToAssign.getGender())) {
                                Dorm previousDorm = studentToAssign.getDorm();
                                if (previousDorm != null) {
                                    previousDorm.getStudents().remove(studentToAssign);
                                    em.merge(previousDorm);
                                }
                                studentToAssign.setDorm(dormToAssign);
                                dormToAssign.getStudents().add(studentToAssign);
                                em.merge(studentToAssign);
                                em.merge(dormToAssign);
                            } else {
                                // Uncomment for debugging purposes
                                // System.out.println("Cannot assign student to dorm due to capacity or gender mismatch.");
                            }
                        } else {
                            // Uncomment for debugging purposes
                            // System.out.println("Student or Dorm not found.");
                        }
                        break;

                    default:
                        System.out.println("Unknown command: " + command);
                        break;
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

        em.close();
        emf.close();
        sc.close();
    }
}
