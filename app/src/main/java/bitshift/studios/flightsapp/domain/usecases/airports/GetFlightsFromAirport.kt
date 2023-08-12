package bitshift.studios.flightsapp.domain.usecases.airports

import bitshift.studios.flightsapp.data.FlightsDataMap
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.domain.repository.AirportDataRepository
import kotlinx.coroutines.runBlocking

class GetFlightsFromAirport(private val airportDataRepository: AirportDataRepository) {
	operator fun invoke(code: String): List<AirportEntity> {
		val flights = mutableListOf<AirportEntity>()

		runBlocking {
			val airport = FlightsDataMap[code]

			if (airport != null) {
				for (flight in airport) {
					flights.add(airportDataRepository.getAirportByCode(flight)!!)
				}
			}
		}

		return flights.toList()
	}
}