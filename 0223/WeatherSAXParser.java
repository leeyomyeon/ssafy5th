import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherSAXParser {
    private List<Weather> list;
    public List<Weather> getWeatherList(String url) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(new URL(url).openConnection().getInputStream(), handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    private class SAXHandler extends DefaultHandler {
        // list 객체 초기화
        // Element 가 시작될 때 Weather 객체 생성
        // Element 가 끝날 때 정보를 객체에 담고
        // Element 가 끝날 때 data가 끝날 땐 list에 담고 문자는 String에 담는다.
        StringBuilder sb;
        Weather weather;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            list = new ArrayList<>();
            sb = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if(qName.equalsIgnoreCase("data")) {
                weather = new Weather();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if(weather != null) {
                if(qName.equalsIgnoreCase("data")) {
                    list.add(weather);
                }
                else if(qName.equalsIgnoreCase("hour")) {
                    weather.setHour(sb.toString().trim());
                }
                else if(qName.equalsIgnoreCase("temp")) {
                    weather.setTemp(sb.toString().trim());
                }
                else if(qName.equalsIgnoreCase("wfKor")) {
                    weather.setWfKor(sb.toString().trim());
                }
                else if(qName.equalsIgnoreCase("reh")) {
                    weather.setReh(sb.toString().trim());
                }
            }
            sb.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            sb.append(ch, start, length);
        }
    }
}
