package bitshift.studios.flightsapp.data.repository

import bitshift.studios.flightsapp.data.db.airport.AirportDao
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlightDataRepositoryImpl @Inject constructor (private val airportDao: AirportDao) : FlightDataRepository {
	override fun getFlightByNameOrCode(identifier: String): Flow<List<AirportEntity>> {
		return airportDao.getFlightByNameOrCode(identifier)
	}

	override fun getFlightsFromAirportByCode(code: String): Flow<List<AirportEntity>> {
		return airportDao.getFlightsFromAirportByCode(code)
	}

	override suspend fun getAirportNameByCode(code: String): String {
		return airportDao.getAirportNameByCode(code)
	}
}