import com.streamer.twitter._

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers

import scala.collection.mutable.ArrayBuffer
import org.apache.commons.httpclient._

import org.apache.commons.httpclient.methods.PostMethod
import org.apache.commons.httpclient.methods.GetMethod

class StreamingMethodsSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  describe("Streaming Methods") {

    it("build a Get request with specified params") {
      val o = new OutputStreamProcessor
      val client = new StreamingClientSpecHelper("user", "password", o)
      val params = new ArrayBuffer[String]
        params += "count=10"
      val request = client.buildGet("www.github.com", params)
      request.getURI should be (new URI("www.github.com?count=10", false))
    }

    it("build a post request with specified params") {
      val o = new OutputStreamProcessor
      val client = new StreamingClientSpecHelper("user", "password", o)
      val params = new ArrayBuffer[NameValuePair]
        params += new NameValuePair("follow", "cool,works,awesome")
      val request = client.buildPost("www.github.com", params)
      request.getURI should be (new URI("www.github.com", false))
      request.getParameters.length should be (1)
      request.getParameter("follow") should be (new NameValuePair("follow", "cool,works,awesome"))
    }
  }
}
