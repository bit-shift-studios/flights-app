package bitshift.studios.flightsapp.data

val FlightsDataMap = hashMapOf(
	"OPO" to listOf("WAW", "ARN", "MUC", "LIS", "TXL"),
	"WAW" to listOf("OPO", "AGP", "HAM", "MAD", "ALC"),
	"MAD" to listOf("BGY", "SOF", "ZRH", "ALC"),
	"ARN" to listOf("TXL", "WAW", "HAM", "MUC", "BGY", "OPO"),
	"TXL" to listOf("OSL", "BSL", "FCO", "LYS", "ATH", "KEF", "HER"),
	"HER" to listOf("SOF", "ZRH", "TXL", "CPH", "LIS", "ALC", "AGP", "MAD"),
	"BGY" to listOf("FCO", "BSL", "LIS", "MUC", "WAW", "ARN", "OPO", "MAD"),
	"MRS" to listOf("TXL", "BSL", "DUB", "MUC", "DUS", "HER", "OPO", "MAD"),
	"DUB" to listOf("ARN", "ATH", "DUS", "TXL", "SVO"),
	"DUS" to listOf("SOF", "ATH", "ZRH", "HER", "DUB", "OPO", "KEF", "MAD"),
	"BCN" to listOf("FRA", "GRA", "ZRH", "HAM", "BRU", "MUC", "ALC", "LYS"),
	"LYS" to listOf("FCL", "OSL", "VIE", "ORN", "SOF", "MUC", "KEF", "LIS"),
	"FCO" to listOf("FCL", "BSL", "HAM", "ORN", "VIE", "LIS"),
	"LIS" to listOf("OSL", "WAW", "MAD", "ARN", "DUS", "ORN", "DUB"),
	"BSL" to listOf("WAW", "ATH", "CDG", "ALC", "VIE", "FCO", "AMS", "CPH"),
	"HEL" to listOf("TXL", "AGP", "ARN", "ALC", "LYS", "FCO", "AMS", "CPH", "DUB"),
	"OSL" to listOf("TXL", "KEF", "ZRH", "ALC", "LYS", "LIS", "FCO", "ALC", "DUS"),
	"ALC" to listOf("AGP", "SOF", "BGY", "BCN", "OPO", "GRA", "OSL", "VIE")
)