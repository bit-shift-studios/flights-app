package bitshift.studios.flightsapp.data.db.bookmarked

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedAirportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkedAirportDao {
	@Query(
		"""
			SELECT * FROM bookmarked_airports
		"""
	)
	fun getBookmarkedAirports(): Flow<BookmarkedAirportEntity>

	@Query(
		"""
			SELECT EXISTS (SELECT 1 FROM bookmarked_airports WHERE departureCode = :code LIMIT 1)
		"""
	)
	suspend fun isAirportBookmarked(code: String): Boolean

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	suspend fun addAirportToBookmarks(airport: BookmarkedAirportEntity)

	@Delete
	suspend fun removeAirportFromBookmarks(airport: BookmarkedAirportEntity)
}