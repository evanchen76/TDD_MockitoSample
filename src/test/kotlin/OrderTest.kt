import org.junit.Assert
import org.junit.Test

import org.mockito.Mockito
import org.mockito.Mockito.*

class OrderTest {

    @Test
    fun insertOrder() {

        val order = Order()
        val mockEmailUtil = MockEmailUtil()

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //用mockEmailUtil.receiveEmail來驗證order.insert裡是否有呼叫IEmailUtil.setCustomer
        Assert.assertEquals(userEmail, mockEmailUtil.receiveEmail)
    }

    @Test
    fun insertOrderWithMockito() {

        val order = Order()
        val mockEmailUtil = Mockito.mock(IEmailUtil::class.java)

        val userEmail = "someMail@gmail.com"
        order.insertOrder(userEmail, 1, 200, mockEmailUtil)

        //驗證是否有呼叫sendCustomer，並傳入正確的userEmail
        verify(mockEmailUtil).sendCustomer(userEmail)

        verify(mockEmailUtil, times(1)).sendCustomer(userEmail)
    }
}