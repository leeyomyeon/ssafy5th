package lab.ssafy.corona.medical;

import lab.ssafy.corona.person.Patient;

import java.util.Iterator;
import java.util.List;

public class CDC extends Organization{

    private List<Hospital> hospitalList;
    private List<Patient> patientList;

    public CDC() {}
    public CDC(String name, int employeeCount, List<Hospital> hospitalList, List<Patient> patientList) {
        super(name, employeeCount);
        this.hospitalList = hospitalList;
        this.patientList = patientList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }
    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }
    public List<Patient> getPatientList() {
        return patientList;
    }
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void about() {
        System.out.println("Organization - CDC " + super.getName() );
    }

    public void printPatientList() {
        Iterator<Patient> itr = patientList.iterator();
        while(itr.hasNext()){
            Patient p = itr.next();
            System.out.println(p);
        }
    }
}