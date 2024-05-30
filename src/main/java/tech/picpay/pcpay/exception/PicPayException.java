package tech.picpay.pcpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpStatusCodeException;

public abstract class PicPayException extends RuntimeException{

    public ProblemDetail toProblemaDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return  pb;
    }

    public abstract ProblemDetail toProblemDetail();
}
