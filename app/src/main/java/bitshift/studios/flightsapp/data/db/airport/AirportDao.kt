package bitshift.studios.flightsapp.data.db.airport

import androidx.room.Dao
import androidx.room.Query
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
	@Query(
		"""
			SELECT * FROM airport WHERE LOWER(name) LIKE '%' || LOWER(:identifier) || '%' OR 
			LOWER(iata_code) LIKE '%' || LOWER(:identifier) || '%'
			ORDER BY passengers DESC
		"""
	)
	fun getAirportByQuery(identifier: String): Flow<List<AirportEntity>>

	@Query(
		"""
			SELECT * FROM airport WHERE iata_code = :code
		"""
	)
	suspend fun getAirportByCode(code: String): AirportEntity?
}