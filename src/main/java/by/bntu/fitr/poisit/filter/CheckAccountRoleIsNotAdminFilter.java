package by.bntu.fitr.poisit.filter;

import by.bntu.fitr.poisit.entity.Account;
import by.bntu.fitr.poisit.constants.AccountRoleConstants;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckAccountRoleIsNotAdminFilter")
public class CheckAccountRoleIsNotAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Account account = (Account) httpServletRequest.getSession().getAttribute("account");
        if (account == null || account.getRoleId() == AccountRoleConstants.USER) {
            httpServletResponse.sendRedirect("/shop/main");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
