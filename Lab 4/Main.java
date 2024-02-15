/**
@date 2-7-2024
@description Lab 3: This class we use an ArrayList to modify, create, and manipulate Student objects.

*/


public class Main {
    
    public static void main(String args[]) {
   		LabArrayLists lab = new LabArrayLists();
   		//write code to call addStudent method. Provide necessary arguments while calling
         lab.addStudent(1, "Jeremy", 3.5);
         lab.addStudent(2, "Naomi", 3.8);
         lab.addStudent(3, "Jessica", 3.5);
         lab.addStudent(4, "Tom", 3.4);
         lab.addStudent(5, "Carlos", 3);
   		lab.printValues();
         
   		//write code to call FindStudentWithHighestCGPA method. Catch the ID and print it in next line
         int highest = lab.FindStudentWithHighestCGPA();
         System.out.println("StudentID with Highest CGPA: " + highest);
         
   		//write code to call FindStudentWithLowestCGPA method. Catch the ID and print it in next line
         int lowest = lab.FindStudentWithLowestCGPA();
         System.out.println("StudentID with Lowest CGPA: " + lowest);
   		
   		//write code to call addStudentAtPosition3 method.  Provide necessary arguments while calling
         lab.addStudentAtPosition(9, "Novak", 2.4, 3);
   		lab.printValues();
   		System.out.println();
         
         
         // move students
         System.out.println("Sorting Students ");
         highest = lab.FindStudentWithHighestCGPA();
         lowest = lab.FindStudentWithLowestCGPA();
         // move students with highest gpa to index 0
         lab.moveStudents(highest, 0);
         // move student with lowest gpa to last index
         int lastIndex = lab.studentList.size() - 1;
         lab.moveStudents(lowest, lastIndex);
         lab.printValues();
         
         
         // write code to call removeAll
         lab.removeAll();
         lab.printValues();
         System.out.println("All students removed! ");
         
   		
   }
}
