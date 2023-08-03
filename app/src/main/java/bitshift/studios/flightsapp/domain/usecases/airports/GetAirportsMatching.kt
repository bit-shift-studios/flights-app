package bitshift.studios.flightsapp.domain.usecases.airports

import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.AirportDataRepository
import kotlinx.coroutines.flow.Flow

class GetAirportsMatching(private val airportDataRepository: AirportDataRepository) {
	operator fun invoke(identifier: String): Flow<List<AirportEntity>> {
		return airportDataRepository.getAirportsByQuery(identifier)
	}
}