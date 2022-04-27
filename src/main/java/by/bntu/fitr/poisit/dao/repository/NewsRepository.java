package by.bntu.fitr.poisit.dao.repository;

import java.util.List;

public interface NewsRepository {
    void addNews(String imageLink);
    List<String> findAllNewsLinks();
}
