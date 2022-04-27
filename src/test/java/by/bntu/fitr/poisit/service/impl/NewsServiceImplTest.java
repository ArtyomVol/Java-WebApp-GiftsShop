package by.bntu.fitr.poisit.service.impl;

import by.bntu.fitr.poisit.dao.repository.NewsRepository;
import by.bntu.fitr.poisit.service.NewsService;
import by.bntu.fitr.poisit.constants.ErrorConstant;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class NewsServiceImplTest {
    @Mock
    private NewsRepository newsRepository;

    private final NewsService newsService;
    private final String correctImageLink = "news1.png";
    private final String incorrectImageLink = "news2.txt";

    public NewsServiceImplTest() {
        MockitoAnnotations.initMocks(this);
        newsService = new NewsServiceImpl(newsRepository);
        List<String> newsLinksMock = new ArrayList<>(Arrays.asList("news1.png", "news2.png", "news3.png"));
        when(newsRepository.findAllNewsLinks()).thenReturn(newsLinksMock);
    }

    @Test
    void getAllNewsLinks_TestReturnedWithCorrectAccountId_NotNull() {
        List<String> shoppingCarts = newsService.getAllNewsLinks();
        assertNotEquals(shoppingCarts, null);
        verify(newsRepository).findAllNewsLinks();
    }

    @Test
    void addNews_TestActionWithIncorrectImageLink_InRepositoryAddNewsWillNotCall() {
        int wantedNumberOfInvocationsInRepositoryAddNews = 0;
        newsService.addNews(incorrectImageLink);
        verify(newsRepository, times(wantedNumberOfInvocationsInRepositoryAddNews)).addNews(anyString());
    }

    @Test
    void addNews_TestActionWithCorrectImageLink_InShoppingRepositoryMethodAddNewsWillCallOneTime() {
        int wantedNumberOfInvocationsInRepositoryAddNews = 1;
        newsService.addNews(correctImageLink);
        verify(newsRepository, times(wantedNumberOfInvocationsInRepositoryAddNews)).addNews(anyString());
    }

    @Test
    void addNews_TestActionWithIncorrectImageLink_ListContainConstantINVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK() {
        List<Byte> listWithAddNewsCode = newsService.addNews(incorrectImageLink);
        assertTrue(listWithAddNewsCode.contains(ErrorConstant.INVALID_NEWS_IMAGE_LINK_EXPRESSION_OR_NO_LINK));
    }

    @Test
    void addNews_TestActionWithCorrectImageLink_ListContainConstantSUCCESS_NEWS_ADD() {
        List<Byte> listWithAddNewsCode = newsService.addNews(correctImageLink);
        assertTrue(listWithAddNewsCode.contains(ErrorConstant.SUCCESS_NEWS_ADD));
    }

}