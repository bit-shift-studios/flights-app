package bitshift.studios.flightsapp.data.db.airport.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportEntity(
	@PrimaryKey
	val id: Int,
	@ColumnInfo(name = "iata_code")
	val iataCode: String,
	val name: String,
	val passengers: Int
)