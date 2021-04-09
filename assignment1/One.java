package assignment1;

import java.util.*; 
import java.lang.*;

/*
    Design a STUDENT class to store roll, name, course, admission date and marks in 5 subjects taken from user.
    Create an array of STUDENT objects. Provide methods corresponding to admission date and receiving marks,
    preparing mark sheet. Support must be there to show the number of students who have taken admission.
    Inherit Student class and override the input method so as to input the department of each student. Search and
    display a sorted list of students of one department or students based on scoring criteria. Create an arraylist of
    students and remove a student based on certain criterion and then call gc() and check for free memory.
*/



class Student{
    protected String roll;
    protected String name;
    protected String course;
    protected String date;
    int marks[]=new int[5];
    public void getData(){    //inputing data for a Student
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name");
        name = myObj.nextLine();
        boolean flag=true;
        do{                         //checking for valid date
            System.out.println("Enter date (DD/MM/YY):");
            date = myObj.nextLine();  
            String s1[]=date.split("/",3);
            if(Integer.parseInt(s1[0])<31&&Integer.parseInt(s1[1])<=12&&Integer.parseInt(s1[2])<=21){
                flag=false;
            }
        }while(flag);
        System.out.println("Enter course:");
        course = myObj.nextLine();
        for(int i=0;i<5;i++){            //getting marks
            System.out.println("Enter marks in subject "+(i+1));
            marks[i] = myObj.nextInt();
        }
    }
    public void showMarkSheet(){             //showing marksheet
        System.out.println("Student Name: " + name);
        System.out.println("Course :" + course);
        System.out.println("The marks in the five subjects are as follows:");
        for(int i=0;i<5;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();
    }
}

class Individual extends Student{
    protected String dept;
    protected String roll;
    protected int total=0;
    protected static int count[] = new int[4];
    public void generateRoll(int x){     //generating roll for the student
        String arr[] = date.split("/",4);
        roll = dept + arr[2] + String.valueOf(count[x-1]);
    }
    @Override
    public void getData(){
        super.getData();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Department:\n1.CSE\n2.ETCE\n3.EE\n4.ME");
        int x = myObj.nextInt();
        switch(x){     //switch case to allocate department
            case 1:
            dept="BCSE";
            count[0]++;
            generateRoll(1);
            break;
            case 2:
            dept="ETCE";
            count[1]++;
            generateRoll(2);
            break;
            case 3:
            dept="EE";
            count[2]++;
            generateRoll(3);
            break;
            case 4:
            dept="ME";
            count[3]++;
            generateRoll(4);
            break;
        }
        for(int i=0;i<5;i++){   //calculating total marks
            total+=marks[i];
        }
    }
    @Override
    public boolean equals(Object o){   //overriding equals function
        if(o==null)return false;
        if(roll.equals(o.roll))return true;
        else
        return false;
    }
    public void showMarkSheet(){
        super.showMarkSheet();
        System.out.println("Department: "+dept);
        System.out.println("Roll: " +roll);
    }
}
class Sort implements Comparator<Individual>{    //implementing comparator on which basis sorting is done for the arrayList
    public int compare(Individual i1,Individual i2){
        return i1.total-i2.total;
    }
}
class Institute{      //class where Individuals/Students are kept
    private ArrayList<Individual> a = new ArrayList<Individual>();
    public void addStudent(){
        Individual s = new Individual();
        s.getData();
        a.add(s);
    }
    private void dept(String s){
        for(int i=0;i<a.size();i++){
            if(a.get(i).dept.equals(s)){
                a.get(i).showMarkSheet();
            }
        }
    }
    public void sortAndDisplayAll(){     //sort and display students according to Total marks
        if(a.size()==0){
            System.out.println("List is empty, add Student");
            return;
        }
        Collections.sort(a,new Sort());
        for(int i=0;i<a.size();i++){
            Individual I = a.get(i);
            I.showMarkSheet();
        }
    }
    public void sortAndDiplayDept(){       //sort and display students of a particular department
        if(a.size()==0){
            System.out.println("List is empty, add Student");
            return;
        }
        Scanner myObj = new Scanner(System.in);
        Collections.sort(a,new Sort());
        System.out.println("Which batch you want:");
        System.out.println("1.BCSE\n2.ETCE\n3.EE\n4.ME");
        int x = myObj.nextInt();
        switch(x){
            case 1:
                dept("BCSE");
                break;
            case 2:
                dept("ETCE");
                break;
            case 3:    
                dept("EE");
                break;
            case 4:
                dept("ME");
                break;
            default:
                break;
        }
        // if(count[x-1]==0){
        //     System.out.println("There is no student in that department as of yet.");
        // }
    }
    public void remove(){     //removing a particular student
        if(a.size()==0){
            System.out.println("List is empty, add Student");
            return;
        }
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your roll:");
        String s=obj.nextLine();
        for(int i=0;i<a.size();i++){
            if(s.equals(a.get(i).roll)){
                a.remove(i);
                System.out.println("Successfully Removed!");
                System.gc();
                return;
            }
        }
        System.out.println("Invalid Roll");
    }
    public void totalStudents(){
        System.out.println("The current number of admitted students is:" + a.size());
    }
}
class One{    //class where main function is stored
    public static void main(String args[]){
        Institute I = new Institute();
        System.out.println
        ("Choose:\n1.Add Student\n2.Display All Students in ascending order of total marks\n3.Display All Depertment Students in ascending order of total marks\n4.Remove Student\n5.Get Number of admitted students\n6.Exit");
        Scanner myObj = new Scanner(System.in);
        int x=1;
        while(x>0){
            System.out.println("Choose:");
            int f = myObj.nextInt();
            switch(f){
                case 1:
                I.addStudent();
                break;
                case 2:
                I.sortAndDisplayAll();
                break;
                case 3:
                I.sortAndDiplayDept();
                break;
                case 4:
                I.remove();
                break;
                case 5:
                I.totalStudents();
                break;
                case 6:
                x=0;
                break;
            }
        }
    }
}