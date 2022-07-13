package com.example.cryptoapp.api

import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Query
import com.example.cryptoapp.pojo.CoinInfoListOfData
import com.example.cryptoapp.pojo.CoinPriceInfoRawData


/**
 * Сервис по созданию апи-методов
 */
interface ApiService {

    /**
     * Список самых популярных криптовалют
     * @param [limit] Количество получаемых криптовалют
     * @param [tSym] Валюта в которую конвертируем
     */
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY,
    ): Single<CoinInfoListOfData>


    /**
     * Детальная информация о криптовалюте
     * @param [tSyms] Валюты, в которые конвертируется крипта
     * @param [fSyms] Криптовалюты, выбранные из списка самых популярных
     */
    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"

        private const val API_KEY = "e97ef5cbacb3c46ee81322937821e6051cdf3b7ab5f5bf5cd4e4247fcb19eedb"
        private const val CURRENCY = "USD"
    }
}