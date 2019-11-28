package com.ning.filter;

import com.ning.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 *  最开始是由Spring框架提出的，整合Hibernate框架时使用的时OpenSessionInView
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        SqlSession session = factory.openSession();

        SqlSession session = MyBatisUtil.getSession();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            session.commit();
        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
    }
}
