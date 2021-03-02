package news;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private boolean flag;
    private List<News> list;
    private StringBuilder sb = null;
    private News n = new News();

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        list = new ArrayList<News>();
        sb = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("item")) {
            n = new News();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(n != null) {
            if(qName.equalsIgnoreCase("title")) {
                n.setTitle(sb.toString().trim());
            } else if(qName.equalsIgnoreCase("desc")) {
                n.setDesc(sb.toString().trim());
            } else if(qName.equalsIgnoreCase("link")) {
                n.setLink(sb.toString().trim());
            } else if(qName.equalsIgnoreCase("item")) {
                list.add(n);
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
