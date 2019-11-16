package dev.rivaldi.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

class WebClientStockClientIntegrationTest {

  private final WebClient webClient = WebClient.builder().build();

  @Test
  void shouldRetrieveStockPricesFromTheService() {
    WebClientStockClient client = new WebClientStockClient(webClient);
    Flux<StockPrice> stockPrice = client.pricesFor("Rupiah");

    Assertions.assertNotNull(stockPrice);
    Flux<StockPrice> fivePrices = stockPrice.take(5);
    Assertions.assertEquals(5, fivePrices.count().block());
    Assertions.assertEquals("Rupiah", fivePrices.blockFirst().getSymbol());
  }
}
