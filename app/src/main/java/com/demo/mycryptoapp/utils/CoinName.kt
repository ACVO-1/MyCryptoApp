package com.demo.mycryptoapp.utils

enum class CoinName {
    BITCOIN , ETHEREUM, BITCOIN_CASH , LITECOIN ,  CHAINLINK , POLKADOT  , JUST
}
fun str(name : CoinName):String{
    return name.toString()
}