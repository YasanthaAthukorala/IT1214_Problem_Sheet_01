class Student{
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId,String name,int daysAttended){
        this.studentId=studentId;
        this.name=name;
        this.daysAttended=daysAttended;
    }
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getDaysAttended(){
        return daysAttended;
    }
    public void setDaysAttended(int daysAttended){
        this.daysAttended=daysAttended;
    }
    public String toString(){
        return "StudentId: " +studentId+ ",Name: " +name+ ",Days Attended: " +daysAttended;
    
    }
}
class Classroom{
    private Student[] students;
    private int count;

    public Classroom(){
        students=new Student[10];
        count=0;
    }

    public void addStudent(Student s){
        if(count < students.length){
            students[count++]=s;
        }else{
            System.out.println("Class room is full.");
        }
    }
    public void updateAttendance(int studentId,int newDaysAttended){
        boolean found=false;
        for(int i=0; i<count; i++){
           if(students[i].getStudentId() == studentId){
           students[i].setDaysAttended(newDaysAttended);
           found = true;
           System.out.println("Attendance updated for studentId: " + studentId);
           break;
        }
    }
    if(!found) {
        System.out.println("Student with ID "+studentId+ "not found.");
    }
}
public void displayStudents(){
    System.out.println("\n---Students Details---");
    for(int i=0; i<count; i++){
       System.out.println(students[i]);
    }
}
}
class StudentAttendance{
    public static void main(String[] args){
    Classroom classroom=new Classroom();

    classroom.addStudent(new Student(101,"Alice Smith", 12));
    classroom.addStudent(new Student(102,"Bob Jones", 15));
    classroom.addStudent(new Student(103,"Carol Lee", 10));

    classroom.updateAttendance(102,16);
    classroom.updateAttendance(104,8);

    classroom.displayStudents();
    }
}









