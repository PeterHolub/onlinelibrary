//package com.peterholub.onlinelibrary.configuration.security;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Optional;
//
//public class CustomAuthenticationSuccessHandler extends
//SavedRequestAwareAuthenticationSuccessHandler {
//
//    protected final Log logger = LogFactory.getLog(this.getClass());
//
//    private RequestCache requestCache = new HttpSessionRequestCache();
//    private String hashPartParameter;
//
//    @Override
//    public void onAuthenticationSuccess(
//    HttpServletRequest request,
//    HttpServletResponse response,
//    Authentication authentication
//    )
//    throws ServletException, IOException {
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//        String hashPart = Optional.ofNullable(
//        request.getParameter(getHashPartParameter())
//        ).orElse(
//        Arrays.stream(request.getCookies())
//        .filter(c -> c.getName().equals(getHashPartParameter()))
//        .findFirst()
//        .map(Cookie::getValue)
//        .orElse(null)
//        );
//
//        if (savedRequest == null) {
//            if (!StringUtils.isEmpty(hashPart)) {
//                clearAuthenticationAttributes(request);
//                getRedirectStrategy().sendRedirect(request, response, "/" + hashPart);
//            } else {
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//            return;
//        }
//        String targetUrlParameter = getTargetUrlParameter();
//        if (isAlwaysUseDefaultTargetUrl()
//        || (targetUrlParameter != null && StringUtils.hasText(request
//        .getParameter(targetUrlParameter)))) {
//            requestCache.removeRequest(request, response);
//            super.onAuthenticationSuccess(request, response, authentication);
//
//            return;
//        }
//
//        clearAuthenticationAttributes(request);
//
//        // Use the DefaultSavedRequest URL
//        String targetUrl = savedRequest.getRedirectUrl();
//        if (!StringUtils.isEmpty(hashPart)) {
//            if (!targetUrl.endsWith("/")) {
//                targetUrl += "/";
//            }
//            targetUrl += hashPart;
//        }
//        getRedirectStrategy().sendRedirect(request, response, targetUrl);
//    }
//
//    @Override
//    public void setRequestCache(RequestCache requestCache) {
//        this.requestCache = requestCache;
//    }
//
//    public String getHashPartParameter() {
//        return hashPartParameter;
//    }
//
//    public void setHashPartParameter(String hashPartParameter) {
//        this.hashPartParameter = hashPartParameter;
//    }
//
//}