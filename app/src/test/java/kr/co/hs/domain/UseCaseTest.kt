package kr.co.hs.domain

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.robolectric.annotation.Config
import tech.apter.junit.jupiter.robolectric.RobolectricExtension


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@ExtendWith(RobolectricExtension::class)
@Config(sdk = [Config.OLDEST_SDK])
class UseCaseTest {
    @Test
    fun do_test_usecase() = runTest {
        val usecase = SimpleUseCase()

        val usecaseResult = usecase("text").first() as? UseCase.Result.Success
        assertNotNull(usecaseResult)
        val usecaseResultSuccess = usecaseResult?.data
        assertNotNull(usecaseResultSuccess)

        val entityText = usecaseResultSuccess?.text
        assertEquals("text", entityText)
        assertTrue(usecaseResultSuccess!!.isCachedData)
        assertFalse(usecaseResultSuccess.isRemoteData)
    }

    @Test
    fun do_test_no_error_usecase() = runTest {
        val usecase = SimpleNoErrorUseCase()

        val usecaseResult = usecase("text").first() as? NoErrorUseCase.Result.Success
        assertNotNull(usecaseResult)
        val usecaseResultSuccess = usecaseResult?.data
        assertNotNull(usecaseResultSuccess)
    }
}