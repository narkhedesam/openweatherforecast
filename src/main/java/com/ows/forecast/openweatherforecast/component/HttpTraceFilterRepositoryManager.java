package com.ows.forecast.openweatherforecast.component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.ows.forecast.openweatherforecast.entity.RequestDbLogger;
import com.ows.forecast.openweatherforecast.repository.RequestDbLoggerRepo;

@Component
public class HttpTraceFilterRepositoryManager extends OncePerRequestFilter{

        @Autowired
        RequestDbLoggerRepo requestDbLoggerRepo;

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
          
            ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(
                    response);
            ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(
                    request);
            try {
                filterChain.doFilter(wrappedRequest, wrappedResponse);
                updateBody(wrappedRequest, wrappedResponse);
            } finally {
                wrappedResponse.copyBodyToResponse();
            }
        }
        public void updateBody(ContentCachingRequestWrapper wrappedRequest,
                               ContentCachingResponseWrapper wrappedResponse) {
            StringBuilder requestBody = getRequestBody(wrappedRequest);
            String url = (wrappedRequest.getQueryString() != null) ? String.join("", wrappedRequest.getRequestURL(),"?" ,wrappedRequest.getQueryString()) : wrappedRequest.getRequestURL().toString() ; 
            logger.info(url);
            logger.info(requestBody);

            StringBuilder responseBody = getResponseBody(wrappedResponse);
            logger.info(responseBody);
            RequestDbLogger request = new RequestDbLogger();
            request.setUrl(url);
            request.setRequest(requestBody == null ? "" : requestBody.toString());
            request.setResponse(responseBody == null ? "" : responseBody.toString());
            requestDbLoggerRepo.save(request);

        }
        protected StringBuilder getRequestBody(ContentCachingRequestWrapper wrappedRequest) {
            try {
                if (wrappedRequest.getContentLength() <= 0) {
                    return null;
                }
                byte[] srcBytes = wrappedRequest.getContentAsByteArray();
                Charset charset = Charset.forName( wrappedRequest.getCharacterEncoding());
                CharsetDecoder decoder = charset.newDecoder();
                ByteBuffer srcBuffer = ByteBuffer.wrap(srcBytes);
                CharBuffer resBuffer = decoder.decode(srcBuffer);
                return new StringBuilder(resBuffer);
            } catch (CharacterCodingException e) {
                logger.error(
                        "Could not read cached response body: " + e.getMessage());
                return null;
            }
        }
        protected StringBuilder getResponseBody(ContentCachingResponseWrapper wrappedResponse) {
            try {
                if (wrappedResponse.getContentSize() <= 0) {
                    return null;
                }
                byte[] srcBytes = wrappedResponse.getContentAsByteArray();
                Charset charset = Charset.forName( wrappedResponse.getCharacterEncoding());
                CharsetDecoder decoder = charset.newDecoder();
                ByteBuffer srcBuffer = ByteBuffer.wrap(srcBytes);
                CharBuffer resBuffer = decoder.decode(srcBuffer);
                return new StringBuilder(resBuffer);
            } catch (CharacterCodingException e) {
                logger.error(
                        "Could not read cached response body: " + e.getMessage());
                return null;
            }
        }
}