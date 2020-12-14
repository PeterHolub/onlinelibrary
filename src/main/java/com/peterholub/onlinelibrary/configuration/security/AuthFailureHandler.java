//package com.peterholub.onlinelibrary.configuration.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class AuthFailureHandler implements AuthenticationFailureHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationFailure(
//    HttpServletRequest request,
//    HttpServletResponse response,
//    AuthenticationException exception
//    ) throws IOException, ServletException {
////        ResponseModel<?, ExceptionError> respModel = new ResponseModel<>(
////        null, new ExceptionError(exception)
////        );
////        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
////        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
////        objectMapper.writeValue(response.getWriter(), respModel);
//    }
//}