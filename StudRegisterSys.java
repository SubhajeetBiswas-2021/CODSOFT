import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Student
{
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) 
    {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID()
    {
        return studentID;
    }

    public String getName()
    {
        return name;
    }

    public List<Course> getRegisteredCourses() 
    {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) 
    {
        if (registeredCourses.contains(course)) 
        {
            return false;
        }
        if (course.enrollStudent()) 
        {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) 
    {
        if (registeredCourses.remove(course)) 
        {
            course.dropStudent();
            return true;
        }
        return false;
    }
}


class Course 
{
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) 
    {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() 
    {
        return courseCode;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public int getEnrolledStudents() 
    {
        return enrolledStudents;
    }

    public String getSchedule() 
    {
        return schedule;
    }

    public boolean enrollStudent() 
    {
        if (enrolledStudents < capacity) 
        {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() 
    {
        if (enrolledStudents > 0) 
        {
            enrolledStudents--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() 
    {
        return "Course Code: " + courseCode + ", Title: " + title + ", Description: " + description +
                ", Capacity: " + capacity + ", Enrolled Students: " + enrolledStudents + ", Schedule: " + schedule;
    }
}

class StudRegisterSys
{
    private static Map<String, Course> courseMap = new HashMap<>();
    private static Map<String, Student> studentMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) 
    {
        boolean exit = false;
        while (!exit) 
        {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();                                                                // Consume newline

            switch (choice) 
            {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    listCourses();
                    break;
                case 4:
                    registerStudentForCourse();
                    break;
                case 5:
                    dropStudentFromCourse();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Student Course Registration System ---");
        System.out.println("1. Add Course");
        System.out.println("2. Add Student");
        System.out.println("3. List Courses");
        System.out.println("4. Register Student for Course");
        System.out.println("5. Drop Student from Course");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCourse() {
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Course Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Course Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course Schedule: ");
        String schedule = scanner.nextLine();

        Course course = new Course(courseCode, title, description, capacity, schedule);
        courseMap.put(courseCode, course);
        System.out.println("Course added successfully.");
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student student = new Student(studentID, name);
        studentMap.put(studentID, student);
        System.out.println("Student added successfully.");
    }

    private static void listCourses() {
        if (courseMap.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("\nAvailable Courses:");
        for (Course course : courseMap.values()) {
            System.out.println(course);
        }
    }

    private static void registerStudentForCourse() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = studentMap.get(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseMap.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.registerCourse(course)) {
            System.out.println("Student registered for course successfully.");
        } else {
            System.out.println("Failed to register student for course.");
        }
    }

    private static void dropStudentFromCourse() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = studentMap.get(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseMap.get(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.dropCourse(course)) {
            System.out.println("Student dropped from course successfully.");
        } else {
            System.out.println("Failed to drop student from course.");
        }
    }
}