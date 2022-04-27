package by.bntu.fitr.poisit.service;

import by.bntu.fitr.poisit.dao.repository.NewsRepository;

import java.util.List;

public interface NewsService {
    List<Byte> addNews(String imageLink);
    List<String> getAllNewsLinks();
}
