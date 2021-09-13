package ru.sber.qa

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class ScannerTest{

    @Test
    fun `getScanData should throw an ScanTimeoutException for value 10000L-15000L`() {

        mockkObject(Random.Default)
        every { Random.nextLong(5000L, 15000L) } returns 12000L

        assertThrows(ScanTimeoutException::class.java) {
            Scanner.getScanData()
        }
    }

    @Test
    fun `getScanData should proceed without any exceptions for value 5000L-10000L`() {

        mockkObject(Random.Default)
        every { Random.nextLong(5000L, 15000L) } returns 6000L

        Scanner.getScanData()
    }

    @Test
    fun `getScanData should proceed without any exceptions for value 10000L`() {

        mockkObject(Random.Default)
        every { Random.nextLong(5000L, 15000L) } returns 10000L

        Scanner.getScanData()
    }
}
