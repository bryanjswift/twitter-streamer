import com.streamer.twitter._

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers

object BackOffSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  describe("Back Off strategy") {

    var backOff: BackOff = null

    before {
      backOff = BackOff(250, 16000)
    }

    it("set the correct backOffTime and capBackOffAt") {
      backOff.backOffTime should be (250)
      backOff.capBackOffAt should be (16000)
    }

    it("increment the back off time incrementally") {
      backOff.backOff
      backOff.backOffTime should be (500)
      backOff.backOff
      backOff.backOffTime should be (1000)
    }

    it("allow to reset the incremental back off time") {
      backOff.backOff
      backOff.backOffTime should be (500)
      backOff.reset()
      backOff.backOffTime should be (0)
    }
  }
}
