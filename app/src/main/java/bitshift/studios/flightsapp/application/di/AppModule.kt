package bitshift.studios.flightsapp.application.di

import android.app.Application
import androidx.room.Room
import bitshift.studios.flightsapp.data.db.airport.AirportDatabase
import bitshift.studios.flightsapp.data.db.bookmarked.BookmarkedFlightsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun providesAirportDatabase(app: Application): AirportDatabase {
		return Room
			.databaseBuilder(
				app.applicationContext,
				AirportDatabase::class.java,
				AirportDatabase.databaseName
			)
			.createFromAsset("database/flight_search.db")
			.fallbackToDestructiveMigration()
			.build()
	}

	@Provides
	@Singleton
	fun providesBookmarkedFlightsDatabase(app: Application): BookmarkedFlightsDatabase {
		return Room
			.databaseBuilder(
				app.applicationContext,
				BookmarkedFlightsDatabase::class.java,
				BookmarkedFlightsDatabase.databaseName
			)
			.fallbackToDestructiveMigration()
			.build()
	}
}