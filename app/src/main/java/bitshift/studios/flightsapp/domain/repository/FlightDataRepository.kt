package bitshift.studios.flightsapp.domain.repository

import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

interface FlightDataRepository {
	fun getFlightByNameOrCode(identifier: String): Flow<List<AirportEntity>>
	fun getFlightsFromAirportByCode(code: String): Flow<List<AirportEntity>>
	suspend fun getAirportNameByCode(code: String): String
}