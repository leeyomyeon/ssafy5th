package lab.ssafy.corona.app;

import lab.ssafy.corona.medical.CDC;
import lab.ssafy.corona.medical.Hospital;
import lab.ssafy.corona.person.Patient;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        // 병원 생성
        Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
        Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);

        // 환자 생성
        Patient p1 = new Patient("환자1", 42, "010-1111-1111", "호흡곤란", "001", true);
        Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", true);

        // 병원 Collection
        List<Hospital> hospitalList = new ArrayList<Hospital>();
        hospitalList.add(univHospital);
        hospitalList.add(localHospital);

        // 환자 Collection
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(p1);
        patientList.add(p2);

        CDC cdc = new CDC("질병관리본부", 200, hospitalList, patientList);
        cdc.about();

        // 병원에 cdc 연결
        univHospital.setCdc(cdc);
        localHospital.setCdc(cdc);

        // 새로운 환자 등록
        Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
        univHospital.addPatient(p3);

        // p3 과 동일정보의 환자로 p3 삭제 시도
        Patient p4 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);
        univHospital.removePatient(p4);

        cdc.printPatientList();
    }
}