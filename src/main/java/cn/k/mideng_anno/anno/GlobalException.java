package cn.k.mideng_anno.anno;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(TokenException.class)
    public String kkk(TokenException to) {
        return to.getMessage();
    }
}
