package io.github.hmz9.tdd_mvvm.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.github.hmz9.tdd_mvvm.models.Quote

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote")
    suspend fun delete()

    @Query("DELETE FROM quote where id = :quoteId")
    suspend fun deleteQuoteById(quoteId: Int)

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quote where id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): Quote
}