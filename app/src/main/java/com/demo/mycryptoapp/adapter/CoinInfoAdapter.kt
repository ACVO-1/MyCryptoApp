package com.demo.mycryptoapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.mycryptoapp.R
import com.demo.mycryptoapp.pojo.CoinInfo
import com.demo.mycryptoapp.pojo.CoinInfoListOfData
import com.demo.mycryptoapp.pojo.CoinPriceInfo
import com.demo.mycryptoapp.utils.CoinName
import com.demo.mycryptoapp.utils.str
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*


class CoinInfoAdapter : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]



        with(holder) {
            with(coin) {
                tvSymbols.text = fromSymbol
                tvSymbols2.text = toSymbol
                tvPrice.text = price.toString()


                   tvFullName.text = when (tvSymbols.text) {

                       "BTC" -> str(CoinName.BITCOIN)
                       "ETH" -> str(CoinName.ETHEREUM)
                       "BCH" -> str(CoinName.BITCOIN_CASH)
                       "LTC" -> str(CoinName.LITECOIN)
                       "NEO" -> tvSymbols.text
                       "LINK" -> str(CoinName.CHAINLINK)
                       "DOT" -> str(CoinName.POLKADOT)
                       "EOS" -> tvSymbols.text
                       "XPR" -> tvSymbols.text
                       "JST" -> str(CoinName.JUST)
                       else -> "New coin"
                   }

                tvLastUpdate.text = getFormattedTime()
                Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
            }
        }

    }

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val ivLogoCoin = itemView.ivLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvLastUpdate = itemView.tvLastUpdate
        val tvPrice = itemView.tvPrice
        val tvSymbols2 = itemView.tvSymbols2
        val tvFullName = itemView.tvFullName


    }

    override fun getItemCount(): Int {
        return coinInfoList.size
    }
}