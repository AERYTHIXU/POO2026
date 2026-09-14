package Talleres.Taller01.Ejercicio07;

public class TestStudent {
    public static void printStudentDetails(Student student) {
            System.out.printf("Student name: %s%n", student.getName());
            System.out.printf("Student ID: %d%n", student.getStudentId());
            System.out.print("Student grades: ");
            for (double grade : student.getGrades()) {
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("%nSTUDENT AVERAGE: %.2f%n", student.calculateAverage());
            System.out.println();
    }
    
    public static void printAllStudentsDetails(Student[] students) {
            System.out.println("\n|| STUDENTS DATA AND AVERAGE ||\n");
        for (Student student : students) {
            printStudentDetails(student);
        }
    }

    public static void testNames(String[] testNames, Student student) {
        System.out.println("\n|| NAMES TEST ||\n");
        System.out.printf("Student selected: %s.%n", student.getName());
        for (String name : testNames) {
            if (student.setName(name)) {
                System.out.printf("Name '%s' succesfully update. Actual name: %s.%n", name, student.getName());
            } else {
                System.out.printf("Name '%s' was rejected. Actual name: %s.%n", name, student.getName());
            }
        }
    }

    public static void testGrades(double[] testGrades, Student student, int position) {
        System.out.println("\n|| GRADES TEST ||\n");
        System.out.printf("Student selected: %s.%n", student.getName());
        System.out.printf("Grade position selected: %d.%n", position + 1);
        for (double grade : testGrades) {
            if (student.setGrades(position, grade)) {
                System.out.printf("Grade '%.2f' succesfully update. Actual grade(%d): %.2f%n", grade, position + 1, student.getGrades()[position]);
            } else {
                System.out.printf("Grade '%.2f' was rejected (out of range).%n", grade);
            }
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[3];
        
        students[0] = new Student("Ana Gómez", 1001, new double[]{4.0, 3.5, 4.5});
        students[1] = new Student("Carlos Pérez", 1002, new double[]{5.0, 4.8, 4.9});
        students[2] = new Student("Sofía Ruiz", 1003, new double[]{3.0, 2.5, 3.2});

        System.out.println("\n||| STUDENTS TEST |||\n");
        printAllStudentsDetails(students);

        String[] testNames = {"", " ", "Camila Suaréz", "Camilo Torres"};
        testNames(testNames, students[2]);

        double[] testGrades = {1, 2 ,3.5 , 4};
        testGrades(testGrades, students[0], 1);
    }
}
