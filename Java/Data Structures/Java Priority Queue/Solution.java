import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
import java.util.*;
class Student{
    int id;
    String name;
    double cgpa;
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    int getID(){
        return id;
    }
    String getName(){
        return name;
    }
    double getCGPA(){
        return cgpa;
    }
}
class stucomparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.getCGPA()==s2.getCGPA()){
            if(s1.getName()==s2.getName()){
                if(s1.getID()>s2.getID()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                return s1.getName().compareTo(s2.getName());
            }
        }
        else{
            double delta= s1.getCGPA()-s2.getCGPA();
            if(delta>0)return -1;
            else return 1;
        }
    }
}
class Priorities{
    public List<Student> getStudents(List<String> events) {
 PriorityQueue<Student> pq=new PriorityQueue<Student>(events.size(),new stucomparator());
        for(String e : events){
            Scanner s = new Scanner(e);
            String query = s.next();
            if(query.equals("SERVED")){
                pq.poll();
            }
            else if(query.equals("ENTER")){
                String name = s.next();
                double cgpa = s.nextDouble();
                int id = s.nextInt();
                Student stu = new Student(id, name, cgpa);
                pq.add(stu);
            }
        }
        List<Student> remaining = new ArrayList<Student>();
        while(!pq.isEmpty()){
            remaining.add(pq.poll());
        }
        return remaining;
    }
}
