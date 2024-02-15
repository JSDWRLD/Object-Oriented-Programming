
/**
@date 2-7-2024
@description Lab 3: This class we use an ArrayList to modify, create, and manipulate Student objects.
*/

import java.util.ArrayList;

/**
 * The Student class represents a student with an ID number, name, and CGPA.
 */
class Student {
    
    /** The ID number of the student. */
    int idNumber;
    
    /** The name of the student. */
    String name;
    
    /** The CGPA (Cumulative Grade Point Average) of the student. */
    double cgpa;
   
    /**
     * Constructs a new Student object with the specified ID number, name, and CGPA.
     *
     * @param idNumber the ID number of the student
     * @param name the name of the student
     * @param cgpa the CGPA of the student
     */
    Student(int idNumber, String name, double cgpa) {
        this.idNumber = idNumber;
        this.name = name;
        this.cgpa = cgpa;
    }
}

/**
 * Represents a list of students and provides methods to manipulate student data.
 */
public class LabArrayLists {

    /** The list of students. */
	ArrayList<Student> studentList = new ArrayList<>();
   
	/**
	 * Prints details of all students in the list.
	 */
	public void printValues() {
		for(Student student: studentList) {
			System.out.println("Name: " + student.name);
			System.out.println("CGPA: " + student.cgpa);
			System.out.println("IDNumber: " + student.idNumber);
			System.out.println();
		}
	}
	
	/**
	 * Adds a new student to the list.
	 *
	 * @param idNumber the ID number of the student
	 * @param name the name of the student
	 * @param cgpa the CGPA of the student
	 */
	public void addStudent(int idNumber, String name, double cgpa){
		studentList.add(new Student(idNumber, name, cgpa));
	}
	
	/**
	 * Finds the ID of the student with the highest CGPA.
	 *
	 * @return the ID of the student with the highest CGPA
	 */
	public int FindStudentWithHighestCGPA() {
		double highest = Integer.MIN_VALUE;
		int indexId = 0;
		for(Student student : studentList){
			if (student.cgpa > highest){
				highest = student.cgpa;
				indexId = student.idNumber;
			}
		}
		return indexId;
	}
	
	/**
	 * Finds the ID of the student with the lowest CGPA.
	 *
	 * @return the ID of the student with the lowest CGPA
	 */
	public int FindStudentWithLowestCGPA() {
		double lowest = Integer.MAX_VALUE;
		int indexId = 0;
		for(Student student : studentList){
			if (student.cgpa < lowest){
				lowest = student.cgpa;
				indexId = student.idNumber;
			}
		}
		return indexId;
	}
	
	/**
	 * Adds a new student at the specified position in the list.
	 *
	 * @param idNumber the ID number of the student
	 * @param name the name of the student
	 * @param cgpa the CGPA of the student
	 * @param pos the position at which to add the student
	 */
	public void addStudentAtPosition(int idNumber, String name, double cgpa, int pos){
		studentList.add(pos, new Student(idNumber, name, cgpa));
	}
	
	/**
	 * Removes a student from the list based on the specified ID.
	 *
	 * @param ID the ID of the student to remove
	 * @return true if the student is found and removed, false otherwise
	 */
	public boolean removeStudentsFromArrayList(int ID) {
		for(Student student: studentList){
			if( ID == student.idNumber ){
				return true;
			} 
		}
		return false;
	}
   
	/**
	 * Removes all students from the list.
	 */
	public void removeAll(){
		while(!studentList.isEmpty()){
			studentList.remove(0);
		}
		System.out.println(studentList);
	}
   
	/**
	 * Moves a student with the given ID to the specified position in the list.
	 *
	 * @param ID the ID of the student to move
	 * @param pos the position to which to move the student
	 * @return true if the student is found and moved, false otherwise
	 * @throws IllegalArgumentException if the specified position is out of bounds
	 */
   public boolean moveStudents(int ID, int pos){
		if(pos > studentList.size()){
			throw new IllegalArgumentException("Out of Bounds");
		}
		String tempName = "";
		int tempId;
		double tempGpa;
		int index = 0;
		for(Student student : studentList){
			if(student.idNumber == ID){
				tempName = student.name;
				tempId = student.idNumber;
				tempGpa = student.cgpa;
				studentList.remove(index);
				studentList.add(pos, new Student(tempId, tempName, tempGpa));
				return true;
			}
			index++;
		}
		return false;
   }
}
