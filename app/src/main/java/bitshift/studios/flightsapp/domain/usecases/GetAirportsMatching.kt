package bitshift.studios.flightsapp.domain.usecases

import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import kotlinx.coroutines.flow.Flow

class GetAirportsMatching(private val flightDataRepository: FlightDataRepository) {
	operator fun invoke(identifier: String): Flow<List<AirportEntity>> {
		return flightDataRepository.getAirportsByQuery(identifier)
	}
}