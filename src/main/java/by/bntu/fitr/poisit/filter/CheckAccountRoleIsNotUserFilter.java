package by.bntu.fitr.poisit.filter;

import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.constants.AccountRoleConstants;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckAccountRoleIsNotUserFilter")
public class CheckAccountRoleIsNotUserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Account account = (Account) httpServletRequest.getSession().getAttribute("account");
        if (account == null || account.getRoleId() == AccountRoleConstants.ADMIN) {
            httpServletResponse.sendRedirect("/shop/main");
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
