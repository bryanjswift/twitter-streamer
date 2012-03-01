package com.streamer.twitter.config

import com.codahale.fig.Configuration
import org.apache.commons.codec.binary.Base64

object Config {

  val config = new Configuration("config/twitter-streamer.json")

  def getString(key: String) = config(key).as[String]

  def readString(key: String): String = config(key).or("")

  def readInt(key: String): Int = config(key).or(-1)

  def readBoolean(key: String): Boolean = config(key).or(false)

  def base64Decode(value: String) = {
    new String(new Base64().decode(value.getBytes))
  }

}
