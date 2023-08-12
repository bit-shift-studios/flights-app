package bitshift.studios.flightsapp.domain.mappers

import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity

class AirportToBookmarkedFlightMapper {
	companion object {
		fun mapAirportToBookmarkedFlight(airport: AirportEntity, departureCode: String): BookmarkedFlightEntity {
			return BookmarkedFlightEntity(
				id = airport.id,
				departureCode = departureCode,
				destinationCode = airport.iataCode
			)
		}
	}
}