package news;

import java.util.List;

public interface INewsDao {
    public List<News> getNewsList(String url);

    public News search(int index);
}
