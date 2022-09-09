package cn.icexmoon.demo.books.system;

import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestControllerAdvice
@Log4j2
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final String[] CONTROLLER_PATH_HEADERS = new String[]{
            "/activiti",
            "/book"
    };
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.debug(serverHttpRequest.getURI().getPath());
        for (String cph :CONTROLLER_PATH_HEADERS){
            if (serverHttpRequest.getURI().getPath().indexOf(cph) == 0){
                if (o instanceof IResult) {
                    return Result.success(o);
                } else if (o == null) {
                    return Result.success(null);
                } else if (o instanceof List){
                    return Result.success(o);
                }
                else {
                    ;
                }
            }
        }
        return o;
    }
}
