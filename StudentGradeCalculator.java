import java.util.Scanner;

class StudentGrade
{
    int calculateTotalMarks(int[] marks)
    {
        int total = 0;
        for(int i=0;i< marks.length;i++)
        {
            total += marks[i];
        }   
        return total;
    }

    double calculateAveragePercentage(int totalMarks, int numSubjects)
    {
        return  (double) totalMarks / numSubjects;
    }

    char determineGrade(double averagePercentage)
    {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class StudentGradeCalculator 
{

    public static void main(String[] args)
    {
    StudentGrade ob = new StudentGrade();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of subjects: ");
    int numSubjects = scanner.nextInt();
    int marks[] = new int[numSubjects];

    for(int i=0;i < numSubjects;i++)
    {
        System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
        marks[i] = scanner.nextInt();
    }
    System.out.println("Entered Marks for each subjects are:");

    for(int i=0;i < numSubjects;i++)
    {
        System.out.println("Marks for subject " + (i + 1) + " (out of 100) is : "+marks[i]);
    }

    int totalMarks = ob.calculateTotalMarks(marks);

    double averagePercentage = ob.calculateAveragePercentage(totalMarks, numSubjects);

    char grade = ob.determineGrade(averagePercentage);

    System.out.println("Total Marks Obtained: " + totalMarks);
    System.out.println("Average Percentage obtained: " + averagePercentage + "%");
    System.out.println("Grade Scored: " + grade);

    scanner.close();
    

    
    }
}
