package com.example.currencyconvertor.data.model

import android.app.Application
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.example.currencyconvertor.R
import com.example.currencyconvertor.domain.model.DataDomain
import javax.inject.Inject

interface MapCloud {

    fun toDomain(cloud: DataCloud): DataDomain

    class Base @Inject constructor(private val context: Application) : MapCloud {

        override fun toDomain(cloud: DataCloud): DataDomain {

            val template = getDrawable(context, R.drawable.ic_holder_flag)!!

            return DataDomain(
                base = cloud.base,
                date = cloud.date,

                mutableListOf(
                    DataDomain.Rate(
                        rate = 1.0,
                        name = "Российский рубль",
                        abbreviation = "RUB",
                        flag = getDrawable(context, R.drawable.ru) ?: template,
                        isChecked = true
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.uSD,
                        name = "Доллар США",
                        abbreviation = "USD",
                        flag = getDrawable(context, R.drawable.us) ?: template,
                        isChecked = true
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.aUD,
                        name = "Австралийский доллар",
                        abbreviation = "AUD",
                        flag = getDrawable(context, R.drawable.australia) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.aZN,
                        name = "Азербайджанский манат",
                        abbreviation = "AZN",
                        flag = getDrawable(context, R.drawable.azerbayjan) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.gBP,
                        name = "Фунт стерлингов Соединенного королевства",
                        abbreviation = "GBP",
                        flag = getDrawable(context, R.drawable.england) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.aMD,
                        name = "Армянский драм",
                        abbreviation = "AMD",
                        flag = getDrawable(context, R.drawable.armenia) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.bYN,
                        name = "Белорусский рубль",
                        abbreviation = "BYN",
                        flag = getDrawable(context, R.drawable.belorus) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.bGN,
                        name = "Болгарский лев",
                        abbreviation = "BGN",
                        flag = getDrawable(context, R.drawable.bulgaria) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.bRL,
                        name = "Бразильский реал",
                        abbreviation = "BRL",
                        flag = getDrawable(context, R.drawable.brazil) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.hUF,
                        name = "Венгерский форинт",
                        abbreviation = "HUF",
                        flag = getDrawable(context, R.drawable.hungary) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.vND,
                        name = "Вьетнамский донг",
                        abbreviation = "VND",
                        flag = getDrawable(context, R.drawable.vietnam) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.hKD,
                        name = "Гонконгский доллар",
                        abbreviation = "HKD",
                        flag = getDrawable(context, R.drawable.hong_kong) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.gEL,
                        name = "Грузинский лари",
                        abbreviation = "GEL",
                        flag = getDrawable(context, R.drawable.georgia) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.dKK,
                        name = "Датская крона",
                        abbreviation = "DKK",
                        flag = getDrawable(context, R.drawable.denmark) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.aED,
                        name = "Дирхам ОАЭ",
                        abbreviation = "AED",
                        flag = getDrawable(context, R.drawable.uae) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.eUR,
                        name = "Евро",
                        abbreviation = "EUR",
                        flag = getDrawable(context, R.drawable.european_union) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.eGP,
                        name = "Египетский фунт",
                        abbreviation = "EGP",
                        flag = getDrawable(context, R.drawable.egypt) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.iNR,
                        name = "Индийский рупий",
                        abbreviation = "INR",
                        flag = getDrawable(context, R.drawable.india) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.iDR,
                        name = "Индонезийский рупий",
                        abbreviation = "IDR",
                        flag = getDrawable(context, R.drawable.indonesia) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.kZT,
                        name = "Казахстанский тенге",
                        abbreviation = "KZT",
                        flag = getDrawable(context, R.drawable.kazakh) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.cAD,
                        name = "Канадский доллар",
                        abbreviation = "CAD",
                        flag = getDrawable(context, R.drawable.canada) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.qAR,
                        name = "Катарский риал",
                        abbreviation = "QAR",
                        flag = getDrawable(context, R.drawable.qatar) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.kGS,
                        name = "Киргизский сом",
                        abbreviation = "KGS",
                        flag = getDrawable(context, R.drawable.kg) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.cNY,
                        name = "Китайский юань",
                        abbreviation = "CNY",
                        flag = getDrawable(context, R.drawable.china) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.mDL,
                        name = "Молдавский лей",
                        abbreviation = "MDL",
                        flag = getDrawable(context, R.drawable.moldova) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.nZD,
                        name = "Новозеландский доллар",
                        abbreviation = "NZD",
                        flag = getDrawable(context, R.drawable.new_zeland) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.nOK,
                        name = "Норвежская крона",
                        abbreviation = "NOK",
                        flag = getDrawable(context, R.drawable.norway) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.pLN,
                        name = "Польский злотый",
                        abbreviation = "PLN",
                        flag = getDrawable(context, R.drawable.poland) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.rON,
                        name = "Румынский лей",
                        abbreviation = "RON",
                        flag = getDrawable(context, R.drawable.romania) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.xDR,
                        name = "СДР (специальные права заимствования)",
                        abbreviation = "XDR",
                        flag = getDrawable(context, R.drawable.ic_holder_flag) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.sGD,
                        name = "Сингапурский доллар",
                        abbreviation = "SGD",
                        flag = getDrawable(context, R.drawable.singapur) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.tJS,
                        name = "Таджикский сомони",
                        abbreviation = "TJS",
                        flag = getDrawable(context, R.drawable.tajikistan) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.tHB,
                        name = "Таиландский бат",
                        abbreviation = "THB",
                        flag = getDrawable(context, R.drawable.thailand) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.tRY,
                        name = "Турецкая лира",
                        abbreviation = "TRY",
                        flag = getDrawable(context, R.drawable.turkey) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.tMT,
                        name = "Новый туркменский манат",
                        abbreviation = "TMT",
                        flag = getDrawable(context, R.drawable.turkmenistan) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.uZS,
                        name = "Узбекский сум",
                        abbreviation = "UZS",
                        flag = getDrawable(context, R.drawable.uzbekistan) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.uAH,
                        name = "Украинская гривна",
                        abbreviation = "UAH",
                        flag = getDrawable(context, R.drawable.ukraine) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.cZK,
                        name = "Чешская крона",
                        abbreviation = "CZK",
                        flag = getDrawable(context, R.drawable.czech) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.sEK,
                        name = "Шведская крона",
                        abbreviation = "SEK",
                        flag = getDrawable(context, R.drawable.sweden) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.cHF,
                        name = "Швейцарский франк",
                        abbreviation = "CHF",
                        flag = getDrawable(context, R.drawable.switzerland) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.rSD,
                        name = "Сербский динар",
                        abbreviation = "RSD",
                        flag = getDrawable(context, R.drawable.serbia) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.zAR,
                        name = "Южноафриканский рэнд",
                        abbreviation = "ZAR",
                        flag = getDrawable(context, R.drawable.south_africa) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.kRW,
                        name = "Вон Республики Корея",
                        abbreviation = "KRW",
                        flag = getDrawable(context, R.drawable.south_korea) ?: template,
                        isChecked = false
                    ),
                    DataDomain.Rate(
                        rate = cloud.rates.jPY,
                        name = "Японская иена",
                        abbreviation = "JPY",
                        flag = getDrawable(context, R.drawable.japan) ?: template,
                        isChecked = false
                    )
                )
            )
        }
    }
}