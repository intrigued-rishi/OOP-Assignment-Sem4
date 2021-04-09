import java.util.*;

/*

Design and create a hospital information system with the following scenarios.
● Register a new patient.
● Each patient is assigned to one doctor, but a doctor can have any number of patients. Patients check in to the
hospital and assigned a doctor if they don't already have one.
● While in the hospital, doctors record various observations about each patient at various times. Examples of
observations are blood pressure and temperature. Record test results for a patient.
● The hospital keeps track of all the observations for a given patient until they check out of the hospital. Obtain
all of a patient’s information given the social security number.

*/


class Patient{
    String name;
    int id;
    static int curr=0;
    int bp;
    int temp;
    Patient(String s){
        id=++curr;
        name=s;
    }
    public void generateReport(){
        temp=(int)(Math.random()*14) + 90;
        bp = (int)(Math.random()*20) + 70;
    }
    public void showReport(){
        if(bp==0&&temp==0){
            System.out.println("The patient has yet not been checked by an doctor, kindly wait");
            return;
        }
        System.out.println("*****Report*****");
        System.out.println("Name: "+name);
        System.out.println("Blood Pressure: "+bp);
        System.out.println("Temperature: "+temp);
        System.out.println("*****Take Care of you Health*****");
    }
}

class Doctor implements Comparable<Doctor>{
    String name;
    int p;
    ArrayList<Patient> a=new ArrayList<Patient>();
    public Doctor(String s){
        p=0;
        name=s;
    }
    public int compareTo(Doctor d){
        return (p-d.p);
    }
    void increment(){
        p++;
    }
}

class Hospital{
    Queue<Patient> patient ;
    PriorityQueue<Doctor> doctor ;
    Hospital(){
        patient = new LinkedList<>();
        doctor = new PriorityQueue<Doctor>();
    }
    public void addPatient(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter patient name:");
        String s =  obj.nextLine();
        Patient p = new Patient(s);
        patient.add(p);
    }
    public void addDoctor(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter doctor name:");
        String s =  obj.nextLine();
        Doctor d = new Doctor(s);
        doctor.add(d);
    }
    public void assignPatient(){
        if(patient.size()==0){
            System.out.println("No patients registered.");
            return;
        }
        if(doctor.size()==0){
            System.out.println("No doctors appointed as of yet");
            return;
       }
        Doctor d = doctor.remove();
        System.out.println("Assigned to Dr."+d.name);
        d.increment();
        Patient p = patient.remove();
        d.a.add(p);
        p.generateReport();
        doctor.add(d);
        p.showReport();
    }
    public void showAllPatientsActive(){
        if(patient.size()==0){
            System.out.println("No Patients waiting.");
            return;
        }
        for(Patient p:patient){
            System.out.println("Name: "+p.name);
            System.out.println("Id: "+p.id);
            System.out.println();
        }
    }
    public void printAll(){
        int k=doctor.size();
        for(int i=0;i<k;i++){
            Doctor d = doctor.remove();
            System.out.println(d.p);
        }
    }
}

class Six{
    public static void main(String args[]){
        Hospital h = new Hospital();
        Scanner sc = new Scanner(System.in);
        int x=1,i;
        System.out.println("1.Add Doctor\n2.Add Patient\n3.Assign first patient in the queue to a doctor and check that patient out");
        System.out.println("4.Show All Patients Currently present in hospital\n0.Exit");
        while(x>0){
            System.out.println("Enter value");
            i=sc.nextInt();
            switch(i){
                case 1:
                    h.addDoctor();
                    break;
                case 2:
                    h.addPatient();
                    break;
                case 3:
                    h.assignPatient();
                    break;
                case 4:
                    h.showAllPatientsActive();
                    break;
                case 0:
                    x=0;
            }
        }
    }
}