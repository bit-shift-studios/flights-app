package bitshift.studios.flightsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import bitshift.studios.flightsapp.data.db.airport.AirportDao
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity
import bitshift.studios.flightsapp.data.db.bookmarked.BookmarkedFlightsDao
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedFlightEntity

@Database(
	entities = [AirportEntity::class, BookmarkedFlightEntity::class],
	exportSchema = false,
	version = 1
)
abstract class AppDatabase : RoomDatabase() {
	abstract fun airportDao(): AirportDao
	abstract fun bookmarkedFlightsDao(): BookmarkedFlightsDao

	companion object {
		const val databaseName = "app_database"
	}
}