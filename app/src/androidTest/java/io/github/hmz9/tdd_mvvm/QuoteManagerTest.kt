package io.github.hmz9.tdd_mvvm

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_wrong_fileName() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssets_invalid_JSON() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()

        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun populateQuoteFromAssets_success_expected_count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(7, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_with_currentIndex_as_first_expected_CorrectQuote() {

        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("First Quote", "1"),
            Quote("Second Quote", "2"),
            Quote("Third Quote", "3")
        ))

        val quote = quoteManager.getPreviousQuote()

        assertEquals("1", quote.author)
    }

    @Test
    fun testPreviousQuote_with_currentIndex_except_first_expected_CorrectQuote() {

        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("First Quote", "1"),
            Quote("Second Quote", "2"),
            Quote("Third Quote", "3")
        ))

        quoteManager.currentQuoteIndex = 2

        val quote = quoteManager.getPreviousQuote()

        assertEquals("2", quote.author)
    }
}