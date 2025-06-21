import java.util.Scanner;

class Course{
    String courseName;
    int durationInMonths;
    
    public Course(String courseName, int durationInMonths){
        this.courseName = courseName;
        this.durationInMonths = durationInMonths;
    }
    
    public void displayCourseInfo(){
        System.out.println("Course Name is " + courseName + " And Course Duration is " + durationInMonths + " months.");
    }
}

class Student {
    String name;
    int rollNo;
    int age;
    Course course;
    
    public Student(String name, int rollNo, int age, Course course){
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.course = course;
    }
    
    public void display(){
        System.out.println(" Name : " + name + " Age : " + age + " Roll Number : " + rollNo);
        course.displayCourseInfo();
    }
    
    
    public void isAdult(){
        if(age >= 18){
            System.out.println(name + " is Adult");
        }else{
            System.out.println(name + "is Not Adult");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        
        System.out.print("Enter Your Name here : ");
        String name = sc.nextLine();
        
        System.out.print("Enter Your Roll No here : ");
        int rollNo = sc.nextInt();
        
        System.out.print("Enter Your Age here : ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Course Name : ");
        String courseName = sc.nextLine();
        
        System.out.print("Enter Course Duration (in months) : ");
        int durationInMonths = sc.nextInt();
        
        
        Course course = new Course(courseName, durationInMonths);
        Student student = new Student(name, rollNo, age, course);
        
        student.display();
        student.isAdult();
        
        sc.close();
    }
}