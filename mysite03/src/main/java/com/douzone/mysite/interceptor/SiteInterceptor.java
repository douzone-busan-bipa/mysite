package com.dozuone.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dozuone.mysite.service.SiteService;
import com.dozuone.mysite.vo.SiteVo;

public class SiteInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private SiteService siteService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SiteVo site = (SiteVo)request.getServletContext().getAttribute("site");
		if(site == null) {
			site = siteService.getSite();
			request.getServletContext().setAttribute("site", site);
		}
		
		return true;
	}

}
