package bitshift.studios.flightsapp.domain.usecases

import bitshift.studios.flightsapp.domain.usecases.airports.GetAirportsMatching
import bitshift.studios.flightsapp.domain.usecases.airports.GetFlightsFromAirport
import bitshift.studios.flightsapp.domain.usecases.bookmarked.BookmarkFlight
import bitshift.studios.flightsapp.domain.usecases.bookmarked.GetBookmarkedFlights

data class AppUseCases (
	val getAirportsMatching: GetAirportsMatching,
	val getFlightsFromAirport: GetFlightsFromAirport,
	val bookmarkFlight: BookmarkFlight,
	val getBookmarkedFlights: GetBookmarkedFlights
)