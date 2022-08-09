package kg.megacom.springBootRestService.controllers;

import kg.megacom.springBootRestService.models.BaseResponse;
import kg.megacom.springBootRestService.models.PaymentRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentController {
    final String SHAREDKEY = "SHARED_KEY";
    static final String SUCCESS_STATUS = "success";
    static final String ERROR_STATUS = "error";
    static final int CODE_SUCCESS = 100;
    static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus(){
        return new BaseResponse(SUCCESS_STATUS,1);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request){
        final BaseResponse RESPONSE;
        if(SHAREDKEY.equalsIgnoreCase(key)){
            int userId = request.getUserId();
            String itemId =request.getItemId();
            double discount = request.getDiscount();


            RESPONSE = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        }else
        RESPONSE = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        return RESPONSE;

    }

}
