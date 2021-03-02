package news;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsDAOSAXImpl implements INewsDao{
    private List<News> list = new ArrayList<>();

    public List<News> getNewsList(String url) {
        list.removeAll(list);
        connectNews(url);
        return list;
    }

    public News search(int index) {
        return list.get(index);
    }

    private List<News> connectNews(String url) {
        SAXParserFactory f = SAXParserFactory.newInstance();
        try {
            SAXParser parser = f.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(new URL(url).openConnection().getInputStream(), handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
