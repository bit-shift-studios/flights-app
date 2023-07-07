package bitshift.studios.flightsapp.data.db.airport

import androidx.room.Dao
import androidx.room.Query
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
	@Query(
		"""
			SELECT * FROM airport WHERE (name LIKE :identifier OR iata_code LIKE :identifier)
			ORDER BY passengers DESC
		"""
	)
	fun getFlightByNameOrCode(identifier: String): Flow<List<AirportEntity>>

	@Query(
		"""
			SELECT * FROM airport WHERE iata_code = :code
		"""
	)
	fun getFlightsFromAirportByCode(code: String): Flow<List<AirportEntity>>
}