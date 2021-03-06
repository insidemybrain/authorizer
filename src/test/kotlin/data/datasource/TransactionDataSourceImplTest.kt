package data.datasource

import domain.model.Transaction
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis

class TransactionDataSourceImplTest {

    private lateinit var dataSource: TransactionDataSource

    @Before
    fun init() {
        dataSource =TransactionDataSourceImpl()
    }

    @Test
    fun testAddTransaction() {
        val transaction = Transaction("Burger King", 20, LocalDateTime.of(2019,2,13,11,0,0,0))
        assert(dataSource.addTransaction(transaction))
    }

    @Test
    fun testAddSameTransactionTwice() {
        val transaction = Transaction("Burger King", 20, LocalDateTime.of(2019,2,13,11,0,0,0))
        val sameTransaction = Transaction("Burger King", 20, LocalDateTime.of(2019,2,13,11,0,0,0))
        assert(dataSource.addTransaction(transaction))
        assertFalse(dataSource.addTransaction(sameTransaction))
    }

    @Test
    fun testGetAllTransactions() {
        val merchants = listOf("Burger King", "Uber Eats")
        val transactionsMax = 10
        for (i in 1..transactionsMax) {
            val transaction = Transaction(merchants.random(), i, LocalDateTime.now())
            dataSource.addTransaction(transaction)
        }
        assertFalse(dataSource.getTransactions().isEmpty())
    }

    @Test
    fun testGetAllTransactionsWithEmptyResponse() {
        assert(dataSource.getTransactions().isEmpty())
    }

}