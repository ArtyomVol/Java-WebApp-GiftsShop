package by.bntu.fitr.poisit.dao;

import by.bntu.fitr.poisit.dao.repository.NewsRepository;
import by.bntu.fitr.poisit.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.bntu.fitr.poisit.constants.SqlQueryConstants.ADD_NEWS;
import static by.bntu.fitr.poisit.constants.SqlQueryConstants.FIND_ALL_NEWS;

public class NewsRepositoryImpl implements NewsRepository {
    @Override
    public void addNews(String imageLink) {
        try(Connection connection = JDBCUtil.getConnection()) {
            JDBCUtil.insertDeleteOrUpdate(ADD_NEWS, connection, imageLink);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> findAllNewsLinks() {
        List<String> news = null;
        try(Connection connection = JDBCUtil.getConnection()) {
            news = JDBCUtil.NewsSQLHandler.selectNews(FIND_ALL_NEWS, connection);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }
}
