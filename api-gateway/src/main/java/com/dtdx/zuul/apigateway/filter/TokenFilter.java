package com.dtdx.zuul.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenFilter
 * @Description filter拦截器，校验请求token是否有效
 * @Author huawei
 * @Date 2019/3/2 20:55
 * @Version 1.0
 **/
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求的上下文内容
        RequestContext currentContext = RequestContext.getCurrentContext();
        //从请求上下文中获取HttpServletRequest
        HttpServletRequest request = currentContext.getRequest();
        //从请求中获取token参数
        String token = request.getParameter("token");
        if(StringUtils.isAllBlank(token)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(400);
            currentContext.setResponseBody("token is empty");
            currentContext.set("isSuccess", false);
        }else {
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSuccess", true);
        }

        return null;
    }
}
