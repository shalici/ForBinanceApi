package com.seziko.BinanceApi.api;

import com.binance.api.client.domain.market.TickerPrice;
import com.seziko.BinanceApi.entities.Binance;
import com.seziko.BinanceApi.results.DataResult;
import com.seziko.BinanceApi.results.Result;
import com.seziko.BinanceApi.results.SuccessDataResult;
import com.seziko.BinanceApi.results.SuccessResult;
import com.seziko.BinanceApi.service.BinanceService;
import org.apache.kafka.clients.admin.NewTopic;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/binance")
public class BinanceController {

    private BinanceService binanceService;

    @Autowired
    public BinanceController(BinanceService binanceService) {
        this.binanceService = binanceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Binance>> getAll(){
        return this.binanceService.getAll();
    }

    @GetMapping("/getFindById")
    public DataResult<Binance> getFindById(@RequestParam Long id){
        return this.binanceService.getFindById(id);
    }

    @PostMapping("/add")
    public Result add(Binance binance){
                return this.binanceService.add(binance);
    }

    @GetMapping("/getfindsembol")
    public DataResult<List<Binance>> getFindBySembol(@RequestParam String sembol){
        return this.binanceService.getFindBySembol(sembol);
    }

    @GetMapping("/getData")
    public SuccessResult getServiceData(@RequestParam String symbol) throws IOException {
        return (SuccessResult) this.binanceService.findBySymbolBinance(symbol);
    }

    @GetMapping("/getAllServiceData")
    public Object getAllServiceData() throws IOException {
        return this.binanceService.getAllServiceData();
    }

    @GetMapping("/listAllPrice")
    public List<TickerPrice> allPriceBinanceApi() {
        return this.binanceService.allPriceBinanceApi();
    }

    @PostMapping("/findBySymbolFromBinance")
    public Result findBySymbolBinance(@RequestParam String symbol) throws IOException {
        return this.binanceService.findBySymbolBinance(symbol);
    }

    @GetMapping("/webSocket")
    public SuccessDataResult connectBinanceWebSocket(String symbol){
        return this.binanceService.connectBinanceWebSocket(symbol);
    }

    @GetMapping("/findBySortList")
    public DataResult<List<Binance>> getAllSorted(){
        return this.binanceService.getAllSorted();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Binance>> getAllByPage(int pageNo, int pageSize) {
        return this.binanceService.getAll(pageNo,pageSize);
    }
    @GetMapping("/findbycount")
    public Result findByCount(){
        return this.binanceService.findByCount();
    }

    @GetMapping("/wsClose")
    public Result wsClose(String symbol) throws IOException {
        return this.binanceService.closeWs(symbol);
    }

    @GetMapping("/symbolAndPrice")
    public List<Binance> getBySymbolAndPrice(String symbolName,String price){
        return this.binanceService.getBySymbolAndPrice(symbolName,price);
    }




}
