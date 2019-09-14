import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UmbrellaTest {

    @Test
    fun totalPrice_sunnyDay(){
        val umbrella = Umbrella()

        val weather = mock(IWeather::class.java)
        `when`(weather.isSunny()).thenReturn(true)

        val actual = umbrella.totalPrice(weather, 3,100)
        val expected = 270
        Assert.assertEquals(expected, actual)
    }
}