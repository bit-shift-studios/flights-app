package bitshift.studios.flightsapp.application.di

import android.app.Application
import androidx.room.Room
import bitshift.studios.flightsapp.data.db.AppDatabase
import bitshift.studios.flightsapp.data.repository.BookmarkedFlightsDataRepositoryImpl
import bitshift.studios.flightsapp.data.repository.AirportDataRepositoryImpl
import bitshift.studios.flightsapp.domain.repository.AirportDataRepository
import bitshift.studios.flightsapp.domain.usecases.AppUseCases
import bitshift.studios.flightsapp.domain.usecases.GetAirportsMatching
import bitshift.studios.flightsapp.domain.usecases.GetFlightsFromAirport
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
	fun providesAirportDataRepository(db: AppDatabase): AirportDataRepository {
		return AirportDataRepositoryImpl(db.airportDao())
	}

	@Provides
	@Singleton
	fun providesBookmarkedFlightsDataRepository(db: AppDatabase): BookmarkedFlightsDataRepositoryImpl {
		return BookmarkedFlightsDataRepositoryImpl(db.bookmarkedFlightsDao())
	}

	@Provides
	@Singleton
	fun providesAppUseCases(airportDataRepository: AirportDataRepository): AppUseCases {
		return AppUseCases(
			GetAirportsMatching(airportDataRepository),
			GetFlightsFromAirport(airportDataRepository)
		)
	}
}