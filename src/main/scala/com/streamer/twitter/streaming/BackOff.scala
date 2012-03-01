package com.streamer.twitter

/**
 * BackOff
 *
 * This class implements the waiting strategy when errors arise, and trust me, they will.
 */
case class BackOff(origBackOffTime: Long, capBackOffAt: Long) {
  private var _backOffTime = origBackOffTime

  def backOff = {
    Thread.sleep(_backOffTime)
    // Let's wait some more
    _backOffTime *= 2
    // Limit the wait to the specified cap
    if(_backOffTime > capBackOffAt) {
      _backOffTime = capBackOffAt
    }
  }

  def backOffTime = _backOffTime

  /**
   * After all errors are resolved (ie successful connection), we reset the sleeping counter.
   */
  def reset() = { _backOffTime = origBackOffTime }
}
