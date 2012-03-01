import com.streamer.twitter._

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers

import scala.collection.mutable.ArrayBuffer
import org.apache.commons.httpclient._

import org.apache.commons.httpclient.methods.PostMethod
import org.apache.commons.httpclient.methods.GetMethod

object StreamingMethodsSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  describe("Streaming Methods") {

    var client: StreamingClientSpecHelper = null
    var o: OutputStreamProcessor = null

    before {
      o = new OutputStreamProcessor
      client = new StreamingClientSpecHelper("user", "password", o)
    }

    it("build a Get request with specified params") {
      val params = new ArrayBuffer[String]
        params += "count=10"
      val request = client.buildGet("www.github.com", params)
      request.getURI should be (new URI("www.github.com?count=10", false))
    }

    it("build a post request with specified params") {
      val params = new ArrayBuffer[NameValuePair]
        params += new NameValuePair("follow", "cool,works,awesome")
      val request = client.buildPost("www.github.com", params)
      request.getURI should be (new URI("www.github.com", false))
      request.getParameters.length should be (1)
      request.getParameter("follow") should be (new NameValuePair("follow", "cool,works,awesome"))
    }
  }
}
