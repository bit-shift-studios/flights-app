package bitshift.studios.flightsapp.data.db.bookmarked

import androidx.room.Database
import androidx.room.RoomDatabase
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedAirportEntity

@Database(
	entities = [BookmarkedAirportEntity::class],
	exportSchema = false,
	version = 1
)
abstract class BookmarkedAirportsDatabase : RoomDatabase() {
	abstract fun dao(): BookmarkedAirportDao

	companion object {
		val databaseName = "bookmarked_db"
	}
}