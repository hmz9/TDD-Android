package io.github.hmz9.tdd_mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import io.github.hmz9.tdd_mvvm.db.QuoteDatabase
import io.github.hmz9.tdd_mvvm.models.Quote
import io.github.hmz9.tdd_mvvm.models.dao.QuotesDao
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.Assert.*

class QuotesDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setUp(){

        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insert_quote_to_db_expected_single_quote() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Hamza")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(1, result.size)
        assertEquals("This is a test quote", result[0].text)

    }

    @Test
    fun delete_quote_to_db_expected_empty_list() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Hamza")
        quotesDao.insertQuote(quote)

        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(0, result.size)
    }

    @After
    fun tearDown(){
        quoteDatabase.close()
    }
}