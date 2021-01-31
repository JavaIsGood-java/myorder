package ad.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdIdentityInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception {
		String uri=request.getRequestURI();
		if(uri.endsWith("/a/login")) {
			return true;
		}
		if(request.getSession().getAttribute("adusername")==null) {
			request.getRequestDispatcher("/a/login").forward(request,response);
			return false;
		}
		return true;
	}
}