package my.norxiva.petrel.order.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static my.norxiva.petrel.util.JacksonUtils.ISO_DATE_TIME_PATTERN;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "payment_order", uniqueConstraints = @UniqueConstraint(columnNames = {"no", "merchant_no"}))
public class PaymentOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Column(length = 64, nullable = false)
    private String no;

    @Column(name = "merchant_no", length = 64, nullable = false)
    private String merchantNo;

    @Column(name = "channel_type", length = 32)
    private String channelType;

    @Column(name = "payment_type", length = 32, nullable = false)
    private String paymentType;

    @Column(name = "transaction_type", length = 32, nullable = false)
    private String transactionType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "currency_type", length = 32, nullable = false)
    private String currencyType;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    @Column(length = 32, nullable = false)
    private String status;

    @Column(name = "callback_url")
    private String callbackUrl;

    @Column
    private String code;

    @Column
    private String message;

    @Column(name = "bank_acronym", length = 32)
    private String bankAcronym;

    @Column(name = "bank_card_type", length = 32)
    private String bankCardType;

    @Column(name = "id_type", length = 32)
    private String idType;

    @Column(name = "mask_bank_account_no", length = 32)
    private String maskBankAccountNo;

    @Column(name = "mask_bank_account_name")
    private String maskBankAccountName;

    @Column(name = "mask_bank_reserved_phone", length = 32)
    private String maskBankReservedPhone;

    @Column(name = "mask_id_no", length = 32)
    private String maskIdNo;

    private transient String bankAccountNo;

    private transient String bankAccountName;

    private transient String bankReservedPhone;

    private transient String idNo;

}
