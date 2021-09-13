package ru.sber.qa

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.DayOfWeek
import java.time.LocalDateTime

internal class HrDepartmentTest {

    @Test
    fun `receiveRequest should throw an WeekendDayException exception for LABOUR_BOOK on Saturday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.SATURDAY

        assertThrows(WeekendDayException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
        }
    }

    @Test
    fun `receiveRequest should throw an WeekendDayException exception for LABOUR_BOOK on Sunday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.SUNDAY

        assertThrows(WeekendDayException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
        }
    }

    @Test
    fun `receiveRequest should throw an WeekendDayException exception for NDFL on Saturday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.SATURDAY

        assertThrows(WeekendDayException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
        }
    }

    @Test
    fun `receiveRequest should throw an WeekendDayException exception for NDFL on Sunday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.SUNDAY

        assertThrows(WeekendDayException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
        }
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for NDFL on Monday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.MONDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for NDFL on Wednesday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.WEDNESDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for NDFL on Friday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.FRIDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
    }

    @Test
    fun `receiveRequest should throw an NotAllowReceiveRequestException for NDFL on Tuesday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.TUESDAY

        assertThrows(NotAllowReceiveRequestException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
        }
    }

    @Test
    fun `receiveRequest should throw an NotAllowReceiveRequestException for NDFL on Thursday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.THURSDAY

        assertThrows(NotAllowReceiveRequestException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.NDFL))
        }
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for LABOUR_BOOK on Monday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.MONDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for LABOUR_BOOK on Tuesday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.TUESDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
    }

    @Test
    fun `receiveRequest should throw an NotAllowReceiveRequestException for LABOUR_BOOK on Wednesday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.WEDNESDAY

        assertThrows(NotAllowReceiveRequestException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
        }
    }

    @Test
    fun `receiveRequest should proceed without any exceptions for LABOUR_BOOK on on Thursday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.THURSDAY

        HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
    }

    @Test
    fun `receiveRequest should throw an NotAllowReceiveRequestException for LABOUR_BOOK on Friday`() {

        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now(HrDepartment.clock).dayOfWeek } returns DayOfWeek.FRIDAY

        assertThrows(NotAllowReceiveRequestException::class.java) {
            HrDepartment.receiveRequest(CertificateRequest(10, CertificateType.LABOUR_BOOK))
        }
    }
}