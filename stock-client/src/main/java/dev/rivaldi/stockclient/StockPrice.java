package dev.rivaldi.stockclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
  private String symbol;
  private BigDecimal price;
  private LocalDateTime time;
}
