package bitshift.studios.flightsapp.data.repository

import bitshift.studios.flightsapp.data.db.bookmarked.BookmarkedFlightsDao
import bitshift.studios.flightsapp.data.db.bookmarked.entities.BookmarkedAirportEntity
import bitshift.studios.flightsapp.domain.repository.BookmarkedFlightsDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkedFlightsDataRepositoryImpl @Inject constructor (
	private val bookmarkedFlightsDao: BookmarkedFlightsDao
) : BookmarkedFlightsDataRepository {
	override fun getBookmarkedAirports(): Flow<List<BookmarkedAirportEntity>> {
		return bookmarkedFlightsDao.getBookmarkedAirports()
	}

	override suspend fun isAirportBookmarked(code: String): Boolean {
		return bookmarkedFlightsDao.isAirportBookmarked(code)
	}

	override suspend fun addAirportToBookmarks(airport: BookmarkedAirportEntity) {
		return bookmarkedFlightsDao.addAirportToBookmarks(airport)
	}

	override suspend fun removeAirportFromBookmarks(airport: BookmarkedAirportEntity) {
		return bookmarkedFlightsDao.removeAirportFromBookmarks(airport)
	}
}