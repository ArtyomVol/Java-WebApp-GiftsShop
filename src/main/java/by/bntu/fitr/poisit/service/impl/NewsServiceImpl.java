package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.NewsRepository;
import by.bntu.fitr.poisit.service.NewsService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import by.bntu.fitr.poisit.util.InputsChecker;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<Byte> addNews(String imageLink) {
        List<Byte> listWithNewsAddCodes = new ArrayList<>();
        if (!InputsChecker.checkImageLink(imageLink)) {
            listWithNewsAddCodes.add(ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK);
        }
        if (listWithNewsAddCodes.size() == 0) {
            listWithNewsAddCodes.add(ErrorConstant.SUCCESS_NEWS_ADD);
            newsRepository.addNews(imageLink);
        }
        return listWithNewsAddCodes;
    }

    @Override
    public List<String> getAllNewsLinks() {
        return newsRepository.findAllNewsLinks();
    }

}
