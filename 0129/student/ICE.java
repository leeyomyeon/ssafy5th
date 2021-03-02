public class ICE extends Student{
    
	public ICE(int studentNum, String studentName, int grade, String majorName, int avrScore, int computerVision,
			int dSP, int commTheory) {
		super(studentNum, studentName, grade, majorName, avrScore);
		this.computerVision = computerVision;
		DSP = dSP;
		this.commTheory = commTheory;
	}
    @Override
    public String toString() {
        return "정보통신공학과" + super.toString() + "[" +
                "컴퓨터비전 =" + computerVision +
                ", 디지털신호처리 =" + DSP +
                ", 통신이론 =" + commTheory +
                "]";
    }
    
	private int computerVision;
    private int DSP;
    private int commTheory;

    public int getComputerVision() {
        return computerVision;
    }

    public void setComputerVision(int computerVision) {
        this.computerVision = computerVision;
    }

    public int getDSP() {
        return DSP;
    }

    public void setDSP(int DSP) {
        this.DSP = DSP;
    }

    public int getCommTheory() {
        return commTheory;
    }

    public void setCommTheory(int commTheory) {
        this.commTheory = commTheory;
    }
}
