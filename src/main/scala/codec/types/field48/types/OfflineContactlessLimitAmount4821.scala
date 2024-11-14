package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class OfflineContactlessLimitAmount4821(amount: Long) extends PrivateData48XX

object OfflineContactlessLimitAmount4821 {
  val codec: Codec[OfflineContactlessLimitAmount4821] = TLV_N(12).as[OfflineContactlessLimitAmount4821]
}
