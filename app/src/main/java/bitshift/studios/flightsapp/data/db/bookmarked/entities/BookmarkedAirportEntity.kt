package bitshift.studios.flightsapp.data.db.bookmarked.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked")
data class BookmarkedAirportEntity(
	@PrimaryKey
	val id: Int,
	val departureCode: String,
	val arrivalCode: String
)