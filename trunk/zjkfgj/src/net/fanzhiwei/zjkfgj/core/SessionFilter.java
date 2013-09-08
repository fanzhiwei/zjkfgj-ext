package net.fanzhiwei.zjkfgj.core;


import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
public class SessionFilter implements Filter {  
  
    public void destroy() {  
        // TODO Auto-generated method stub  
  
    }  
  
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
  
        HttpServletRequest httpReq=(HttpServletRequest)req;  
        HttpServletResponse httpRes=(HttpServletResponse)res;  
        HttpSession httpSession=httpReq.getSession();  
        if(httpSession.getAttribute("user")==null){  
            httpRes.sendRedirect("index.jsp");  
        }else{  
            chain.doFilter(req, res);  
        }  
    }  
  
    public void init(FilterConfig arg0) throws ServletException {  
    }  
  
} 
