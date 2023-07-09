package bitshift.studios.flightsapp.data.repository

import bitshift.studios.flightsapp.data.db.airport.AirportDao
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlightDataRepositoryImpl @Inject constructor (private val airportDao: AirportDao) : FlightDataRepository {
	override fun getAirportsByQuery(identifier: String): Flow<List<AirportEntity>> {
		return airportDao.getAirportByQuery(identifier)
	}

	override suspend fun getAirportByCode(code: String): AirportEntity? {
		return airportDao.getAirportByCode(code)
	}
}