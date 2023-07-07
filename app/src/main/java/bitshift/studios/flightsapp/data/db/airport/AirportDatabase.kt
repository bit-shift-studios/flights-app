package bitshift.studios.flightsapp.data.db.airport

import androidx.room.Database
import androidx.room.RoomDatabase
import bitshift.studios.flightsapp.data.db.airport.entities.AirportEntity

@Database(
	entities = [AirportEntity::class],
	exportSchema = false,
	version = 1
)
abstract class AirportDatabase : RoomDatabase() {
	abstract fun dao(): AirportDao
}