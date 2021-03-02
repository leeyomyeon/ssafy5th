package news;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.List;

public class NewsDAODOMImpl implements INewsDao{
    private List<News> list;

    public List<News> getNewsList(String url) {
        list.removeAll(list);
        connectNews(url);
        return list;
    }
    public News search(int index) {
        return list.get(index);
    }
    void connectNews(String url) {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder parser = f.newDocumentBuilder();
            Document dom = parser.parse(new URL(url).openConnection().getInputStream());
            Element root = dom.getDocumentElement();
            NodeList n = root.getElementsByTagName("item");

            for(int i = 0; i < n.getLength(); i++) {
                News news = new News();
                Node item = n.item(i);
                NodeList kids = item.getChildNodes();

                for(int j = 0; j < kids.getLength(); j++) {
                    Node kid = kids.item(j);
                    String name = kid.getNodeName();
                    if(name.equalsIgnoreCase("title")) {
                        news.setTitle(kid.getFirstChild().getNodeValue());
                    } else if(name.equalsIgnoreCase("link")) {
                        news.setLink(kid.getFirstChild().getNodeValue());
                    } else if(name.equalsIgnoreCase("description")) {
                        news.setDesc(kid.getFirstChild().getNodeValue());
                    }
                }
                System.out.println(news);
                list.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
