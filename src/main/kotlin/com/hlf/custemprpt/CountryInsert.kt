package com.hlf.custemprpt


fun main(args: Array<String>) {

    val insertformat = CountryInsert()
    insertformat.format()

}

class CountryInsert {

    companion object {



        val countries =
                "ABW Aruba \n" +
                        "AFG Afghanistan \n" +
                        "AGO Angola \n" +
                        "AIA Anguilla \n" +
                        "ALA Åland Islands \n" +
                        "ALB Albania \n" +
                        "AND Andorra \n" +
                        "ANT Netherlands Antilles \n" +
                        "ARE United Arab Emirates \n" +
                        "ARG Argentina \n" +
                        "ARM Armenia \n" +
                        "ASM American Samoa \n" +
                        "ATA Antarctica \n" +
                        "ATF French Southern Territories \n" +
                        "ATG Antigua and Barbuda \n" +
                        "AUS Australia \n" +
                        "AUT Austria \n" +
                        "AZE Azerbaijan \n" +
                        "BDI Burundi \n" +
                        "BEL Belgium \n" +
                        "BEN Benin \n" +
                        "BFA Burkina Faso \n" +
                        "BGD Bangladesh \n" +
                        "BGR Bulgaria \n" +
                        "BHR Bahrain \n" +
                        "BHS Bahamas \n" +
                        "BIH Bosnia and Herzegovina \n" +
                        "BLM Saint Barthélemy \n" +
                        "BLR Belarus \n" +
                        "BLZ Belize \n" +
                        "BMU Bermuda \n" +
                        "BOL Bolivia, Plurinational State of \n" +
                        "BRA Brazil \n" +
                        "BRB Barbados \n" +
                        "BRN Brunei Darussalam \n" +
                        "BTN Bhutan \n" +
                        "BVT Bouvet Island \n" +
                        "BWA Botswana \n" +
                        "CAF Central African Republic \n" +
                        "CAN Canada \n" +
                        "CCK Cocos (Keeling) Islands \n" +
                        "CHE Switzerland \n" +
                        "CHL Chile \n" +
                        "CHN China \n" +
                        "CIV Côte d''Ivoire \n" +
                        "CMR Cameroon \n" +
                        "COD Congo, the Democratic Republic of the \n" +
                        "COG Congo \n" +
                        "COK Cook Islands \n" +
                        "COL Colombia \n" +
                        "COM Comoros \n" +
                        "CPV Cape Verde \n" +
                        "CRI Costa Rica \n" +
                        "CUB Cuba \n" +
                        "CXR Christmas Island \n" +
                        "CYM Cayman Islands \n" +
                        "CYP Cyprus \n" +
                        "CZE Czech Republic \n" +
                        "DEU Germany \n" +
                        "DJI Djibouti \n" +
                        "DMA Dominica \n" +
                        "DNK Denmark \n" +
                        "DOM Dominican Republic \n" +
                        "DZA Algeria \n" +
                        "ECU Ecuador \n" +
                        "EGY Egypt \n" +
                        "ERI Eritrea \n" +
                        "ESH Western Sahara \n" +
                        "ESP Spain \n" +
                        "EST Estonia \n" +
                        "ETH Ethiopia \n" +
                        "FIN Finland \n" +
                        "FJI Fiji \n" +
                        "FLK Falkland Islands (Malvinas) \n" +
                        "FRA France \n" +
                        "FRO Faroe Islands \n" +
                        "FSM Micronesia, Federated States of \n" +
                        "GAB Gabon \n" +
                        "GBR United Kingdom \n" +
                        "GEO Georgia \n" +
                        "GGY Guernsey \n" +
                        "GHA Ghana \n" +
                        "GIB Gibraltar \n" +
                        "GIN Guinea \n" +
                        "GLP Guadeloupe \n" +
                        "GMB Gambia \n" +
                        "GNB Guinea-Bissau \n" +
                        "GNQ Equatorial Guinea \n" +
                        "GRC Greece \n" +
                        "GRD Grenada \n" +
                        "GRL Greenland \n" +
                        "GTM Guatemala \n" +
                        "GUF French Guiana \n" +
                        "GUM Guam \n" +
                        "GUY Guyana \n" +
                        "HKG Hong Kong \n" +
                        "HMD Heard Island and McDonald Islands \n" +
                        "HND Honduras \n" +
                        "HRV Croatia \n" +
                        "HTI Haiti \n" +
                        "HUN Hungary \n" +
                        "IDN Indonesia \n" +
                        "IMN Isle of Man \n" +
                        "IND India \n" +
                        "IOT British Indian Ocean Territory \n" +
                        "IRL Ireland \n" +
                        "IRN Iran, Islamic Republic of \n" +
                        "IRQ Iraq \n" +
                        "ISL Iceland \n" +
                        "ISR Israel \n" +
                        "ITA Italy \n" +
                        "JAM Jamaica \n" +
                        "JEY Jersey \n" +
                        "JOR Jordan \n" +
                        "JPN Japan \n" +
                        "KAZ Kazakhstan \n" +
                        "KEN Kenya \n" +
                        "KGZ Kyrgyzstan \n" +
                        "KHM Cambodia \n" +
                        "KIR Kiribati \n" +
                        "KNA Saint Kitts and Nevis \n" +
                        "KOR Korea, Republic of \n" +
                        "KWT Kuwait \n" +
                        "LAO Lao People''s Democratic Republic \n" +
                        "LBN Lebanon \n" +
                        "LBR Liberia \n" +
                        "LBY Libyan Arab Jamahiriya \n" +
                        "LCA Saint Lucia \n" +
                        "LIE Liechtenstein \n" +
                        "LKA Sri Lanka \n" +
                        "LSO Lesotho \n" +
                        "LTU Lithuania \n" +
                        "LUX Luxembourg \n" +
                        "LVA Latvia \n" +
                        "MAC Macao \n" +
                        "MAF Saint Martin (French part) \n" +
                        "MAR Morocco \n" +
                        "MCO Monaco \n" +
                        "MDA Moldova, Republic of \n" +
                        "MDG Madagascar \n" +
                        "MDV Maldives \n" +
                        "MEX Mexico \n" +
                        "MHL Marshall Islands \n" +
                        "MKD Macedonia, the former Yugoslav Republic of \n" +
                        "MLI Mali \n" +
                        "MLT Malta \n" +
                        "MMR Myanmar \n" +
                        "MNE Montenegro \n" +
                        "MNG Mongolia \n" +
                        "MNP Northern Mariana Islands \n" +
                        "MOZ Mozambique \n" +
                        "MRT Mauritania \n" +
                        "MSR Montserrat \n" +
                        "MTQ Martinique \n" +
                        "MUS Mauritius \n" +
                        "MWI Malawi \n" +
                        "MYS Malaysia \n" +
                        "MYT Mayotte \n" +
                        "NAM Namibia \n" +
                        "NCL New Caledonia \n" +
                        "NER Niger \n" +
                        "NFK Norfolk Island \n" +
                        "NGA Nigeria \n" +
                        "NIC Nicaragua \n" +
                        "NIU Niue \n" +
                        "NLD Netherlands \n" +
                        "NOR Norway \n" +
                        "NPL Nepal \n" +
                        "NRU Nauru \n" +
                        "NZL New Zealand \n" +
                        "OMN Oman \n" +
                        "PAK Pakistan \n" +
                        "PAN Panama \n" +
                        "PCN Pitcairn \n" +
                        "PER Peru \n" +
                        "PHL Philippines \n" +
                        "PLW Palau \n" +
                        "PNG Papua New Guinea \n" +
                        "POL Poland \n" +
                        "PRI Puerto Rico \n" +
                        "PRK Korea, Democratic People''s Republic of \n" +
                        "PRT Portugal \n" +
                        "PRY Paraguay \n" +
                        "PSE Palestinian Territory, Occupied \n" +
                        "PYF French Polynesia \n" +
                        "QAT Qatar \n" +
                        "REU Réunion \n" +
                        "ROU Romania \n" +
                        "RUS Russian Federation \n" +
                        "RWA Rwanda \n" +
                        "SAU Saudi Arabia \n" +
                        "SDN Sudan \n" +
                        "SEN Senegal \n" +
                        "SGP Singapore \n" +
                        "SGS South Georgia and the South Sandwich Islands \n" +
                        "SHN Saint Helena, Ascension and Tristan da Cunha \n" +
                        "SJM Svalbard and Jan Mayen \n" +
                        "SLB Solomon Islands \n" +
                        "SLE Sierra Leone \n" +
                        "SLV El Salvador \n" +
                        "SMR San Marino \n" +
                        "SOM Somalia \n" +
                        "SPM Saint Pierre and Miquelon \n" +
                        "SRB Serbia \n" +
                        "STP Sao Tome and Principe \n" +
                        "SUR Suriname \n" +
                        "SVK Slovakia \n" +
                        "SVN Slovenia \n" +
                        "SWE Sweden \n" +
                        "SWZ Swaziland \n" +
                        "SYC Seychelles \n" +
                        "SYR Syrian Arab Republic \n" +
                        "TCA Turks and Caicos Islands \n" +
                        "TCD Chad \n" +
                        "TGO Togo \n" +
                        "THA Thailand \n" +
                        "TJK Tajikistan \n" +
                        "TKL Tokelau \n" +
                        "TKM Turkmenistan \n" +
                        "TLS Timor-Leste \n" +
                        "TON Tonga \n" +
                        "TTO Trinidad and Tobago \n" +
                        "TUN Tunisia \n" +
                        "TUR Turkey \n" +
                        "TUV Tuvalu \n" +
                        "TWN Taiwan, Province of China \n" +
                        "TZA Tanzania, United Republic of \n" +
                        "UGA Uganda \n" +
                        "UKR Ukraine \n" +
                        "UMI United States Minor Outlying Islands \n" +
                        "URY Uruguay \n" +
                        "USA United States \n" +
                        "UZB Uzbekistan \n" +
                        "VAT Holy See (Vatican City State) \n" +
                        "VCT Saint Vincent and the Grenadines \n" +
                        "VEN Venezuela, Bolivarian Republic of \n" +
                        "VGB Virgin Islands, British \n" +
                        "VIR Virgin Islands, U.S. \n" +
                        "VNM Viet Nam \n" +
                        "VUT Vanuatu \n" +
                        "WLF Wallis and Futuna \n" +
                        "WSM Samoa \n" +
                        "YEM Yemen \n" +
                        "ZAF South Africa \n" +
                        "ZMB Zambia \n" +
                        "ZWE Zimbabwe "
    }

    fun dostuff(): String {
        return "hello"
    }

    fun otherstuff(): String = "other"


    fun format() {
        val countriesList: List<String> = countries.split("\n")
        countriesList.mapIndexed { id, it ->
            val code = it.substringBefore(" ")
            val name = it.substring(4)
            "($id,'$code','$name'),"
        }.forEach {it ->  println(it) }
    }

}
