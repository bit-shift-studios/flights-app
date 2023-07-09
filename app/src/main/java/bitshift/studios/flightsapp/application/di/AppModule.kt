package bitshift.studios.flightsapp.application.di

import android.app.Application
import androidx.room.Room
import bitshift.studios.flightsapp.data.db.AppDatabase
import bitshift.studios.flightsapp.data.repository.BookmarkedFlightsDataRepositoryImpl
import bitshift.studios.flightsapp.data.repository.FlightDataRepositoryImpl
import bitshift.studios.flightsapp.domain.repository.FlightDataRepository
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import bitshift.studios.flightsapp.domain.usecases.GetAirportsMatching
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
	fun providesAppDatabase(app: Application): AppDatabase {
		return Room
			.databaseBuilder(
				app.applicationContext,
				AppDatabase::class.java,
				AppDatabase.databaseName
			)
			.createFromAsset("database/flight_search.db")
			.fallbackToDestructiveMigration()
			.build()
	}

	@Provides
	@Singleton
	fun providesFlightDataRepository(db: AppDatabase): FlightDataRepository {
		return FlightDataRepositoryImpl(db.airportDao())
	}

	@Provides
	@Singleton
	fun providesBookmarkedFlightsDataRepository(db: AppDatabase): BookmarkedFlightsDataRepositoryImpl {
		return BookmarkedFlightsDataRepositoryImpl(db.bookmarkedFlightsDao())
	}

	@Provides
	@Singleton
	fun providesAppUseCases(flightDataRepository: FlightDataRepository): AppUseCases {
		return AppUseCases(
			GetAirportsMatching(flightDataRepository)
		)
	}
}