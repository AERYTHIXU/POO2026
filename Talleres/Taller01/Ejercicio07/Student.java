package Talleres.Taller01.Ejercicio07;

public class Student {
    private String name;
    private final int studentId;
    private double[] grades;
    
    public Student(String name, int studentId, double[] grades) {
        if (!setName(name)) { this.name = "Unknown"; }
        this.studentId = studentId;
        this.grades = grades;
    }

    public boolean setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
            return true;
        }
        return false;
    }
    public boolean setGrades(int position, double grades) {
        if ( (position >= 0 && position < this.grades.length) && (grades >= 0.0 && grades <= 5.0)) {
            this.grades[position] = grades;
            return true;
        }
        return false;
    }

    public double calculateAverage() {
        double sumOfTheGrades = 0;
        for (double grade : this.grades) {
            sumOfTheGrades += grade;
        }   
        return sumOfTheGrades / grades.length;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public double[] getGrades() {
        return grades;
    }
}
