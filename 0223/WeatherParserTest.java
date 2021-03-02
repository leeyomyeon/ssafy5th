import java.util.List;

public class WeatherParserTest {
    public static void main(String[] args) {
        //http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000
        WeatherSAXParser parser = new WeatherSAXParser();
        List<Weather> list = parser.getWeatherList("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000");

        for(Weather w : list)
            System.out.println(w);
    }
}
