package bitshift.studios.flightsapp.domain.usecases

import bitshift.studios.flightsapp.domain.usecases.airports.GetAirportsMatching
import bitshift.studios.flightsapp.domain.usecases.airports.GetFlightsFromAirport

data class AppUseCases (
	val getAirportsMatching: GetAirportsMatching,
	val getFlightsFromAirport: GetFlightsFromAirport
)