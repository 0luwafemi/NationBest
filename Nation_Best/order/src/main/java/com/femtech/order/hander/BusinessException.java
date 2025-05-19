package com.femtech.order.hander;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends Throwable {
    private final String message;
}
