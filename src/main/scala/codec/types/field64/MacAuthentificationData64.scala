package codec.types.field64

import scodec.bits.*
import scodec.*
import scodec.codecs.bytes

case class MacAuthentificationData64(`value`: ByteVector)

object MacAuthentificationData64 {
  val codec: Codec[MacAuthentificationData64] = bytes(8).as[MacAuthentificationData64]
}
