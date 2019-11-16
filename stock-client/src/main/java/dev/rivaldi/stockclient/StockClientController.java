package dev.rivaldi.stockclient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/api/stocks")
public class StockClientController {
  private final WebClientStockClient webClient;

  public StockClientController(WebClientStockClient webClient) {
    this.webClient = webClient;
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<StockPrice> getStockPrices() {
    return webClient.pricesFor("Rupiah");
  }
}
