package tech.picpay.pcpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicPayException{
    private Long walletId;

    public WalletNotFoundException(Long walletId) {
        this.walletId = walletId;
    }


    public ProblemDetail problemDetail(){
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Wallet not found");
        pd.setDetail("There is no wallet with id " + walletId + ".");

        return pd;
    }
}
