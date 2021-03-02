public class Weather {
    private String hour;    // 시간
    private String temp;    // 온도
    private String wfKor;   // 구름 양
    private String reh;     // 습도


    @Override
    public String toString() {
        return "Weather{" +
                "hour='" + hour + '\'' +
                ", temp='" + temp + '\'' +
                ", wfKor='" + wfKor + '\'' +
                ", reh='" + reh + '\'' +
                '}';
    }


    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWfKor() {
        return wfKor;
    }

    public void setWfKor(String wfKor) {
        this.wfKor = wfKor;
    }

    public String getReh() {
        return reh;
    }

    public void setReh(String reh) {
        this.reh = reh;
    }
}
