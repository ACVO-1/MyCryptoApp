package com.demo.mycryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demo.mycryptoapp.api.ApiFactory
import com.demo.mycryptoapp.utils.convertTimestampToTime
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class CoinInfo(
    @SerializedName("Name")
    @Expose
    val name: String? = null,

    //CoinInfoListOfData
    @SerializedName("Data")
    @Expose
    val data: List<CoinInfo>? = null,

    //CoinInfoRawData
    @SerializedName("RAW")
    @Expose
    val coinPriceInfoJsonObject: JsonObject? = null,

    //Datum
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String? = null
) {
    fun getFormattedTime(): String {
        return Date().convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl(): String {
        return ApiFactory.BASE_IMAGE_URL + imageURL
    }
}
