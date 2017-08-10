package my.norxiva.petrel.endpoint.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static my.norxiva.petrel.util.JacksonUtils.ISO_DATE_TIME_PATTERN;

@Slf4j
@Data
public class CreateOrderRequest {

    @NotNull
    private String no;

    @NotNull
    private String merchantNo;

    private String channelType;

    @NotNull
    private String paymentType;

    @NotNull
    private String transactionType;

    @NotNull
    private BigDecimal amount;

    private String currencyType = "CNY";

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    @NotNull
    private LocalDateTime orderTime;

    private String callbackUrl;

    private String bankAccountNo;

    private String bankAccountName;

    private String bankReservedPhone;

    private String idNo;

}
