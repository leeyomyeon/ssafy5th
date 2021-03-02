public class CS extends Student{
    
	private int algorithm;
    private int os;
    private int oop;
    public CS(int studentNum, String studentName, int grade, String majorName, int avrScore, int algorithm, int os,
			int oop) {
		super(studentNum, studentName, grade, majorName, avrScore);
		this.algorithm = algorithm;
		this.os = os;
		this.oop = oop;
	}

	@Override
    public String toString() {
        return "컴퓨터공학과" + super.toString() + "["  +
                "알고리즘 =" + algorithm +
                ", 운영체제 =" + os +
                ", 객체지향 =" + oop +
                ']';
    }

   
    

    public int getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(int algorithm) {
        this.algorithm = algorithm;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public int getOop() {
        return oop;
    }

    public void setOop(int oop) {
        this.oop = oop;
    }
}
