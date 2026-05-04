package org.sbwarehouseapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferStockDTO {

    private Long fromProductId;
    private Long toProductId;
    private Integer quantity;
}