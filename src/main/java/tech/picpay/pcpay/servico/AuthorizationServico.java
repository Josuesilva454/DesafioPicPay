package tech.picpay.pcpay.servico;


import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;
import tech.picpay.pcpay.client.AuthorizationResponse;
import tech.picpay.pcpay.client.NotificationClient;
import tech.picpay.pcpay.dto.TransferDto;
import tech.picpay.pcpay.entity.Transfer;
import tech.picpay.pcpay.exception.PicPayException;

@Service
public class AuthorizationServico {

    private final NotificationClient notificationClient;

    public AuthorizationServico(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }


    public boolean isAuthorized(TransferDto transfer) {
        var resp = notificationClient.authored();


        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }
            return resp.getBody().authorized();


        }
    }

