package ru.sber.qa

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.Exception

internal class CertificateRequestTest {

    @Test
    fun `check null and ScanTimeoutException NDFL`() {
        val certificateRequest = CertificateRequest(10, CertificateType.NDFL)

        try {
            val numberCert = certificateRequest.process(12)
            assertNotNull(numberCert)
        } catch (e: Exception) {
            assertThrows(ScanTimeoutException::class.java) {
                throw e
            }
        }
    }

    @Test
    fun `check null and ScanTimeoutException LABOUR_BOOK`() {
        val certificateRequest = CertificateRequest(10, CertificateType.LABOUR_BOOK)

        try {
            val numberCert = certificateRequest.process(12)
            assertNotNull(numberCert)
        } catch (e: Exception) {
            assertThrows(ScanTimeoutException::class.java) {
                throw e
            }
        }
    }
}
