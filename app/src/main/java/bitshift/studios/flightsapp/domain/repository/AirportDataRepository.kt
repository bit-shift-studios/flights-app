package bitshift.studios.flightsapp.domain.repository

import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

interface AirportDataRepository {
	fun getAirportsByQuery(identifier: String): Flow<List<AirportEntity>>
	suspend fun getAirportByCode(code: String): AirportEntity?
}