package io.github.hmz9.tdd_mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.hmz9.tdd_mvvm.models.Quote
import io.github.hmz9.tdd_mvvm.models.dao.QuotesDao

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao(): QuotesDao
}