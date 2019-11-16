<template>
  <div class="hello">
    <p>This is an example reactive stream from BE</p>
    <ol>
      <li v-for="(stockPrice, idx) in stockPrices"
      :key="idx">
        <p> {{ stockPrice.price }} </p>
        <p> {{ stockPrice.time }} </p>
      </li>
    </ol>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      stockPrices: [{
        price: 0,
        time: new Date(Date.now()),
      }],
    }
  },
  created() {
    this.getStockPrice();
  },
  methods: {
    getStockPrice() {
      const url = "http://localhost:8081/api/stocks/";

      const es = new EventSource(url);
      es.addEventListener('message', ev => {
        this.stockPrices.push((JSON.parse(ev.data)));
      }, false)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
