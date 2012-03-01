import com.streamer.twitter._

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers

class BackOffSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  describe("Back Off strategy") {

    var backOff: BackOff = null

    before {
      backOff = BackOff(250, 16000)
    }

    it("set the correct backOffTime and capBackOffAt") {
      val backOff = BackOff(250, 16000)
      backOff.backOffTime should be (250)
      backOff.capBackOffAt should be (16000)
    }

    it("increment the back off time incrementally") {
      val backOff = BackOff(250, 16000)
      backOff.backOff
      backOff.backOffTime should be (500)
      backOff.backOff
      backOff.backOffTime should be (1000)
    }

    it("allow to reset the incremental back off time") {
      val backOff = BackOff(250, 16000)
      backOff.backOff
      backOff.backOffTime should be (500)
      backOff.reset()
      backOff.backOffTime should be (backOff.origBackOffTime)
    }
  }
}
