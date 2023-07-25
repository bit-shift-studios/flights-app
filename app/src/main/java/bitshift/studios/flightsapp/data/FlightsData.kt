package bitshift.studios.flightsapp.data

val code = AirportCodes

val FlightsDataMap: HashMap<String, List<String>> = code.run {
	hashMapOf(
		OPO to listOf(WAW, AGP, MUC, LIS, ALC),
		ARN to listOf(TXL, WAW, HAM, MUC, BGY, OPO),
		MRS to listOf(BGY, ARN, ATH, LYS, WAW, BCN),
		BGY to listOf(VIE, WAW, SOF, SVO, ALC, AGP, LYS),
		WAW to listOf(AGP, HAM, MAD, ALC, SOF, VIE),
		VIE to listOf(SVO, SOF, HER, TXL, ATH, BGY, FCO),
		SVO to listOf(SOF, ARN, ALC, BCN, MRS, VIE, GVA),
		DUB to listOf(DUS, ZRH, OSL, LIS, CDG, OPO, LYS, VIE),
		SOF to listOf(KEF, MAD, TXL, BCN, MUC, WAW, AGP, CPH),
		CPH to listOf(VIE, HEL, AMS, ATH, WAW, MUC, MAD),
		BRU to listOf(DUB, SOF, DUS, VIE, LIS, ZRH, FCO),
		FCO to listOf(BRU, SVO, AMS, WAW, TXL, ATH, MAD, ALC),
		ATH to listOf(HER, TXL, SVO, AMS, FRA, FCO, DUB, VIE),
		BCN to listOf(LIS, OPO, ZRH, CPH, LYS, SVO, DUS, CDG),
		DUS to listOf(OSL, FRA, MAD, MUC, MRS, SOF, FCO),
		GVA to listOf(FRA, SVO, AGP, SOF, ATH, ZRH, KEF),
		KEF to listOf(BCN, LIS, MRS, CPH, DUS),
		HER to listOf(ALC, AMS, ATH, LIS, OSL, WAW),
		BSL to listOf(SOF, TXL, BCN, VIE, HER, SVO, LIS),
		AGP to listOf(DUB, ALC, FCO, LYS, ATH, HER, FRA),
		HEL to listOf(SOF, WAW, BGY, HAM, CDG, OSL, MRS),
		HAM to listOf(FRA, HER, TXL, ALC, SVO, ARN, DUS, SOF, LIS),
		AMS to listOf(BRU, ZRH, MAD, SVO, CPH, SOF),
		CDG to listOf(TXL, AGP, OSL, ALC, LIS, LYS, VIE),
		MAD to listOf(ZRH, TXL, DUB, KEF, AMS, LIS, BGY, FCO),
		FRA to listOf(WAW, DUS, SVO, LIS, OSL, CDG, ZRH, ALC, VIE),
		TXL to listOf(ARN, OPO, ZRH, AMS, FRA, CDG, SOF, DUS, LYS),
		MUC to listOf(FRA, MRS, ZRH, CPH),
		ALC to listOf(HER, SOF, KEF, ALC, ARN),
		ZRH to listOf(BCN, LYS, BRU, MAD, LIS, SOF),
		LYS to listOf(MRS, WAW, GVA, ATH, HER, BCN, ALC, SOF),
		OSL to listOf(VIE, GVA, FRA, ZRH, DUS, BGY),
		LIS to listOf(TXL, SVO, CPH, BCN, ZRH, CDG, SOF, LYS)
	)
}