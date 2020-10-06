package com.demo.mycryptoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.mycryptoapp.adapter.CoinInfoAdapter
import kotlinx.android.synthetic.main.activity_coin_price_list.*


class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
//Set Adapter
        val adapter = CoinInfoAdapter()
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(CoinViewModel::class.java)
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })


    }

    //Button
    fun openNetworkPage(view: View) {
        val browserIntent =
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.cryptocompare.com/")
            )
        startActivity(browserIntent)
    }


}


